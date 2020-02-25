
package com.controller;

import com.convert.PostFixConvert;
import com.evalution.BinaryEvalution;
import com.token.Tokenizer;
import com.tree.Node;
import com.tree.TreeCreation;
import com.validation.ExpressionValidation;

import java.util.ArrayList;

public class ExpressionController {
    private String expression;

    public ExpressionController(String expression)
    {
        this.expression = expression;
    }
    public void init() {
        Tokenizer t = new Tokenizer(expression);
        ArrayList<String> token = t.getToken();
        System.out.println(token);
        ExpressionValidation validate = new ExpressionValidation(token);
        validate.doValidation();
        System.out.println("Its a valid expression");
        PostFixConvert p =new PostFixConvert();
        ArrayList<String> postFix = p.infixToPostfix(token);
        TreeCreation et = new TreeCreation();
        Node root = et.constructTree(postFix);
        System.out.println("infix expression is");
        et.inorder(root);
        BinaryEvalution b = new BinaryEvalution();
        b.evaluate(root);
        //System.out.println(exp);
        //Evaluate e = new Evaluate();
       // Double value  = e.evaluatePrefix(exp);
        //System.out.println(Double.valueOf(value));
    }
}

