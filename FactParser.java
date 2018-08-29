
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.util.*;
import java.io.*;
import java.util.Iterator;


/**
 * These parsers are to be used to interpret the corresponding XML files (Rules.xml and Facts.xml).
 * 
 */
public class FactParser extends XMLParser {

    public FactRepository factRepository = new FactRepository();
    
    public void loadXmlDocument(String xmlPath){
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlPath);
            NodeList elemenFactList = doc.getElementsByTagName("Fact");

            for(int i=0;i<elemenFactList.getLength();i++){
                Element elemenFact = (Element) elemenFactList.item(i);
                String idText = elemenFact.getAttribute("id");
                NodeList descriptionList = elemenFact.getElementsByTagName("Description");
                for (int z = 0; z < descriptionList.getLength(); ++z){
                    Element elementdescr = (Element) descriptionList.item(z);
                    String elementdescrText = elementdescr.getAttribute("value");
                    Fact fact = new Fact(idText, elementdescrText );
                    factRepository.addFact(fact);
                }
            } 

            Iterator iteratorPoFactach = factRepository.getIterator();
            while(iteratorPoFactach.hasNext()){
                for(int i=0; i<elemenFactList.getLength();i++){
                    Element elemenFact = (Element) elemenFactList.item(i);
                    Fact temp  = (Fact)iteratorPoFactach.next();
                    NodeList evalList = elemenFact.getElementsByTagName("Eval");
                    for (int j = 0; j < evalList.getLength(); ++j){
                        Element eval = (Element) evalList.item(j);
                        String evalId = eval.getAttribute("id");
                        String evalText = eval.getFirstChild().getNodeValue();
                        temp.setFactValueById(evalId, Boolean.valueOf(evalText) );
                    }  
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }      
        
    /**
     * Zwraca obiekt klasy FactRepository ktory jest Arraylista z obiektami Fact.
     */
    public FactRepository getFactRepository(){
        return factRepository;
    }

}





