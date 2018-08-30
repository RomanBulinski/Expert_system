import java.util.*;

/**
 * Fact 
 */
public class Fact  {

    private String id;
    private String descritption;
    private Set<String> idSet = new HashSet<>();
    private Map<String , Boolean > pairIdValue = new HashMap<>();
    private String idValue;
    private boolean bolleanValue; 

    
    public Fact(String id, String descritption ){
        this.id = id;
        this.descritption = descritption;
    }

    public String getId(){
        return id;
    }

    public Set<String> getIdSet(){
        return pairIdValue.keySet();
    }

    public Collection<Boolean> getVelueSet(){
        return pairIdValue.values();
    }

    public void setFactValueById(String idValue, Boolean bolleanValue ){
        pairIdValue.put(idValue,bolleanValue);

    }

    public boolean getValueById(String id){
        Boolean value = pairIdValue.get(id);
        return value;
    }

    public String getDescription(){
        return descritption;
    }

    
    public Map<String , Boolean > getPairIdValue(){
        return pairIdValue;
    }

}