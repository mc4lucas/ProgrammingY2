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


    public void addSeat(){
        //For the first seat
            if (size == 0){
            Seat newSeat = new Seat();
            newSeat.previous = head;
            newSeat.next = tail;

            head.next = newSeat;
            tail.previous = newSeat;

            size++; //Increment the size of the DLL
        }
        //For all consecutive seat
            if(size > 0){}
    }
}
