package LA3Q1;

import java.util.Scanner;

public class DemoStackAndQueue_Lucas {
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
                System.out.println(e + "Invalid Entry! Please choose one of these options below:");
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
                System.out.println(e + "Invalid Entry! Please choose one of these options below:");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args){
        stackDemo(new LucasArray());
    }
}
