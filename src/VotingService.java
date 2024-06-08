//inheritance?

import java.util.ArrayList;
import java.util.Random;

public abstract class VotingService {
    //data: given question type and candidate answers (from Question)
    private ArrayList<String> submissions = new ArrayList<String>();

    //methods/output: student submissions & stats (from iVote/Student)
    public ArrayList generateSubmissions(Student stu, ArrayList choices){
        submissions.clear();
        var list = stu.getStuIDList();

        //get() random int between 0 and answertype arraysize -> assign value to submissions
        Random rand = new Random();
        int min = 0;
        int max = choices.size() - 1;   //can be either answertype [1, 2] or [A, B, C. D]

        for(int i = 0; i < list.size(); i++){
            int randChoice = rand.nextInt((max - min) + 1) + min; //generates a random value w/in the answertype array
            submissions.add(choices.get(randChoice).toString());
        }
        return submissions;
    }

    public abstract void submissionStats(ArrayList stuSubs, String qType); //method broken down into 2 subclasses
}


class MultiChoiceVote extends VotingService{
    public void submissionStats(ArrayList stuSubs, String qType){
        //questiontype is multiplechoice
        if (qType == "Multiple") { 
            int aCount =0, bCount = 0, cCount = 0, dCount = 0;
            for(int x = 0; x < stuSubs.size(); x++){
                switch (stuSubs.get(x).toString()) {    //accessing array of student answer submissions, switch case to count each answer
                    case "A":
                        aCount +=1;
                        break;
                    case "B":
                        bCount +=1;
                        break;
                    case "C":
                        cCount +=1;
                        break;
                    case "D":
                        dCount +=1;
                        break;
                
                    default:
                        break;
                }
            }
            System.out.println("Student Multiple Choice Submission Results");
            System.out.println("A: " + aCount);
            System.out.println("B: " + bCount);
            System.out.println("C: " + cCount);
            System.out.println("D: " + dCount);
        }
    }
}

class SingleChoiceVote extends VotingService{
    public void submissionStats(ArrayList stuSubs, String qType){
        //questiontype is true/false
        if (qType == "Single") {
            int oneCount = 0, twoCount = 0;
            for(int x = 0; x < stuSubs.size(); x++){    //accessing array of student answer submissions, switch case to count each answer
                switch (stuSubs.get(x).toString()) {
                    case "1":
                        oneCount +=1;
                        break;
                    case "2":
                        twoCount +=1;
                        break;
                    default:
                        break;
                }
            }
            System.out.println("Student True/False Choice Submission Results");
            System.out.println("1. True: " + oneCount);
            System.out.println("2. False: " + twoCount);
        }
    }
}