package com.token;

import com.exception.InvalidOperatorException;
import com.exception.MultipleDotInNumberException;
import com.operatorclass.BinaryOperator;

import java.util.ArrayList;

public class Tokenizer {

    String expression = new String();
    ArrayList<String> token = new ArrayList<String>();
    String str = "";
    private int count = 0;
    public Tokenizer(String expression)
    {
       this.expression = expression;
    }

    BinaryOperator list = new BinaryOperator();
    public ArrayList<String> binaryData = list.getData();
    public ArrayList getToken() {
        char[] ch = expression.toCharArray();
        for (char chh : ch) {
            if ((Character.isDigit(chh)) || (chh == '.'))
            {
                if((chh == '.'))
                {
                    count++;
                }
                if(count>1)
                {
                    throw new MultipleDotInNumberException("it is not a currect type number contain more than one point in number");
                }
                str += chh;
            }
            else if(binaryData.contains(String.valueOf(chh)))
            {
                if (str != "")
                {
                    token.add(str);
                    str = ""; count = 0;
                }
                if (chh == '$')
                {
                    continue;
                }
                token.add(String.valueOf(chh));

               }
            else if(chh =='(')
            {
                if (str != "")
                {
                    token.add(str);
                    str = ""; count = 0;
                }
                token.add(String.valueOf(chh));
            }
            else if(chh ==')')
            {
                if (str != "")
                {
                    token.add(str);
                    str = ""; count = 0;
                }
                token.add(String.valueOf(chh));
            }
            else if(chh == ' ')
            {
                continue;
            }
            else {
                throw new InvalidOperatorException("It is not a Valid Operator not consumed by system");
            }
   }
        System.out.println(str);
        System.out.println(token);
        System.out.println(binaryData);
        return token;
    }
    }
