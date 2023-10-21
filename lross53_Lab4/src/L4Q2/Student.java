package L4Q2;

public class Student {
    //region Private vars
    private Double score;
    private String firstName;
    private String lastName;
    //endregion

    //Constructor with arguments, setting the private vars to the user arguments
    public Student(String fN, String lN, Double scr){
        firstName = fN;
        lastName = lN;
        score = scr;
    };

    //Default constructor with my info
    public Student(){
        firstName = "Lucas";
        lastName = "Ross";
        score = 10.00;
    };

    public String toString(){
        return firstName + " " + lastName + ": " + String.format(".2f",score);
    };
}
