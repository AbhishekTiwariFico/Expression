package com.tree;

import com.exception.InvalidExpressionException;
import com.operatorclass.BinaryOperator;
import com.operatorclass.UnaryOperator;

import java.util.ArrayList;
import java.util.EmptyStackException;
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
        ArrayList<String> binary;
        binary = b.getData();
        UnaryOperator u = new UnaryOperator();
        ArrayList<String> unary;
        unary = u.getData();

        Stack<Node> st = new Stack();
        Node t = null, t1 = null, t2 = null;
        for (int i = 0; i < postfix.size(); i++) {
            if ((binary.contains(postfix.get(i)))) {
                t = new Node(postfix.get(i));
                try {
                    t1 = st.pop();
                    t2 = st.pop();
                }
                catch (EmptyStackException emptyStackException)
                {
                    throw new InvalidExpressionException("it not contains proper operator and operand");
                }
                t.right = t1;
                t.left = t2;
                st.push(t);

            } else if ((unary.contains(postfix.get(i)))) {

                t = new Node(postfix.get(i));
                try {
                    t1 = st.pop();
                }
                catch(EmptyStackException emptyStackException)
                {
                    throw new InvalidExpressionException("it not contains proper operator and operand");
                }
                t.left = t1;
                st.push(t);
            } else {

                t = new Node(postfix.get(i));
                st.push(t);
            }
        }

       try {
           t = st.peek();
       }
       catch(EmptyStackException emptyStackException)
       {
           throw new InvalidExpressionException("Expression is not valid");
       }

        return t;
    }
}



