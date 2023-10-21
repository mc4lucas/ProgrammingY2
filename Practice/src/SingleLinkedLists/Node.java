package SingleLinkedLists;

public class Node <E>{
    public E data; //Any generic data to be stored in the node
    public Node<E> next; //Next Link

    //Constructor for a node
    public Node(E dataToAdd , Node<E> nextNode){
        data = dataToAdd; next = nextNode;
    }
}
