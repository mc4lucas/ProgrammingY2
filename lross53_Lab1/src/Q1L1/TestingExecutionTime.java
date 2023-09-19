package Q1L1;

public class TestingExecutionTime {
    
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 1-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: Checking the code-execution time!\n%s\n\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 1-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
}
