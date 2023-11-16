package LE6Q1;
import java.util.*;

public class LucasTestingSortingMethods {
    private static long time;

    public static <T extends Comparable <? super T>>long selectionSort(T[] a){ //Selection sort method that will return an execution time
        time = System.nanoTime(); //Log the start time

        int posInArray = 0;
        int locationOfMin = 0;
        T placeholder;

        for(int j=0; j<a.length; j++){ //Calling the nested function for a length of the array
            for (int i=j; i<a.length; i++) { //Replacing the minimum value once
                if (a[i].compareTo(a[locationOfMin]) < 0 /* Less than zero is implying that the a[i] is less than currentMin */) {
                    locationOfMin = i; //Replace the new current min
                }
            }

            placeholder = a[posInArray]; //Move the current index to a bucket
            a[posInArray] = a[locationOfMin]; //Place the minimum in the current position in array
            a[locationOfMin] = placeholder; //Replace the moves position with the bucket value

            locationOfMin = ++posInArray; //Reset the default pos
        }

        return System.nanoTime()-time; //Return the time it took to execute SelectionSort Algorithm
    }







    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 6-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: To test execution time of different sorting methods for sorting 5 random numbers.\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 6-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion

    public static void main(String[] args) {
        myHeader(1); //Calling my header

        int sz = 5; //Variable for the array size to be dynamic in future
        Integer[] primaryArray = new Integer[sz]; //Creating the first array
        Integer[] backupArray = new Integer[sz]; //Backup array

        //Populate the first array with random values
        for (int i = 0; i < primaryArray.length; i++) {
            primaryArray[i] = (int) (80 * Math.random() + 13);
        }

        //copy the array values to the backup array
        System.arraycopy(primaryArray, 0, backupArray, 0, primaryArray.length);

        //Convert the array to a list to use the asList() method
        List<Integer> list = Arrays.asList(primaryArray);

        //Start printing the results
        System.out.println("Testing execution time of different sorting methods for sorting " + sz + " random numbers:");

        //region Collections Sorting
        System.out.printf("The unsorted list: %S\n", list.toString()); //Prints the unsorted list
        time = System.nanoTime(); //Takes a time stamp
        Collections.sort(list); //Sorts the list
        System.out.printf("Collections' Sorting Time: %s milliseconds\n", ((System.nanoTime() - time) / (Math.pow(10, 6)))); //Calculates the time taken to sort the list
        System.out.printf("The sorted list using Collections' sort method: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        //region SelectionSort
        System.out.printf("\nThe unsorted list: %S\n", list.toString()); //Prints the unsorted list
        System.out.printf("My Selection-Sort Time: %s milliseconds\n",selectionSort(primaryArray));
        System.out.printf("The sorted list using selection-sort: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        myFooter(1); //Calling my footer
    }
}
