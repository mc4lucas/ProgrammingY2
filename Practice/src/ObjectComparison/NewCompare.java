package ObjectComparison;
import java.util.Comparator; //Implementing Order by Comparator -This is the compare method
public class NewCompare implements Comparator<GeometricObject>{
    @Override
    public int compare(GeometricObject obj1, GeometricObject obj2){ //Overriding the compare method from Order by Comparator
        Double obj1Area = obj1.getArea();
        Double obj2Area = obj2.getArea();

        return obj2Area.compareTo(obj1Area); //Using compareTo method to compare the geometric objects area's
    }
}
