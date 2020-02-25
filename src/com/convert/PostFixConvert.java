package com.convert;

import com.exception.InvalidOprandException;
import com.operatorclass.BinaryOperator;

import java.util.ArrayList;
import java.util.Stack;

public class PostFixConvert {

    static int Prec(String ch) {
        switch (ch) {
            case "+":

            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;
        }
        return -1;
    }

    public ArrayList infixToPostfix(ArrayList<String> exp) {

       ArrayList<String> result = new ArrayList<String>();
        Stack<String> stack = new Stack<>();
        BinaryOperator b =new BinaryOperator();
        ArrayList<String> ar = b.getData();

        for (int i = 0; i < exp.size(); ++i) {
            String c = exp.get(i);

            if (c.equals("("))
                stack.push(c);

            else if (c.equals(")"))
            {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                     result.add(stack.pop());

                if (!stack.isEmpty() && !stack.peek().equals("("))
                    System.out.println("Invalid Expression");
                else
                    stack.pop();
            }
            else if(ar.contains(c)) // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    if (stack.peek().equals("("))
                        System.out.println("Invalid Expression");
                    result.add(stack.pop());
                }
                stack.push(c);
            }
            else
                result.add(c);
        }


        while (!stack.isEmpty()) {
            if (stack.peek().equals("("))
                System.out.println("Invalid Expression");
            result.add(stack.pop());
        }
        System.out.println(result);
        return result;

    }

}

