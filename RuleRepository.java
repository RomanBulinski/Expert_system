import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

/**
 * in constructur make hashmap in order to keep question from xml
 */
public class RuleRepository{

    private ArrayList <Question> rules;

    public RuleRepository(){
        rules = new ArrayList< Question>();
    }

    public Iterator getIterator(){
        return new QuestionIterator();
    }

    private class QuestionIterator implements Iterator {
          
        int index = 0;
        public boolean hasNext(){
            if( index < rules.size()){
                return true;
            }
            return false;
        }
        public Question next(){
            if(this.hasNext()){
                return rules.get(index++);
            }
            return null;
        }
    }

    public void addQuestion(Question question){
        rules.add(question);
    }

    /** 
    * help metod
    */
    public void printRulesRepository(){
        for ( Question question : rules){ 
            System.out.println(question);
            System.out.println(question.getId());
            System.out.println(question.getQuestion());
        }
    }

}
