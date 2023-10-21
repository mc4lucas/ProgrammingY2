package L4Q1;

public class MyStudent {
    private String firstName = null;
    private Double score = null;

    //Default constructor as required
    public MyStudent(){
        firstName = "Lucas";
        score = 10.00;
    }

    //Creating a constructor that takes a user defined input and stores the values in the private vars
    public MyStudent(String name, Double scr){
        firstName = name;
        score = scr;
    }

    //Returns an overridden String
    public String toString(){
        return firstName + ": " + String.format("%.2f",score);//String.format("Format you want", Variable to format into string)
    }
}
