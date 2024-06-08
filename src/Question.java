import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//Abstraction
abstract class Question {
    //Data
    private String questionType;  //multiple choice or single choice
    protected static ArrayList<String> multiAnswer = new ArrayList<String>();
    protected static ArrayList<String> singleAnswer = new ArrayList<String>();

    //Methods
    //output answer types/options
    public void setQuestionType(String qType){
        this.questionType = qType;
    }

    public String getquestiontype(){
        return questionType;
    }

    //abstract methods
    public abstract void setAnswerTypes(String qType);
    public  abstract ArrayList getAnswerTypes();
}

class MultiChoice extends Question{
    public void setAnswerTypes(String qType){
        //set array abcd
        if (qType == "Multiple") {
            multiAnswer.clear();
            multiAnswer.add(0, "A");
            multiAnswer.add(1, "B");
            multiAnswer.add(2, "C");
            multiAnswer.add(3, "D");
        }
    }

    public ArrayList getAnswerTypes(){
        return multiAnswer;
    }
}

class OneChoice extends Question{
    public void setAnswerTypes(String qType){
        //set array 1,2
        if (qType == "Single") {
            singleAnswer.clear();
            singleAnswer.add(0, "1");
            singleAnswer.add(1, "2");
        }
    }
    
    public ArrayList getAnswerTypes(){
        return singleAnswer;
    }
}

