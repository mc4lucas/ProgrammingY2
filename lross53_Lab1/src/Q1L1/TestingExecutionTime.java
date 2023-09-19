package Q1L1;

public class TestingExecutionTime {
    
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 1-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: Checking the code-execution time!\n%s\n\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 1-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }

    public static long iterativeMethodForFactorial(int n){
        int i = 0; //
        while(n!=1){
            return iterativeMethodForFactorial(n-1);
        }
    }

    public static long recursiveMethodForFactorial(int n){ //Recursive approach to solving problem
        if(n<=1){//Base case
            return n;
        }else{ //If first option is invalid then repeat this function until it is valid
            return n * recursiveMethodForFactorial(n-1);
        }
    }

    public static void main(String[] main){
        System.out.println(recursiveMethodForFactorial(5));
    }
}
