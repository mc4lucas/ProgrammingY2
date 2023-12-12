package LinkedLists;

public class Link {
    private int size = 0;
    private Node head = new Node("Head"); //Create the head of the link
    private Node tail = new Node("Tail"); //Create the tail of the link
    private Node selection = head;

    public void link(){
        head.setRightPointer(tail); //Set the right pointer of head
        head.setLeftPointer(tail); //Set the left pointer of head

        tail.setRightPointer(head); //Set the right pointer of tail
        tail.setLeftPointer(head); //Set the left pointer of tail
    }

    public void addNode(String packet){ //Going to add at end
        selection = head;

        for(int i = 0; i < size; i++){
            selection = selection.getRightPointer(); //Traverses to the end of the linked list
        }

        Node newNode = new Node(packet);
        selection.setRightPointer(newNode); //Add in the new node

        newNode.setRightPointer(tail); //Connect the right side of the new node
        newNode.setLeftPointer(selection); //Connect the left side of the new node

        tail.setLeftPointer(newNode); //Re-link the tail

        size++;
    }

    public String toString(){
        selection = head; //Reset the selection
        String toReturn="";

        for(int i = 0; i < (size + 2); i++){
            toReturn = toReturn + selection.getData();

            if(i != size+1){
                toReturn = toReturn + " ---> ";
            }

            selection = selection.getRightPointer(); //Jump right one node
        }

        return toReturn;
    }
}
