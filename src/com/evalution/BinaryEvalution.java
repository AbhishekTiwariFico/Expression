package com.evalution;

import com.operatorclass.BinaryOperator;
import com.tree.Node;

import java.util.ArrayList;

public class BinaryEvalution {
    BinaryOperator b = new BinaryOperator();
    ArrayList<String> a =b.getData();

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void evaluate(Node root)
    {
        //System.out.println("\ntree  " + root.value);
        if(isNumeric(root.value)){

        }
        if()

    }
}
