
public class SimulationDriver {
        //randomly generate studentIDs & answers

    public static void main(String[] args) throws Exception {
        //Question 1 Multiple Choice
        Question q1 = new MultiChoice();
        q1.setQuestionType("Multiple");
        var q1Type = q1.getquestiontype();
        q1.setAnswerTypes(q1Type);
        var q1AnsType = q1.getAnswerTypes();

        //student class, size 50
        Student student1 = new Student();
        student1.setClassSize(50);
        var stu1Size = student1.getClassSize();
        student1.generateStuIDs(stu1Size);
        //voting submission for student1 q1
        VotingService v1 = new MultiChoiceVote();
        var stu1Subs = v1.generateSubmissions(student1, q1AnsType);
        v1.submissionStats(stu1Subs, q1Type);

        //same student class, different question type: true/false question 
        Question q2 = new OneChoice();
        q2.setQuestionType("Single");
        var q2Type = q2.getquestiontype();
        q2.setAnswerTypes(q2Type);
        var q2AnsType = q2.getAnswerTypes();
        //voting submission for student1 q2
        VotingService v2 = new SingleChoiceVote();
        var stu2Subs = v2.generateSubmissions(student1, q2AnsType);
        v2.submissionStats(stu2Subs, q2Type);
    }
}


//my notes before starting code

//define a question, question type, answer choices

//Student: randomly generate students & IDS,

//Voting: takes in question type & answer choices, and stuID list
    //generates answers for each stuID
    //outputs statistics; counts stuIDs associated w/ each answer

//SimDriver: set ques & questype, initialize an amt of students
    //call Student to generate stuID list
    //call VoteSim to output results (student answers & statistics)