package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyPredicate;

import java.util.*;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray){
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] inputList = this.smartArray.toArray();
        Set newArray = new HashSet<Object>(new ArrayList<>(Arrays.asList(inputList)));
        return newArray.toArray();
    }
}
