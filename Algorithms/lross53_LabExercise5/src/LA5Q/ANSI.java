/*
RATIONAL FOR THIS CLASS

The purpose of this class is to add color to the output. Although it is not necessary I found that it made the program more presentable
and increased the understanding of the printPlane method.
 */


package LA5Q;

public class ANSI {

    //This class is used to color text in the output

    public static final String ANSI_RESET = "\u001B[0m"; //Resets the color of the output
    public static final String ANSI_YELLOW = "\u001B[33m"; //Makes the output color yellow
    public static final String ANSI_GREEN = "\u001B[32m"; //Makes the output color green
    public static final String ANSI_RED = "\u001B[31m"; //Makes the output color red
}
