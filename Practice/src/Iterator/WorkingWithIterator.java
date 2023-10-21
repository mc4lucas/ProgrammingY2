package Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class WorkingWithIterator {
    public static void main(String[] args){

        ArrayList<Integer> al = new ArrayList<>(); //Creating aan arraylist

        //Add data
        al.add(47);
        al.add(15);
        al.add(72);
        al.add(18);
        al.add(20);
        al.add(21);
        al.add(19);
        al.add(32);
        al.add(47);

        Iterator<Integer> it = al.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
