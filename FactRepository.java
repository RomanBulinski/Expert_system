
import java.util.Iterator;
import java.util.HashMap;
import java.util.*;
import java.io.*;


public class FactRepository {

    ArrayList<Fact> facts;

    public FactRepository(){
        facts = new ArrayList<Fact>();
 
    }
   
    public Iterator getIterator(){
        return new FactIterator();
    }

    private class FactIterator implements Iterator {
        int index = 0;
        public boolean hasNext(){
            if( index < facts.size()){
                return true;
            }
            return false;
        }
        public Fact next(){
            if(this.hasNext()){
                return facts.get(index++);
            }
            return null;
        }
    }

    public void addFact(Fact fact){
        facts.add(fact);
    }

    /*
    * help metod
    */
    public void printFactRepository(){
        for ( Fact fact  : facts){
            System.out.println(fact.getId());
            System.out.println(fact.getDescription());
        }
    }
    
    /*
    * help metod
    */
    public Fact getFact(int index){
        return facts.get(index);
    }




}