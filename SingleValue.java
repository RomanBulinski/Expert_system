
import java.util.*;
/**
 * SingleValue
 */
public class SingleValue extends Value {
    
    List<String> params = new ArrayList<String>();
    boolean selectionType;
    // String param;
    
    public SingleValue(String param, boolean selectionType){
        params.add(param);
        this.selectionType = selectionType;
    }
    
    public List<String> getInputPattern(){
        return params;
    }
    
    public boolean getSelectionType(){
        return selectionType;
    }

}