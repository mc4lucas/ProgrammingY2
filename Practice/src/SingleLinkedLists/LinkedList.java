package SingleLinkedLists;

import java.util.ArrayList;
import java.util.Collections;

public class LinkedList <E>{
    private Node<E> tail;
    private Node<E> head;
    private int size = 0;
    public void addNode(E data){

        Node<E> newNode = new Node<>(data,tail); //Creating a new node


        if(size == 0){ //If it is the first node in the SLL
            tail = newNode; //Set as both tail and head
            head.next = newNode;

            size++; //Increment
        }else{ //If it is not the first node in the SLL
            newNode.next = head.next; //Set the next node for this node to be the current head
            head.next = newNode; //Replace the head with this new node

            size++; //Increase the total size of the SLL
        }
    } //adds a node to the front

    //region Getter / Setter methods
    public Node<E> getTail(){return tail;} //Getter method for the tale of the SLL

    public Node<E> getHead(){return head;} //Getter method for the head of the SLL

    //Default Constructor
    public LinkedList(){
        head = new Node<E>(null,null);
        tail = new Node<E>(null,null);
        head.next = tail;
    }

    @Override
    public String toString(){
        int pos = 0;
        ArrayList<E> al = new ArrayList<>();
        Node<E> current = head.next;

        while(pos < size){
            al.add(current.data);

            current = current.next; //Jump to next node

            pos++; //Increment
        }

        Collections.reverse(al); //Fix that sheet

        return al.toString();
    }
}
