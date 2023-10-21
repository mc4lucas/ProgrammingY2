package ObjectComparison;
import ObjectComparison.Objects.*;

import java.util.ArrayList;
import java.util.Collections;

public class MainMethod {
    public static void main(String[] args){

        //Creating objects to compare
        Circle c1 = new Circle(15.23);
        Rectangle r1 = new Rectangle(12.21,14.3);

        ArrayList<GeometricObject> al = new ArrayList<>(); //Crating an arraylist to store all the objects

        //Add the objects to the arraylist
        al.add(c1);
        al.add(r1);

        Collections.sort(al, new NewCompare()); //Sort the objects by largest area

        System.out.println("\n\nThe order of Geometric Objects from greatest to least is:\n\n\t" + al.toString()); //Print the arraylist

        Collections.reverse(al); //Reverse the order of al

        System.out.println("\n\nThe order of Geometric Objects from least to greatest is:\n\n\t" + al.toString()); //Print the arraylist
    }
}
