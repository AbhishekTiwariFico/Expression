
package com.controller;

import com.convert.PostFixConvert;
import com.evalution.BinaryEvalution;
import com.result.Result;
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

        ExpressionValidation validate = new ExpressionValidation(token);
        validate.doValidation();

        PostFixConvert p =new PostFixConvert();
        ArrayList<String> postFix = p.infixToPostfix(token);

        TreeCreation et = new TreeCreation();
        Node root = et.constructTree(postFix);


        //et.inorder(root);


        BinaryEvalution b = new BinaryEvalution();
        double result = b.evaluate(root);
        Result.showResult(result);

    }
}

