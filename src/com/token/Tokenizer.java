package com.token;

import com.exception.InvalidOperatorException;
import com.exception.InvalidUnaryOperatorException;
import com.exception.MultipleDotInNumberException;
import com.exception.SystemException;
import com.operatorclass.BinaryOperator;
import com.operatorclass.UnaryOperator;

import java.util.ArrayList;

public class Tokenizer {

    String expression = new String();
    ArrayList<String> token = new ArrayList<String>();
    public Tokenizer(String expression)
    {
       this.expression = expression;
    }

    BinaryOperator list = new BinaryOperator();
    public ArrayList<String> binaryData = list.getData();
    UnaryOperator l = new UnaryOperator();
    public ArrayList<String> unaryData = l.getData();
    public ArrayList getToken() {
        char[] ch = expression.toCharArray();
        for(int i=0;i<ch.length;i++) {
            String current = String.valueOf(ch[i]);
            if(current.equals("(")){
                token.add(current);
            }
            else if(current.equals(")")) {
                token.add(current);
            }
            else if(ch[i] == ' ') {
                continue;
            }
            else if(ch[i] == '-') {
                if(i==0 || (unaryData.contains(String.valueOf(ch[i-1])) || binaryData.contains(String.valueOf(ch[i-1]))) ) {
                    token.add("0");
                }
                token.add("-");
            }
            else if(ch[i]=='.' || (ch[i]>='0' && ch[i] <='9')  ) {
                String curr = "";
                while(i<ch.length && (ch[i]=='.' || (ch[i]>='0' && ch[i] <='9'))) {
                    curr = curr + String.valueOf(ch[i++]);
                }
                if(i != ch.length-1) {
                    i--;
                }
                token.add(curr);
                continue;
            }
            else if((ch[i] >= 'a' && ch[i]<='z')){
                String curr = "";
                while (i<ch.length && (ch[i] >= 'a' && ch[i]<='z')) {
                    curr = curr + String.valueOf(ch[i++]);
                }
                if(i!=ch.length-1) {
                    i--;
                }
                token.add(curr);
            }
            else if(ch[i] == '$')
            {
                continue;
            }
            else {
                token.add(current);
            }
        }
       return token;
    }
}
