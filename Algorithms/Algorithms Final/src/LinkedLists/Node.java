package LinkedLists;

public class Node {
    private String data;
    private Node leftPointer;
    private Node rightPointer;

    //region Constructors
    public Node(){
        data = null;
        leftPointer = null;
        rightPointer = null;
    }

    public Node(String packet){
        data = packet;
        leftPointer = null;
        rightPointer = null;
    }
    //endregion

    //region Getter Methods
    public Node getLeftPointer(){
        return leftPointer;
    }
    public Node getRightPointer(){
        return rightPointer;
    }
    public String getData(){
        return data;
    }
    //endregion

    //region Setter Methods
    public void setLeftPointer(Node lp){
        leftPointer = lp;
    }
    public void setRightPointer(Node rp){
        rightPointer = rp;
    }
    public void setData(String packet){
        data = packet;
    }
    //endregion
}
