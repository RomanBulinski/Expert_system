
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

    Map < String, Boolean> answersAndQuestions = new HashMap< String,Boolean >();

    public ESProvider(FactParser factParser, RuleParser ruleParser){

        factParser.loadXmlDocument("Facts.xml");
        factRepository = factParser.getFactRepository();
        ruleParser.loadXmlDocument("Rules.xml");
        ruleRepository = ruleParser.getRuleRepository();
    }
 
    public void collectAnswers (){
        Scanner scanner = new Scanner(System.in);
        Iterator iteratorPoPytaniach = ruleRepository.getIterator();
        int counter = 1;
        while(iteratorPoPytaniach.hasNext()){
            Question question = (Question)iteratorPoPytaniach.next();
            System.out.println("  "+counter + ". Question : "+question.getQuestion());
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
            System.out.println("  "+evaluatedAnswer);
            answersAndQuestions.put(id,evaluatedAnswer);
            counter++;
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
            for (String k : answersAndQuestions.keySet()){
                if (temp.getPairIdValue().get(k).equals(answersAndQuestions.get(k))) {
                    counter++;
                }
            }
            if (counter.equals((Integer)5) ){
                result = temp.getDescription() + " means, "+temp.getId();
                break;
            }else{
                result = "I have no idea. Your requirements are impossible to meet.";
            }
        }
        return  result;
    }

    public void printDottedLine(){
        System.out.println("\n");
        for (int  i =0; i < 5; i++){
            System.out.print("-");
        }
        System.out.print(" * ");
        for (int  i =0; i < 5; i++){
            System.out.print("-");
        }
        System.out.println("\n");
    }
    
    public void summary(){
        printDottedLine();
        System.out.println( "  I will help you find out which country is recommended for you on holidays.\n"+
        "  Answer a few questions.");
        printDottedLine();
        collectAnswers();
        printDottedLine();
        System.out.print("  I recommend for you : "+ evaluate());
        printDottedLine();
    }
}