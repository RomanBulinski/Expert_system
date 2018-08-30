
import java.util.*;
import java.io.*;
import java.util.Iterator;
import java.util.Arrays;

/**
 * ESProvider
 */
public class ESProvider {

    FactRepository factRepository = new FactRepository();
    RuleRepository ruleRepository = new RuleRepository();

    Map < String, Boolean> pytaniaIodpowiedzi = new HashMap< String,Boolean >();

    public ESProvider(FactParser factParser, RuleParser ruleParser){

        factParser.loadXmlDocument("Facts.xml");
        factRepository = factParser.getFactRepository();
        // FactRepository listOfFact = factParser.getFactRepository();
        ruleParser.loadXmlDocument("Rules.xml");
        ruleRepository = ruleParser.getRuleRepository();
    }

    
    public void collectAnswers (){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println(" \nI will help you find out which country is recommended for you on holidays.\n"+
                            "Answer a few questions.\n");

        Iterator iteratorPoPytaniach = ruleRepository.getIterator();
        while(iteratorPoPytaniach.hasNext()){
            Question question = (Question)iteratorPoPytaniach.next();
            System.out.println("Question : "+question.getQuestion());
        
            String answerFromTerminal = scanner.nextLine();

            String id = question.getId();
            Boolean evaluatedAnswer = question.getEvaluatedAnswer(answerFromTerminal);
            System.out.println(evaluatedAnswer);
            pytaniaIodpowiedzi.put(id,evaluatedAnswer);
        }
        scanner.close();
    }

    public boolean getAnswerByQuestion(String question){
            return true;
    }

    public String evaluate(){
        String result = "";
        Iterator iteratorPoFactach = factRepository.getIterator();
        while(iteratorPoFactach.hasNext()){
            Fact temp  = (Fact)iteratorPoFactach.next();
            if (temp.getPairIdValue().equals(pytaniaIodpowiedzi) ){
                result = temp.getDescription() + " means : "+temp.getId() ;
            }
    
        }
        System.out.println("I recommend : "+result);
        return  result;
    }

}