/*
RATIONAL FOR THIS CLASS

I chose to use a double linked list for the seats portion of the plane. The reason i did this instead of just using a 2d array is because I find that by using a linked list
you have more expandability for the future. The linked list is an easier method of inserting and removing data in my opinion as it does not require a complete recreation
as apposed to if you were using arrays. That would be especially bad as you would have to array copy a 2d array which would be very cumbersome. I also specifically chose
a double linked list instead of a single. The reasoning for this is because with a double linked list you can traverse in two directions, forward and back. Although I am
only ever adding from the rear and pulling information from the front, since this application is dynamic, if you had 100 rows and seats, and you wanted to access seat 99, you
could then start your search from the rear of the linked list instead of the front, in addition to searching from the front if it were seat 1.
 */


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
