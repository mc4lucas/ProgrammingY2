package L4Q1;

public class Driver_DoublyLinkedList {
    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 4-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: To work with a doubly-linked list and understand how to navigate through it\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 4-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion

    public static void main(String[] args){
        myHeader(1); //Print the header

        DoublyLinkedList<MyStudent> LucasList = new DoublyLinkedList<>(); //Creating a link list

        //region Data Input
        //Create the students
        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry",67.35);
        MyStudent s2 = new MyStudent("Luna",87.5);
        MyStudent s3 = new MyStudent("Vincent",60.5);
        MyStudent s4 = new MyStudent("Hermione",89.2);

        //Add the students to the linked list
        LucasList.addLast(s0);
        LucasList.addLast(s1);
        LucasList.addLast(s2);
        LucasList.addLast(s3);
        //endregion

        System.out.println("Adding 4 students to the list.\nThe List Content:");

        System.out.println(LucasList.toString()); //Print the current list

        System.out.println("Adding Hermione to the list in between Luna and Vincent.....\nThe List Content:");

        DoublyLinkedList.Node<MyStudent> n2 = LucasList.findNode(s2); //Retrieve the second student
        DoublyLinkedList.Node<MyStudent> n3 = LucasList.findNode(s3); //Retrieve the third student

        LucasList.addBetween(s4,n2,n3); //Adds the fourth student between the second and third

        System.out.println(LucasList.toString()); //Print the current list

        myFooter(1); //Print footer
    }
}
