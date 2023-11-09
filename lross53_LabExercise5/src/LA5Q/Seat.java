package LA5Q;

public class Seat {
    //region Passenger Data
        private String firstName;
        private String lastName;
        private int seatNumber;
        private int seatRow;

        private boolean vacant;
    //endregion

    //region Node Information
        public Seat previous;
        public Seat next;
    //endregion

    //region Constructors
        public Seat(int row, int seat){ //Constructor with arguments
            firstName = null;
            lastName = null;
            vacant = true;
            seatNumber = seat;
            seatRow = row;
        }

        public Seat(){ //Constructor with no arguments
            firstName = null;
            lastName = null;
            vacant = true;
            seatNumber = 0;
            seatRow = 0;
        } //Default constructor

    //endregion

    //region Getter Methods
        public boolean checkVacancy(){
            return vacant;
        } //Returns whether the seat is vacant or not
}
