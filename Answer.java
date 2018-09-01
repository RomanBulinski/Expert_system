import java.util.*;
import java.util.Arrays;
import java.io.*; 
import java.util.Objects;


public class Answer {

    List<Value> valueList = new ArrayList<Value>();
    Value value;
    
    public void addValue(Value value){
        valueList.add(value);
    }

    public boolean evaluateAnswerByInput (String input) throws IllegalArgumentException{

        boolean result = true;

        Value tempValue1 = valueList.get(0);
        Value tempValue2 = valueList.get(1);

        if( (tempValue1.getInputPattern()).contains(input)){
            result = tempValue1.getSelectionType();
        }else if( (tempValue2.getInputPattern()).contains(input)){
            result = tempValue2.getSelectionType();
        }else{
            throw new IllegalArgumentException("It is not possible to compare.");
        }
        return result;
    }

    public List<Value> getValueList(){
        return valueList;
    }

}

