package LinkedLists;

public class Main {
    public static void main(String[] args){
        Link linkedList = new Link();

        linkedList.addNode("Lucas");
        linkedList.addNode("Dad");
        linkedList.addNode("Mom");
        linkedList.addNode("Zach");

        System.out.println(linkedList.toString());
    }
}
