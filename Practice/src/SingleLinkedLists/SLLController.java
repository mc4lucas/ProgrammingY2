package SingleLinkedLists;

import java.util.Collections;

public class SLLController {
    public static void main(String[] args){

        LinkedList<String> myList = new LinkedList<>(); //Creating a link list with data type of string

        //Add nodes to the link-list
        myList.addNode("Hello");
        myList.addNode("There");
        myList.addNode("Sir");
        myList.addNode("Moe");

        System.out.println(myList.toString());
    }
}
