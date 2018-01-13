package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//SmartArrayDecorator
// Base array for decoratorsSmartArrayDecorator
public class BaseArray implements SmartArray{
    private List elements;

    public BaseArray(Object[] array){
        this.elements = new ArrayList<Object>(Arrays.asList(array));
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public String operationDescription() {
        return getElements().toString();
    }

    @Override
    public int size() {
        return getElements().size();
    }


    private List getElements() {
        return elements;
    }
}
