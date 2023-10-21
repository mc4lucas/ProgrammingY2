package Stack;

import java.util.Iterator;
import java.util.Stack;

public class StackClass {
    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();

        st.push(21);
        st.push(27);
        st.push(30);
        st.push(29);
        st.peek();
        st.pop();
        int index = st.search(27);
        System.out.println(index);
    }
}
