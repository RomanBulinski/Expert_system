/**
 * Question
 */
public class Question {

    String id;  
    String question;
    Answer answer = new Answer();

    
    public Question(String id, String question, Answer answer ){
        this.id = id;
        this.question = question;
        this.answer = answer;
    
        
    }

    public String getId(){
        return id;
    }

    public String getQuestion(){
        return question;
    }

    public Answer getAnswer(){
        return answer;

    }

    public boolean getEvaluatedAnswer(String input){
        if ( answer.toString() == input ){
            return true;
        }else{
            return false;
        }
    }

}
