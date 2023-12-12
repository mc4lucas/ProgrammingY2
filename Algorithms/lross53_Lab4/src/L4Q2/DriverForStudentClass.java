package L4Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 4-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: To work with comparable and use the order by comparator approach\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 4-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion

    public static void main(String[] args){
        myHeader(2); //Print Header

        ArrayList<Student> al = new ArrayList<>(); //Array list for students

        al.add(new Student()); //Adding a student to the arraylist
        al.add(new Student("Harry","Potter",75.5)); //Adding a student to the arraylist
        al.add(new Student("Ronald","Weasley",86.0)); //Adding a student to the arraylist
        al.add(new Student("Hermione","Granger",91.7)); //Adding a student to the arraylist
        al.add(new Student("Parvati","Patil",93.75)); //Adding a student to the arraylist

        System.out.println("The Score Card:\n"+al.toString()); //print the list

        Collections.reverse(al); //Reverse order of the array list

        System.out.println("\nThe sorted list in terms of score in descending order....\n"+al.toString()); //print the list

        Collections.sort(al, new HelperClassCompareLastNames());

        System.out.println("\nThe sorted list in terms of Last Names....\n"+al.toString()); //print the list

        Collections.sort(al, new HelperClassCompareFirstNames());

        System.out.println("\nThe sorted list in terms of First Names....\n"+al.toString()); //print the list

        myFooter(2); //Print footer
    }
}
