package ua.edu.ucu.smartarr;

import java.util.List;

public interface SmartArray {

    Object[] toArray(); // return array with SmartArray elements

    String operationDescription(); // return current operation name applied to SmartArray
    
    int size(); // return SmartArray size
   
}
