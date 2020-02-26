
import com.controller.ExpressionController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String expression;
        System.out.println("Enter Expression");
        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();
        expression = expression +String.valueOf('$');

        ExpressionController expController = new ExpressionController(expression);
        expController.init();
    }
}

