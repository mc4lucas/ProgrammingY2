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

    public static <T extends Comparable <? super T>>long bubbleSort(T[] a){
        time = System.nanoTime(); //Take time stamp
        T temp; //Bucket

        for(int j=0; j<a.length; j++){
            for(int i=0; i< a.length-1; i++){
                if(a[i].compareTo(a[i+1]) > 0){ //If 1 is greater than 2
                    temp = a[i]; //Store temp
                    a[i] = a[i+1]; //Replace 1 with 2
                    a[i+1] = temp; //Replace 2 with 1
                    temp = null; //Clean up
                }
            }
        }

        return System.nanoTime() - time; //Return the time taken for the algorithm to execute
    }

    public static <T extends Comparable <? super T>>long insertionSort(T[] a){
        time = System.nanoTime(); //Take time stamp
        T temp; //Bucket
        int j = 1; //De-incrementor


        for(int i=1; i<a.length; i++){

            j = i-1;//Temp incrementor

            while(j >= 0 && a[j+1].compareTo(a[j]) < 0){
                temp = a[j+1]; //Store temp
                a[j+1] = a[j]; //Replace 2 with 1
                a[j] = temp; //Replace 1 with 2
                temp = null; //Clean up

                j = j - 1; //Decrease
            }
        }

        return System.nanoTime() - time; //Return the time taken to sort
    }

    public static <T extends Comparable <? super T>>long mergeSort(T[] a){
        time = System.nanoTime(); //Time stamp

        int mid = (a.length)/2; //Gives the middle point of array

        T[] left = Arrays.copyOfRange(a,0,mid); //Copy array a from pos 0 to pos mid
        T[] right = Arrays.copyOfRange(a,mid,a.length); //Copy array a from the middle to the end of array a

        if(left.length > 1){ //Check if the current left array is greater than 1 item
            mergeSort(left); //Recursively separate array 1

        }
        if(right.length > 1){ //Check if the current right array is greater than 1 item
            mergeSort(right); //Recursively separate array 2
        }

        int i=0,j=0; //Pos vars
        while(i+j < a.length){ //While there are elements to merge
            if(j == right.length || (i < left.length && left[i].compareTo(right[j]) < 0)){ //Checks and compares the first element of each side
                a[i+j] = left[i++]; //Merge left
            }else{
                a[i+j] = right[j++]; //Merge right
            }
        }

        return System.nanoTime() - time; //Return the time taken to sort the array
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] s, int a, int b){
        if(a>=b)
            return;

        int left = a; //Set the left limit
        int right = b-1; //Set the right limit

        T pivot = s[b]; //Set your pivot
        T temp; //Storage var

        while(left <= right){
            while(left <= right && pivot.compareTo(s[left]) >= 0){++left;}
            while(left <= right && s[right].compareTo(pivot) >= 0){--right;}

            if(left < right){
                temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                ++left;
                --right;
            }
        }
        temp = s[left];
        s[left] = s[b];
        s[b] = temp;

        quickSort(s,a,left-1);
        quickSort(s,left + 1,b);
    }
    public static long bucketSort(Integer[] a, int first, int last, int maxDigits) {
        time = System.nanoTime(); //Take a timestamp

        Vector<Integer>[] bucket = new Vector[10]; //One bucket for each number

        for(int i=0; i < 10; i++){
            bucket[i] = new Vector<>();
        }
        for(int i=0; i< maxDigits; i++){
            for(int j=0; j<10; j++){
                bucket[j].removeAllElements();
            }
            for(int index = first; index<=last; index++){
                Integer digit = findDigit(a[index],i);
                bucket[digit].add(a[index]);
            }
            int index = 0;
            for(int m = 0; m < 10; m++){
                for(int n=0; n<bucket[m].size(); n++){
                    a[index++] = bucket[m].get(n);
                }
            }
        }

        return System.nanoTime()-time; //Return the time taken
    }
    public static Integer findDigit(int number, int i){
        int target = 0;
        for(int k=0; k<= i; k++){
            target = number % 10;
            number = number /10;
        }

        return target;
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
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", ((System.nanoTime() - time) / (Math.pow(10, 6)))); //Calculates the time taken to sort the list
        System.out.printf("The sorted list using Collections' sort method: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        //region SelectionSort
        System.out.printf("\nThe unsorted list: %S\n", list.toString()); //Prints the unsorted list
        System.out.printf("My Selection-Sort Time: %.2f milliseconds\n",selectionSort(primaryArray) / (Math.pow(10, 6)));
        System.out.printf("The sorted list using Selection-Sort: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        //region BubbleSort
        System.out.printf("\nThe unsorted list: %S\n", list.toString()); //Prints the unsorted list
        System.out.printf("My Bubble-Sort Time: %.2f milliseconds\n",bubbleSort(primaryArray) / (Math.pow(10, 6)));
        System.out.printf("The sorted list using Bubble-Sort: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        //region InsertionSort
        System.out.printf("\nThe unsorted list: %S\n", list.toString()); //Prints the unsorted list
        System.out.printf("My Insertion-Sort Time: %.2f milliseconds\n",insertionSort(primaryArray) / (Math.pow(10, 6)));
        System.out.printf("The sorted list using Insertion-Sort: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        //region MergeSort
        System.out.printf("\nThe unsorted list: %S\n", list.toString()); //Prints the unsorted list
        System.out.printf("My Merge-Sort Time: %.2f milliseconds\n",mergeSort(primaryArray) / (Math.pow(10, 6)));
        System.out.printf("The sorted list using Merge-Sort: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        //region QuickSort
        time = System.nanoTime(); //Take timestamp
        quickSort(primaryArray,0, primaryArray.length-1);
        System.out.printf("\nThe unsorted list: %S\n", list.toString()); //Prints the unsorted list
        System.out.printf("My Quick-Sort Time: %.2f milliseconds\n",((System.nanoTime()-time) / (Math.pow(10, 6))));
        System.out.printf("The sorted list using Quick-Sort: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        //region BucketSort
        System.out.printf("\nThe unsorted list: %S\n", list.toString()); //Prints the unsorted list

        long timeDiff = LucasTestingSortingMethods.bucketSort(primaryArray,0,primaryArray.length-1,2);

        System.out.printf("My Bucket-Sort Time: %.2f milliseconds\n",timeDiff / (Math.pow(10, 6)));
        System.out.printf("The sorted list using Bucket-Sort: %s\n", list.toString()); //Prints the sorted list

        System.arraycopy(backupArray, 0, primaryArray, 0, backupArray.length); //Reset the primary array
        //endregion

        myFooter(1); //Calling my footer
    }
}
