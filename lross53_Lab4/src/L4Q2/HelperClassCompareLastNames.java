package L4Q2;
import java.util.Comparator;
public class HelperClassCompareLastNames implements Comparator<Student>{
    public int compare(Student s1, Student s2){ //Overriding the compare method (order by comparator)
        return s1.getLastName().compareTo(s2.getLastName()); //Using the compareTo method to actually do it
    }
}
