package LE6Q2;

public class StudentGrade implements Comparable<StudentGrade>{
    private String firstName;
    private String lastName;
    private int grade;

    //Constructors
    StudentGrade(){} //Default constructor

    StudentGrade(String fn, String ln, int grade){
        firstName = fn;
        lastName = ln;
        this.grade = grade;
    } //Constructor with arguments

    //region Getter methods
    public String getFirstName(){return firstName;} //Getter for first name
    public String getLastName(){return lastName;} //Getter for last name
    public int getGrade(){return grade;} //Getter for grade
    //endregion

    //region Setter Methods
    public void setFirstName(String fn){firstName = fn;} //Sets the first name
    public void setLastName(String ln){lastName = ln;} //Sets the last name
    public void setGrade(int grade){this.grade = grade;} //Sets the grade
    //endregion

    public int compareTo(StudentGrade other) {
        return Double.compare(this.grade,other.grade);
    }

    @Override
    public String toString() { //Changes the to string method
        return String.format("\b\b%9s %-8s \t:\t\t%d\n",firstName,lastName,grade);
    }
}
