package com.convert;

import com.exception.InvalidOprandException;
import com.operatorclass.BinaryOperator;
import com.operatorclass.UnaryOperator;

import java.util.ArrayList;
import java.util.Stack;

public class PostFixConvert {

    public ArrayList infixToPostfix(ArrayList<String> exp) {
        ArrayList<String> result = new ArrayList<String>();
        Stack<String> stack = new Stack<>();
        BinaryOperator b = new BinaryOperator();
        ArrayList<String> ar = b.getData();
        UnaryOperator u = new UnaryOperator();
        ArrayList<String> arr = u.getData();

        for(int i=0;i<exp.size();i++) {
            String c = exp.get(i).trim();
            if(c.equals("(")) {
                stack.push(c);
            }
            else if(c.equals(")")) {
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.add(stack.pop()) ;
                }
                stack.pop();
            }
            else if(ar.contains(c) || arr.contains(c)) {
                while(!stack.isEmpty() && ( !stack.peek().equals("(") && (Prec(stack.peek()) >= Prec(c)))) {
                    result.add(stack.pop());
                }
                stack.push(c);
            }
            else{
                result.add(c);
            }

        }
        while(!stack.isEmpty()) {
            String bb = stack.pop();

            result.add(bb);
        }
        return result;

    }
    private int Prec(String ch) {
        switch (ch) {
            case "+":

            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;
            case "sin":
            case "cos":return 4;
            case "(" :
                return 5;
        }
        return -1;
    }
}

