package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator){
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        List inputList = new ArrayList<Object>(Arrays.asList(this.smartArray.toArray()));
        Collections.sort(inputList, comparator);
        return inputList.toArray();
    }
}
