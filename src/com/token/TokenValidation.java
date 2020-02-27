package com.token;
import com.operatorclass.BinaryOperator;
import com.operatorclass.UnaryOperator;
import java.util.ArrayList;
public class TokenValidation {

    BinaryOperator b = new BinaryOperator();
    ArrayList<String> binary = b.getData();
    UnaryOperator u = new UnaryOperator();
    ArrayList<String> unary = u.getData();
    private int i;

    ArrayList<String> validToken = new ArrayList<String>() ;
    public ArrayList<String> tokenValidateOperation(ArrayList<String> token)
    {
        for( i = 0; i < token.size()-1 ; i++)
        {
          String currentToken = token.get(i);
          if(binary.contains(currentToken))
          {
              if(currentToken.equals("-"))
              {
                  String prev = token.get(i-1);
                  String next =token.get(i+1);

                  if(isNumeric(next) || (prev.equals("+") || prev.equals("(")))
                  {
                      String nagative = currentToken + next;
                      validToken.add(nagative);
                      i++;
                  }
                  else if(next.equals("+"))
                  {
                      validToken.add(currentToken);
                      i++;
                  }
                  else{
                      validToken.add(currentToken);
                  }


              }
              else
              {
                  validToken.add(currentToken);
              }
          }
          else if(unary.contains(currentToken))
          {
              validToken.add(currentToken);
          }
          else if(currentToken.equals("(") || currentToken.equals(")"))
          {
              validToken.add(currentToken);
          }
          else
          {
              validToken.add(currentToken);
          }

        }
      if(i< token.size())
         validToken.add(token.get(i));
        return validToken;

    }
    public static boolean isNumeric(String next)
    {
        char [] number = next.toCharArray();
        for(char ch : number)
        {
            if(Character.isDigit(ch) || ch == '.')
            {

            }
            else
            {
                return false;
            }

        }
        return true;
    }

}
