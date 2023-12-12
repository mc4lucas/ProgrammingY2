package Q_LE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GenericsAndArrays_Lucas {
    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 2-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: Increase practice with using both Arrays and Generics\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 2-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion

    public static Scanner input = new Scanner(System.in);//Creating a scanner

    public static void main(String[] args){
        boolean satisfied = false; //Used to end loop

        myHeader(1); //Calling my header

        //region Intro
        System.out.println("This program prints the names of the student leaders from year 2, 3 and 4.\n" +
                "To see the list of the students from a specific year enter an integer between 2 and 4 when\n" +
                "prompted.\n");
        //endregion

        while(!satisfied){
            boolean valid = false; //Var for validation
            int entry = 0; //Var for user entry
            ArrayList<String> selection = new ArrayList<>(0); //Var for later use in printing

            //region Arrays
            ArrayList<Integer> years = new ArrayList<>(Arrays.asList(2,3,4,3,2,2)); //Creating an array list for the years value

            ArrayList<String> names = new ArrayList<>(Arrays.asList("Harry","Lavender","Ron","Hermione","Luna","Vincent")); //Creating an array list for names values

            Pair[] pairs = new Pair[years.size()]; //Array of pairs
            //endregion

            //region Setup
            int count = 0;//Incremental tool
            while(count < pairs.length){
                pairs[count] = new Pair(years.get(count),names.get(count)); //Set values from arraylists above
                count++; //Increment
            }

            System.out.print("Enter Academic Year (2, 3 or 4): "); //Request for input
            //endregion

            while(!valid){ //Validation check
                while(!input.hasNextInt()){ //Checks if the input is an int
                    System.out.print("Incorrect input! Enter Academic Year (2, 3 or 4): ");
                    input.next(); //Clear buffer
                }
                entry = input.nextInt(); //Receiving entry
                if(entry == 2 || entry == 3 || entry == 4){ //Checks if int is within spec
                    valid = true;
                }else{ //If not
                    System.out.print("Incorrect input! Enter Academic Year (2, 3 or 4): ");
                }
            }

            //region Search
            int count2 = 0; //Incremental tool
            while(count2 < pairs.length){ //This will add all the data matching the users entry request to the arraylist selection
                if(entry == (int)pairs[count2].getKey()){
                    selection.add((String)pairs[count2].getValue()); //Adding to selection
                }
                count2++; //Increment
            }
            //endregion

            System.out.printf("Found %d leader(s) from year %d.\nHere is the list:\n%s\n",selection.size(),entry,selection.toString());

            System.out.print("Do you wish to continue? (Press y to continue or any other key to terminate): ");
            char q = input.next().charAt(0);

            if(q == 89 || q == 121){
                satisfied = false; //continue loop
            }else{satisfied = true;}//end loop
        }

        myFooter(1); //Calling my footer
    }
}
