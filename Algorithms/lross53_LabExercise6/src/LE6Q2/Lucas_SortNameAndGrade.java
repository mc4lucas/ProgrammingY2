package LE6Q2;

import java.util.Collections;
import java.util.Vector;

public class Lucas_SortNameAndGrade {

    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 6-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: To work with vectors and modify the insertion Sort method to work with different strings.\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 6-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion


    public static void main(String[] args){
        myHeader(2); //Call the header

        //region Array Creation
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"}; //Array of first names creation
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"}; //Array of last names creation
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26)}; //Array of grades created
        //endregion

        Vector<StudentGrade> sg = new Vector<>(); //Vector class to store student grades

        for(int i=0; i< fnArray.length; i++){
            sg.add(new StudentGrade(fnArray[i],lnArray[i],grd[i]));
        } //populate the vector class

        System.out.println("The Unsorted Array ................\n" + sg+"\b"); //Print the first unsorted array

        Collections.sort(sg); //Sort the sg vector class using collections

        System.out.println("Sorted by Grades ................\n" + sg+"\b"); //Print the collections sorted array


        StudentGrade[] array = new StudentGrade[fnArray.length]; //Creating an array of the student grades, currently empty
        sg.copyInto(array); //Copy the sg contents to the new array

        //Sort by first names
        insertionSort(array,1);
        printArray(1,array); //Print the array

        System.out.println(" ");

        //Sort by last names
        insertionSort(array,2);
        printArray(2,array); //Print the array

        myFooter(2); //Call the footer
    }


    public static <T extends Comparable <? super T>>void insertionSort(StudentGrade[] a, int key) {
        StudentGrade temp; //Bucket
        int j = 1; //De-incrementor

        //For first names
        if (key == 1) {
            for (int i = 1; i < a.length; i++) {

                j = i - 1;//Temp incrementor

                while (j >= 0 && a[j + 1].getFirstName().compareTo(a[j].getFirstName()) < 0) {
                    temp = a[j + 1]; //Store temp
                    a[j + 1] = a[j]; //Replace 2 with 1
                    a[j] = temp; //Replace 1 with 2
                    temp = null; //Clean up

                    j = j - 1; //Decrease
                }
            }
        }

        //For Last Names
        if (key == 2) {
            for (int i = 1; i < a.length; i++) {

                j = i - 1;//Temp incrementor

                while (j >= 0 && a[j + 1].getLastName().compareTo(a[j].getLastName()) < 0) {
                    temp = a[j + 1]; //Store temp
                    a[j + 1] = a[j]; //Replace 2 with 1
                    a[j] = temp; //Replace 1 with 2
                    temp = null; //Clean up

                    j = j - 1; //Decrease
                }
            }
        }
    }

    public static void printArray(int key, StudentGrade[] array){
        String type; //Storage var

        if(key==1){type = "First Names";} //For first name print
        else{type = "Last Names";} //For last name print


        System.out.println("Sorted by " + type +  ".............");
        for(int i=0; i<array.length; i++){
            System.out.println(String.format("\b\b%9s %-8s \t:\t\t%d",array[i].getFirstName(),array[i].getLastName(),array[i].getGrade()));
        }
    }
}
