import java.util.*;

/**
 * MultipleValue
 */
public class MultipleValue extends Value {

    List<String> params;
    boolean selectionType;

    public MultipleValue(List<String> params, boolean selectionType){
        this.params = params;
        this.selectionType = selectionType;
    }
    
    public List<String> getInputPattern(){
        return params;
    }
    
    public boolean getSelectionType(){
        return selectionType;
    }

}