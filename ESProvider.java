/**
 * ESProvider
 */
public class ESProvider {

        FactRepository factRepository;
        RuleRepository ruleRepository ;

    public ESProvider(FactParser factParser, RuleParser ruleParser){
        factRepository = factParser.getFactRepository();
        ruleRepository = ruleParser.getRuleRepository();
    }

  

    public void collectAnswers (){

    }


    public boolean getAnswerByQuestion(String question){

            return true;
    }

    public String evalutae(){

        return "bla bla";
}


}