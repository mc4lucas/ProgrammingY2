package LA5Q;

public class Seat {
    //region Passenger Data
        private String firstName;
        private String lastName;
        private int seatNumber;
        private char seatRow;
    //endregion

    //region Node Information
        public Seat previous;
        public Seat next;
    //endregion

    //region Constructors
        public Seat(){ //Constructor with no arguments
            firstName = null;
            lastName = null;
            seatNumber = 0;
            seatRow = 0;
        }
}
