/*
RATIONAL FOR THIS CLASS

For the rows portion of this I chose to use an array. The reasoning for this was because I already intended to use a double linked list for the seats which I thought
would take a very long time to get working. I could have also used a linked list for the rows, especially if you ever wanted to search bidirectionally if the plane were
ever large enough to warrant it. Instead, I used an array as it is quite easy to implement, and it is not nearly as large as the seats so its complexity did not need
to be very high in my opinion.
 */

package LA5Q;

public class Plane {
    private int rows;
    private int seats;
    private DLL[] planeRows = new DLL[0];


    public Plane(int rows, int seats){
        this.rows = rows;
        this.seats = seats;

        planeRows = new DLL[rows];

        int i = 1; //Incrementor for row creation
        int j = 1; //Incrementor for seat creation


        while(i < rows + 1){ //Creating the rows of the plane
            //System.out.println("Working on row " + i); //Debug
            DLL List = new DLL(); //Creating a new double linked list
            planeRows[i-1] = List; //Adding the dll to the rows array


            while(j < seats + 1){
                List.addSeat(i,j); //Creating the seat

                j++; //incrementing to use in seat creation
            }

            i++; //Increment the rows ahead of time to use this in the seat creation process
            j=1; //Reset j
        }
    }

    public int getRows(){
        return this.rows;
    } //Method to get the number of rows in the plane
    public int getSeats(){return this.seats;} //Method to get the number of seats in each row

    public Seat getSeat(int row, int seat){
        return planeRows[row-1].getSeat(seat); //Finds the seat in the DLL
    }
}
