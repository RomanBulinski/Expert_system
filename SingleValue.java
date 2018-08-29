
import java.util.*;
/**
 * SingleValue
 */
public class SingleValue extends Value {
    
    List<String> params;
    boolean selectionType;
    String param;
    
    public SingleValue(String param, boolean selectionType){
        this.param = param;
        this.selectionType = selectionType;
    }
    
    public List<String> getInputPattern(){
        return params;
    }
    
    public boolean getSelectionType(){
        return selectionType;
    }

    public String getParam(){
        return param;
    }
}