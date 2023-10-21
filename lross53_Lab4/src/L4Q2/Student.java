package L4Q2;
import java.util.Comparator;

public class Student implements Comparable<Student>{ //Implementing the comparable interface
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

    //Overridden toString method
    public String toString(){
        return firstName + " " + lastName + ": " + String.format(".2f",score);
    };

    //Overridden compareTo method
    public int compareTo(Student s){
        if (s.score > score){
            return 1;
        }
        else if (s.score<score) {
            return -1;
        }
        else{
            return 0;
        }
    }

    public Double getScore(){return score;} //Returns the score
    public void setScore(Double scr){score = scr;} //Sets the score based on a passed param

    public String getFirstName(){return firstName;} //Returns the first name
    public void setFirstName(String fN){firstName = fN;} //Sets the first name based on passed param

    public String getLastName(){return lastName;} //Returns the last name
    public void setLastName(String lN){lastName = lN;} //Sets the last name based on passed param
}
