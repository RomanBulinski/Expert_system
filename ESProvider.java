
import java.util.*;
import java.io.*;
import java.util.Iterator;


/**
 * ESProvider
 */
public class ESProvider {

        FactRepository factRepository;
        RuleRepository ruleRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser){

        factParser.loadXmlDocument("Facts.xml");
        FactRepository listOfFact = factParser.getFactRepository();
        Iterator iteratorPoFactach = listOfFact.getIterator();
        
        while(iteratorPoFactach.hasNext()){
            Fact temp  = (Fact)iteratorPoFactach.next();
            System.out.println(temp.getId()+" "+temp.getDescription());
            System.out.println(temp.getIdSet());
            System.out.println(temp.getVelueSet());
            System.out.println("jedzenie : "+temp.getValueById("jedzenie"));
        }
        
        System.out.println("------------------------------------------------------");   

        ruleParser.loadXmlDocument("Rules.xml");
        RuleRepository listOfRules = ruleParser.getRuleRepository();
        Iterator iteratorPoPytaniach = listOfRules.getIterator();

        while(iteratorPoPytaniach.hasNext()){
            Question temp = (Question)iteratorPoPytaniach.next();
            System.out.println("id: "+temp.getId()+" pytanie: "+temp.getQuestion());
            System.out.println("    odpowiedz: "+temp.getAnswer() );

            

        } 


    }






    public void collectAnswers (){

    }


    public boolean getAnswerByQuestion(String question){

            return true;
    }

    public String evaluate(){

        return "bla bla";
}


}