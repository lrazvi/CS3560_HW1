//abstract class? private answers

import java.util.ArrayList;
import java.util.Random;

public class Student {
    //Data: student class size
    private int classSize;
    private static ArrayList<String> studentIDs = new ArrayList<String>();

    public void setClassSize(int size){
        this.classSize = size;
    }

    public int getClassSize(){
        return classSize;
    }

    //Method/output: generate stuIDs
    public void generateStuIDs(int size){
        studentIDs.clear();
        int min = 1000; 
        int max = 9999;
        Random stuID = new Random();

        for(int i = 0; i < size;){
            var num = Integer.toString(stuID.nextInt((max - min) + 1) + min);
            if (!studentIDs.contains(num)) {
                studentIDs.add(i, num);
                i ++;
            }
            else{ i +=0;}
        }
    }

    public ArrayList getStuIDList(){
        return studentIDs;
    }
}
