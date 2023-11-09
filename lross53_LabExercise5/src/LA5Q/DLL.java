package LA5Q;

public class DLL {
    private Seat head;
    private Seat tail;
    private int size = 0;

    public DLL(){
        //region create the ends of the DLL
            head = new Seat();
            tail = new Seat();
        //endregion

        //Set the defaults for the DLL
        head.next = tail;
        head.previous = tail;
        tail.next = head;
        tail.previous = head;
    }


    public void addSeat(int row, int seat){
        //System.out.println("At  Row = " + row + "Seat = " + seat + "Size = " + size);//Debug
        //For the first seat
        if (size == 0){
            Seat newSeat = new Seat(row,seat); //Creating a new seat
            newSeat.previous = head; //Linking the new seat to the head
            newSeat.next = tail; //Linking the new seat to the tail

            head.next = newSeat; //Linking the head to the new seat
            tail.previous = newSeat; //Linking the tail to the new seat
        }
        //For all consecutive seat

                            //Method of adding last

        if(size > 0){
            Seat newSeat = new Seat(row,seat); //Creating a new seat

            newSeat.previous = tail.previous; //Linking the new seat to the seat that was in front of the tail
            tail.previous.next = newSeat; //Reconnecting the old seat to the new seat
            tail.previous = newSeat; //Reassigning the tail to be behind the new seat
            newSeat.next = tail; //Linking the new seat to the tail
        }

        size++; //Increment the size of the DLL
    } //Method that creates a new seat in the row of the plane

    public Seat getSeat(int seat){
        Seat seatToReturn = head; //Storage var

        int i = 0; //Incrementor

        while(i < seat){
            seatToReturn = seatToReturn.next;
            i++; //Increment
        }

        return seatToReturn; //Returns the requested seat
    }
}
