package LA5Q;

public class Plane {
    private int rows;
    private int seats;
    private DLL[] planeRows = new DLL[0];


    public Plane(int rows, int seats){
        this.rows = rows;
        this.seats = seats;

        planeRows = new DLL[rows];

        int i = 0; //Incrementor for row creation
        int j = 0; //Incrementor for seat creation


        while(i < rows){ //Creating the rows of the plane

            DLL List = new DLL(); //Creating a new double linked list
            planeRows[i] = List; //Adding the dll to the rows array


            i++; //Increment the rows ahead of time to use this in the seat creation process

            while(j < seats){
                j++; //Pre incrementing to use in seat creation

                List.addSeat(i,j); //Creating the seat
            }
        }
    }

    public int getRows(){
        return this.rows;
    } //Method to get the number of rows in the plane
    public int getSeats(){return this.seats;} //Method to get the number of seats in each row

    public Seat getSeat(int row, int seat){
        return planeRows[row].getSeat(seat); //Finds the seat in the DLL
    }
}
