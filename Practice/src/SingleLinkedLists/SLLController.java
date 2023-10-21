package SingleLinkedLists;
public class SLLController {
    public static void main(String[] args){

        LinkedList<Double> myList = new LinkedList<>(); //Creating a link list with data type of string

        //Add nodes to the link-list
        myList.addNode(27.00);
        myList.addNode(52.8);
        myList.addNode(78.21);
        myList.addNode(12.74);

        System.out.println(myList.toString());
    }
}
