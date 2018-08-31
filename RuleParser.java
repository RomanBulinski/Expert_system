import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;

/**
 * These parsers are to be used to interpret the corresponding XML files (Rules.xml and Facts.xml).
 */
public class RuleParser extends XMLParser {

    public RuleRepository ruleRepository;
    
    public RuleParser(){
        ruleRepository = new RuleRepository();
    }

    public void loadXmlDocument(String xmlPath){
        
        try {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse( xmlPath );
            NodeList ruleList = doc.getElementsByTagName("Rule");
            for(int i=0;i<ruleList.getLength();i++){
                Element rule = (Element) ruleList.item(i);
                String ruleId = rule.getAttribute("id");
               
                NodeList questionList = rule.getElementsByTagName("Question");
                for (int z = 0; z < questionList.getLength(); ++z){
                    Element question = (Element) questionList.item(z);
                    String questionString = question.getFirstChild().getNodeValue();
                    Answer answer = new Answer();
                    Question questionObject = new Question( ruleId, questionString, answer );
                    ruleRepository.addQuestion(questionObject);
                }
            }
       
            Iterator iteratorPoQuestion = ruleRepository.getIterator();
            while(iteratorPoQuestion.hasNext()){
                for(int i=0;i<ruleList.getLength();i++){
                    Element rule = (Element) ruleList.item(i);
                    NodeList selectionList = rule.getElementsByTagName("Selection");
                    Question tempQuestion = (Question)iteratorPoQuestion.next();
                    Answer answer = tempQuestion.getAnswer();

                    for (int j = 0; j < selectionList.getLength(); ++j){
                        Element select = (Element) selectionList.item(j);
                        String selectionValue = select.getAttribute("value");
                        NodeList singleValue = select.getElementsByTagName("SingleValue");
                        for (int x = 0; x < singleValue.getLength(); ++x){
                            Element singleValu = (Element) singleValue.item(x);
                            String singleValuString = singleValu.getAttribute("value");
                            Value value = new SingleValue(singleValuString,Boolean.valueOf(selectionValue) );     
                            answer.addValue(value);
                        }
                        
                        NodeList multipleList = select.getElementsByTagName("MultipleValue");
                        for (int x = 0; x < multipleList.getLength(); ++x){
                            Element multipleValu = (Element) multipleList.item(x);
                            String mValuString = multipleValu.getAttribute("value");
                            String optionText = multipleValu.getFirstChild().getNodeValue();
                            String[] words = optionText.split(",");
                            List<String> wordsInarray = Arrays.asList(words);
                            Value value = new MultipleValue(wordsInarray,Boolean.valueOf(mValuString) );
                            answer.addValue(value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }


    /**
    * metoda zwraca obiect RuleRepository
    */
    public RuleRepository getRuleRepository(){
        return ruleRepository;
    }


}

