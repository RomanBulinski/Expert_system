
import java.util.*;
import java.io.*;
import java.util.Iterator;


/**
 * Main
 */
public class Main {


    public static void main(String[] args) {
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();

        ESProvider esProvider = new ESProvider(factParser, ruleParser);

        esProvider.collectAnswers();
        System.out.println("---------------------------------------------");
        System.out.println("I recommend for you : "+esProvider.evaluate());
        System.out.println("---------------------------------------------");

    }
}