package ua.edu.ucu.smartarr;

import java.util.List;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public int size() {
        return this.smartArray.toArray().length;
    }

    @Override
    public String operationDescription() {
        return "SOme string";
    }
}
