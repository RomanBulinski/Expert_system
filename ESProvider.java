
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
        ruleParser.loadXmlDocument("Rules.xml");
        ruleRepository = ruleParser.getRuleRepository();
    }
 
    public void collectAnswers (){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" \nI will help you find out which country is recommended for you on holidays.\n"+
                            "Answer a few questions.\n"+
                            "------------------------------------");
        Iterator iteratorPoPytaniach = ruleRepository.getIterator();
        while(iteratorPoPytaniach.hasNext()){
            Question question = (Question)iteratorPoPytaniach.next();
            System.out.println("Question : "+question.getQuestion());
        
            String id = question.getId();

            boolean evaluatedAnswer = true;
            boolean flag = true;

            while(flag){
                try{
                    String answerFromTerminal = scanner.nextLine();
                    evaluatedAnswer = question.getEvaluatedAnswer(answerFromTerminal);
                    flag = false;
                }catch( IllegalArgumentException x){
                    System.out.println("Wrong answer, try again.");
                }
            }
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
            Integer counter = 0;
            for (String k : pytaniaIodpowiedzi.keySet()){
                if (temp.getPairIdValue().get(k).equals(pytaniaIodpowiedzi.get(k))) {
                    counter++;
                }
            }
            if (counter.equals((Integer)5) ){
                result = temp.getDescription() + " means, "+temp.getId();
                break;
            }else{
                result = "I have no idea. Your your requirements are impossible to meet.";
            }
        }
        return  result;
    }
}