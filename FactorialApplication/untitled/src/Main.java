import java.nio.file.LinkPermission;
import java.util.Scanner;

public class Main {
    public static int entry = 0; // Variable for what the user enters

    public static Scanner input = new Scanner(System.in); // Scanner to find user input

    public static void main(String[] args){
        System.out.print("Enter an Integer: ");

        entry = input.nextInt();

        System.out.printf("\nThe Factorial is : %d", factorial(entry));;

    }

    public static int factorial(int num){
        if(num == 0){
            return 1;
        }else{
            return num * factorial(num-1);
        }
    }
}
