package com.evalution;
import com.operatorclass.BinaryOperator;
import com.operatorclass.UnaryOperator;
import com.tree.Node;

import java.util.ArrayList;

public class BinaryEvalution {

    double left;
    double right;
    BinaryOperator b = new BinaryOperator();
    ArrayList<String> binary =b.getData();
    UnaryOperator u = new UnaryOperator();
    ArrayList<String> unary =u.getData();
    public double toDigit(String ch) {
        return Double.parseDouble(ch);
    }

    public double evaluate(Node n)
    {
        double result = 0.0;
                if (n.left == null && n.right == null)
                    return toDigit(n.value);
                else {

                    if(binary.contains(n.value)) {
                        left = evaluate(n.left);
                        right = evaluate(n.right);
                    }
                    else
                    {
                        right = evaluate(n.right);
                    }
                    String operator = n.value;
                    if (binary.contains(operator)) {
                        switch (operator) {
                            case "+":
                                result = left + right;
                                break;
                            case "-":
                                result = left - right;
                                break;
                            case "*":
                                result = left * right;
                                break;
                            case "/":
                                result = left / right;
                                break;
                            case "^":
                                result = Integer.parseInt(String.valueOf(left)) ^ Integer.parseInt(String.valueOf(right));
                                break;
                        }
                    }
                       else if(unary.contains(operator))
                        {

                            switch (operator)
                            {

                                case "sin":
                                    result = Math.sin(Math.toRadians(right));
                                break;
                                case "cos":
                                    result = Math.cos(Math.toRadians(right));
                            }


                        }
                    }
                        return result;

                }
            }


