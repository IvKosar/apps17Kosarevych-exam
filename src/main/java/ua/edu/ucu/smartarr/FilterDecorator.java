package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.List;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate){
        super(smartArray);
        this.predicate = predicate;
    }
    @Override
    public Object[] toArray() {
        List newArray = new ArrayList<Object>();
        for(Object element:this.smartArray.toArray()){
            if (predicate.test(element)){
                newArray.add(element);
            }
        }
        return newArray.toArray();
    }

    public MyPredicate getPredicate() {
        return predicate;
    }
}
