package com.tree;

import com.operatorclass.BinaryOperator;

import java.util.ArrayList;
import java.util.Stack;

public class TreeCreation {
    public void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }


    public Node constructTree(ArrayList<String> postfix) {
        BinaryOperator b = new BinaryOperator();
        ArrayList<String> op = new ArrayList<String>();
        op = b.getData();

        Stack<Node> st = new Stack();
        Node t, t1, t2;
        for (int i = 0; i < postfix.size(); i++) {


            if (!op.contains(postfix.get(i))) {
                t = new Node(postfix.get(i));
                st.push(t);
            } else
            {
                t = new Node(postfix.get(i));


                t1 = st.pop();
                t2 = st.pop();
                t.right = t1;
                t.left = t2;
                st.push(t);
            }
        }


        t = st.peek();
        st.pop();

        return t;
    }

}
