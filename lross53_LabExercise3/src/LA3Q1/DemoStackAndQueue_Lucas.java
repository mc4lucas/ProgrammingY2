package LA3Q1;

import java.util.Scanner;

public class DemoStackAndQueue_Lucas {
    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 2-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: To demonstrate the understanding of the Stack and Queue data\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 3-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion
    public static Scanner input = new Scanner(System.in); //Scanner to receive user input

    public static void stackDemo(LucasArray array){
        System.out.println("You have an empty stack: " + array.toString());

        boolean exit = false; //Variable to end loop when user is done
        while(!exit){
            System.out.println("Stack Operation Menu:\na) Push\nb) Pop\nc) Exit");
            try{ //Method used to validate entry
               char entry = input.next().charAt(0);
               if(entry == 'a'){ //Push
                   input.nextLine();//Clearing buffer

                   int year = 0; //Vars for storage
                   String name = null;


                   System.out.print("Enter Year: "); //Request year
                   year = input.nextInt();

                   input.nextLine();//Clearing buffer

                   System.out.print("Enter Name: "); //Request name
                   name = input.nextLine();

                   Pair x = new Pair(year,name);//Creating a new pair to send to array

                   array.addAtLastIndex(x);//Adding new pair to array

                   System.out.println("The current stack: " + array.toString()); //Print out current array
               } //For Push
               else if (entry == 'b') { //Pop
                   if(array.getSize() == 0){ //Check if the stack is empty
                       System.out.println("FYI: The Stack is empty");
                   }else {
                       System.out.println(array.removeFromLastIndex() + " is removed! The current stack: " + array.toString()); //prints out the popped array
                   }
               } //For Pop
               else if (entry == 'c') { //Exit
                   exit = true; //end
               } //For Exit
               else{
                   throw new Exception("");
               } //Exception Handling
            }catch(Exception e){
                System.out.println("Invalid Entry! Please choose one of these options below:");
                input.nextLine();
            }
        }
    }

    public static void queueDemo(LucasArray array){
        System.out.println("You have an empty stack: " + array.toString()); //Prints empty stack

        boolean exit = false; //Variable to end loop when user is done
        while(!exit){
            System.out.println("Queue Operation Menu:\na) Push\nb) Pop\nc) Exit");
            try{ //Method used to validate entry
                char entry = input.next().charAt(0);
                if(entry == 'a'){ //Push
                    input.nextLine();//Clearing buffer

                    int year = 0; //Vars for storage
                    String name = null;


                    System.out.print("Enter Year: "); //Request year
                    year = input.nextInt();

                    input.nextLine();//Clearing buffer

                    System.out.print("Enter Name: "); //Request name
                    name = input.nextLine();

                    Pair x = new Pair(year,name);//Creating a new pair to send to array

                    array.addAtLastIndex(x);//Adding new pair to array

                    System.out.println("The current queue: " + array.toString()); //Print out current array
                } //For Push
                else if (entry == 'b') { //Pop
                    if(array.getSize() == 0){ //Check if the stack is empty
                        System.out.println("FYI: The Queue is empty");
                    }else {
                        System.out.println(array.removeFromFirstIndex() + " is removed! The current queue: " + array.toString()); //prints out the popped array
                    }
                } //For Pop
                else if (entry == 'c') { //Exit
                    exit = true; //end
                } //For Exit
                else{
                    throw new Exception("");
                } //Exception Handling
            }catch(Exception e){
                System.out.println("Invalid Entry! Please choose one of these options below:");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args){
        myHeader(1); //Calling my header method

        LucasArray x = new LucasArray(); //Creation of array

        boolean exit = false; //Variable to end loop when user is done
        while(!exit){
            System.out.println("Main Demo-Menu:\n1) Stack\n2) Queue\n3) Exit");
            try{ //Method used to validate entry
                char entry = input.next().charAt(0);
                if(entry == '1'){ //Push
                   stackDemo(x);
                } //For Push
                else if (entry == '2') { //Pop
                   queueDemo(x);
                } //For Pop
                else if (entry == '3') { //Exit
                    exit = true; //end
                } //For Exit
                else{
                    throw new Exception("");
                } //Exception Handling
            }catch(Exception e){
                System.out.println("Invalid Entry! Please choose one of these options below:");
                input.nextLine();
            }
        }
    }
}
