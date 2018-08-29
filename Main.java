
import java.util.*;
import java.io.*;
import java.util.Iterator;

/**
 * Main
 */
public class Main {


    public static void main(String[] args) {
        
        System.out.println(" \nWhich country is recommended for you.\n ");

        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();

        ESProvider esProvider = new ESProvider(factParser, ruleParser);

        
       
    }
}