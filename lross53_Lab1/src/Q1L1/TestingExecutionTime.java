package Q1L1;

import java.util.Scanner;

public class TestingExecutionTime {
    public static Scanner input = new Scanner(System.in);

    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 1-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: Checking the code-execution time!\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 1-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion

    public static double iterativeMethodForFactorial(int n){
        int i = 1; //Iteration Var
        double result = n; //Storage Var

        while(i<n){
            result = result * i; //Factorial Formula
            i++;
        }
        return result;
    }

    public static double recursiveMethodForFactorial(int n){ //Recursive approach to solving problem
        if(n<=1){//Base case
            return n;
        }else{ //If first option is invalid then repeat this function until it is valid
            return n * recursiveMethodForFactorial(n-1);
        }
    }

    public static void main(String[] args){
        double pastTime = 0; //First time position to calculate elapsed time
        double currentTime = 0; //Second time position to calculate elapsed time


        myHeader(1); //Calling the header


        //region First Statement & Validation
        System.out.print("Enter an integer number: ");
        int validation = input.nextInt(); //Receiving user input

        while(validation < 0){ //Checks if the entered int is greater or equal to zero
            System.out.println("An error has occurred, ensure the entered int is greater than zero.");

            System.out.print("Enter an integer number: ");
            validation = input.nextInt(); //Receiving user input
        }
        //endregion


        //region first calculation
        pastTime = System.nanoTime(); //Taking timestamp 1
        System.out.printf("Factorial (%d) is %.3e\n",validation,iterativeMethodForFactorial(validation)); //Calculating factorial with iterative
        currentTime = System.nanoTime(); //Taking time stamp 2
        System.out.printf("Time taken by iterative solution inside main: %.3e sec\n",((currentTime-pastTime)/1e+9)); //Calculating change in time stamp 1 to 2 and converting to seconds
        //endregion


        //region second calculation
        pastTime = System.nanoTime(); //Taking timestamp 1
        System.out.printf("Factorial (%d) with iterative method is %.3e\n",validation,iterativeMethodForFactorial(validation)); //Calculating factorial with iterative
        currentTime = System.nanoTime(); //Taking time stamp 2
        System.out.printf("Time taken by iterative method call: %.3e sec\n",((currentTime-pastTime)/1e+9)); //Calculating change in time stamp 1 to 2 and converting to seconds
        //endregion

        //region second calculation
        pastTime = System.nanoTime(); //Taking timestamp 1
        System.out.printf("Factorial (%d) with recursive call is %.3e\n",validation,recursiveMethodForFactorial(validation)); //Calculating factorial with recursive
        currentTime = System.nanoTime(); //Taking time stamp 2
        System.out.printf("Time taken by recursive method call: %.3e sec\n",((currentTime-pastTime)/1e+9)); //Calculating change in time stamp 1 to 2 and converting to seconds
        //endregion

        myFooter(1);
    }
}
