//Each class has a rational, they are in a /* */ comment, so they may be shrunk! this one starts on line 3!

/*
RATIONAL FOR THIS CLASS

This class pulls all the other classes together into one application. If I were re-doing this assignment I would probably have seperated the "CASES" into separate classes
to provide more structure and clean up this class a bit as it is very large. The other major change I would have made would be to use for-loops instead of while loops. I
have always used while loops as I have never found a need to use for loops (I also like while loops for debugging), but this is by far the largest program I have made, and it is
clear now that for-loops would be a lot safer as they would for sure iterate and close properly.
 */

package LA5Q;

import java.util.Scanner;

public class Driver {
    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 5-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: To work with linear data structures and create a passenger boarding and disembarking application.\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 5-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion

    //region Variables
        private static boolean inApplication = true; //Loop Exit variable
        private static Scanner input = new Scanner(System.in); //Input retriever
    //endregion

    static Plane newPlane = new Plane(3,2); //Creating my plane

    public static void main(String[] args){

        myHeader(1); //Header
        while(inApplication){ //Used to end application when requested
            makeRequest(); //Calling my selection method
        }
        myFooter(1); //Footer

    }

    public static void makeRequest(){ //This class will verify the user input and run the proper methods required for the selection of the user
        System.out.println("what would you like to do?\n\na) Board Passenger\nb) Check Seat\nc) Disembark Passenger\nd) View Plane\ne) Exit Program\nf) Create New Plane");

        switch (input.next().charAt(0)){ //Used to verify input from the user
            case 'a':
                //region Case A
                    int row; //Storage var
                    int seat = 0; //Storage var


                    printPlane(); //Displays the current seating arrangement

                //Row Selection

                    row = pickRow();

                //Seat Selection

                    while(seat < 1 || seat > newPlane.getSeats()){
                        System.out.println("What seat would you like to board in?");
                        seat = input.nextInt();

                        if (seat < 1 || seat > newPlane.getSeats()) {
                            System.out.println("Invalid entry! Please try again:\n"); //Data validation
                        }

                        //Check that seat is vacant
                        if(!newPlane.getSeat(row,seat).checkVacancy()){ //Check if the seat is vacant or not
                            System.out.println("This seat is not Vacant! Please refer back to the map and enter a seat that is vacant!");

                            boolean pick = false;

                            while(!pick){
                                System.out.println("\nIf you would like to change rows enter - A, Otherwise enter - B");
                                switch (input.next().charAt(0)){
                                    case 'A':
                                        pickRow(); //Reselect row
                                        pick = true;
                                        break;
                                    case 'B':
                                        seat = 0;
                                        pick = true;
                                        break;
                                    default: //Called if the user enters an invalid entry
                                        System.out.println("Invalid Entry!");
                                        break;
                                }
                            }
                        }
                    }

                //Actually do something

                    Seat currentAccessor = newPlane.getSeat(row,seat); //Creating a reference to the selected seat
                    currentAccessor.setVacancy(false); //Get the requested seat

                input.nextLine(); //Clear Buffer

                    System.out.print("Enter the First Name of the Passenger:");
                    currentAccessor.setFirstName(input.nextLine()); //This sets the first name in the node

                    System.out.print("Enter the Last Name of the Passenger:");
                    currentAccessor.setLastName(input.nextLine()); //This sets the first name in the node

                //Add this stuff here


                    //System.out.println(newPlane.getSeat(row,seat).checkVacancy()); //BUG TESTING
                    //seatToModify.setNonVacant(); //Changes the vacancy on the seat

                    printPlane();

                break;
                //endregion
            case 'b':
                row = 0;//Reset
                    while(row < 1 || row > newPlane.getRows()){ //These validate that the input are within reason
                        System.out.print("Enter a row:");
                        row = input.nextInt();
                        if(row < 1 || row > newPlane.getRows()){
                            System.out.println("Invalid Entry! Please try again");
                        }
                    }
                seat = 0;//Reset
                    while(seat < 1 || seat > newPlane.getSeats()){
                        System.out.print("Enter a seat:");
                        seat = input.nextInt();
                        if(seat < 1 || seat > newPlane.getSeats()){
                            System.out.println("Invalid Entry! Please try again");
                        }
                    }

                    if(newPlane.getSeat(row,seat).checkVacancy()){
                        System.out.println("\nThat seat is Vacant!\n");
                    }else{
                        System.out.println("\nShowing the information of the passenger in row: " + row + " Seat: " + seat + "\nName: " + newPlane.getSeat(row,seat).getName() + "\n");
                    }

                break;
            case 'c':
                    row = 0;//Reset
                    while(row < 1 || row > newPlane.getRows()){ //These validate that the input are within reason
                        System.out.print("Enter a row:");
                        row = input.nextInt();
                        if(row < 1 || row > newPlane.getRows()){
                            System.out.println("Invalid Entry! Please try again");
                        }
                    }
                    seat = 0;//Reset
                    while(seat < 1 || seat > newPlane.getSeats()){
                        System.out.print("Enter a seat:");
                        seat = input.nextInt();
                        if(seat < 1 || seat > newPlane.getSeats()){
                            System.out.println("Invalid Entry! Please try again");
                        }
                    }

                    Seat currentSeat = newPlane.getSeat(row,seat); //Storing the current seat

                    currentSeat.setVacancy(true); //Change vacancy
                    currentSeat.setFirstName(null); //Remove the first name
                    currentSeat.setLastName(null); //Remove the last seat

                    System.out.println("Removed the passenger");
                break;
            case 'd':
                    printPlane();
                break;
            case 'e':
                    inApplication = false; //Terminate program
                break;
            case 'f':
                System.out.println("Enter the number of rows in your new plane: ");
                int rows = input.nextInt();
                System.out.println("Enter the number of seats for each row in your new plane: ");
                int seats = input.nextInt();

                newPlane = new Plane(rows,seats); //Re-creating the plane with new dimensions

                System.out.println("Your new plane has been created!");
                break;
            default:
                    System.out.println("Invalid Input! Please try again\n\n");
                break;
        }
    }

    public static void printPlane(){
        int i = 1; //Incrementor for rows
        int j; //Incrementor for seats
        int x = 1; //Incrementor for seat pos
        int z = 1; //Incrementor for row pos

        System.out.println("\nHere is the current seating map:\n\n----------------------------------");

        while(i < newPlane.getRows()+1){
            System.out.print(ANSI.ANSI_YELLOW + "   Row " + i + "   " + ANSI.ANSI_RESET);
            i++; //Increment
        } //Print the row headers

        while(x < newPlane.getSeats() + 1){
            i = 1; //Reset Incrementor
            System.out.println("\n"); //Move to next line

            while(i < newPlane.getRows() + 1){
                System.out.print("   Seat " + z + "  ");
                i++; //Increment
            }
            z++; //Increment seat position

            i = 1; //Reset Incrementor
            j = 1; //Reset Incrementor
            System.out.println(" "); //Move to next line

            //while(i < newPlane.getSeats() + 1){
                while(j < newPlane.getRows() + 1){
                    Seat currentAccessor = newPlane.getSeat(j,x); //Getting the current seat


                    //System.out.print(currentAccessor.checkVacancy() + " " + currentAccessor.seatNumber);//Debugging


                    if(currentAccessor.checkVacancy()){
                        System.out.print(ANSI.ANSI_GREEN + "   Vacant  " + ANSI.ANSI_RESET); //This option is selected when there is no passenger in the seat
                    }
                    else if(!currentAccessor.checkVacancy()){
                        System.out.print(ANSI.ANSI_RED + "  Occupied " + ANSI.ANSI_RESET); //This option is selected when there is a passenger in the seat
                    }
                    j++; //Incrementor
                }
                //i++; //Incrementor
                j = 1;
            //}
            x++; //Incrementor
        }

        System.out.println("\n----------------------------------\n");
    }

    public static int pickRow(){
        int row = 0; //Storage var

        while(row < 1 || row > newPlane.getRows()){
            System.out.println("What row would you like to board in?");
            row = input.nextInt();

            if(row < 1 || row > newPlane.getRows()){System.out.println("Invalid entry! Please try again:\n");} //Data verification
        }

        return row;
    }

}
