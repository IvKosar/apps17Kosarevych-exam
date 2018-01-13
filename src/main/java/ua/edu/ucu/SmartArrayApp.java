package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;
import java.util.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        MyPredicate myPredicateForCourse = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2;
            }
        };

        MyPredicate myPredicateForGrade = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getGPA() >= 4;
            }
        };

        MyComparator myComparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student)o1).getSurname().compareTo(((Student)o2).getSurname());
            }
        };

        MyFunction myFunction = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student)t).getSurname() + " " + ((Student)t).getName();
            }
        };

        SmartArray studentsArray = new BaseArray(students);
        studentsArray = new DistinctDecorator(studentsArray);
        studentsArray = new FilterDecorator(studentsArray, myPredicateForCourse);
        studentsArray = new FilterDecorator(studentsArray, myPredicateForGrade);
        studentsArray = new SortDecorator(studentsArray, myComparator);
        studentsArray = new MapDecorator(studentsArray, myFunction);

        Object[] result = studentsArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)
        };
        System.out.println(SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students).toString());
    }
}
