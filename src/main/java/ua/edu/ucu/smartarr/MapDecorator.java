package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function){
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        List inputList = new ArrayList<Object>(Arrays.asList(this.smartArray.toArray()));
        List newArray = new ArrayList();
        for (Object element:inputList){
            newArray.add(this.function.apply(element));
        }
        return newArray.toArray();
    }
}
