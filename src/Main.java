
import com.controller.ExpressionController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String expression;
        //System.out.println("Enter Expression");
        Scanner sc = new Scanner(System.in);
        //expression = sc.nextLine();
        expression = "(1+2)+3" +'$';
        System.out.println(expression);
        ExpressionController expController = new ExpressionController(expression);
        expController.init();
    }
}

