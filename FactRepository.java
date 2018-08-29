
import java.util.Iterator;
import java.util.HashMap;
import java.util.*;
import java.io.*;


/*
 * FactRepository - tworzez instacje Set do ktorej moge dodoac obiekty typu  Fact
 */
public class FactRepository {

    ArrayList<Fact> facts;
    /*
    *  konstroktor inicjalizouje pole ( arrayliste  ) ktora przechowuje obiekty klasy Fact
    */
    public FactRepository(){
        facts = new ArrayList<Fact>();
 
    }
    /*
    * iteruje po ArrayLisicie czyli po obiekcie FactREpository przechowujacej obiekty klasy Fact
    */
    public Iterator getIterator(){
        return new FactIterator();
    }

    private class FactIterator implements Iterator {
        int index = 0;
        public boolean hasNext(){
            if( index < facts.size() ){
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
    /*
    *  w czasie dynamicznego tworzenia arraylisty dodaje do tej listy obiekty klasy Fact
    */
    public void addFact(Fact fact){
        facts.add(fact);
    }
    /*
    * metoda pomocnicza
    */
    public void printFactRepository(){
        for ( Fact fact  : facts){
            System.out.println(fact.getId());
            System.out.println(fact.getDescription());
        }
    }
    
    /*
    * metoda pomocnicza
    */
    public Fact getFact(int index){
        return facts.get(index);
    }




}