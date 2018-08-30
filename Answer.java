import java.util.*;
import java.util.Arrays;
import java.io.*; 
import java.util.Objects;



/**
 * Answer
 */
public class Answer {

    List<Value> valueList = new ArrayList<Value>();
    Value value;
    
    public void addValue(Value value){
        valueList.add(value);
    }

    public boolean evaluateAnswerByInput (String input) throws IllegalArgumentException{

        String[] inputAnwser = input.split(",");
        List<String> inputAnwserInArrays = Arrays.asList(inputAnwser);
        
        boolean result = true;

        Value tempValue1 = valueList.get(0);
        Value tempValue2 = valueList.get(1);

        if( inputAnwserInArrays.equals(tempValue1.getInputPattern())){
            result = tempValue1.getSelectionType();
        }else if( inputAnwserInArrays.equals(tempValue2.getInputPattern())){
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