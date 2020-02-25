package com.validation;

import com.exception.InvalidNumberOfBracesException;

import java.util.ArrayList;

public class ExpressionValidation {
    ArrayList<String> token = new ArrayList<String>();
    private  int countLeft = 0,countRight = 0;
    public ExpressionValidation(ArrayList token)
    {
        this.token = token;
    }
    public void doValidation()
    {
        for(int i = 0; i< token.size() ;i++)
        {
            if(new String(token.get(i)).equals("("))
            {
                countLeft++;
            }
            if(new String(token.get(i)).equals(")"))
            {
                countRight++;
            }
        }
        if(countRight == countLeft){

        }
        else
        {
            throw new InvalidNumberOfBracesException("not a valid expression not contain equal number of opening and closing braces");
        }


    }
}
