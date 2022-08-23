package task1;

import java.util.Scanner;
import java.util.Stack;

public class Task1 {
	
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter expression: ");
            String expression = in.nextLine();
            String[] expressionArray = expression.split(" ");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < expressionArray.length; i++) {
                if (expressionArray[i].equals("+") || expressionArray[i].equals("-") || expressionArray[i].equals("*") || expressionArray[i].equals("/")) {
                    if (stack.size() < 2) {
                        System.out.println("Invalid expression");
                        return;
                    }
                    String second = stack.pop();
                    String first = stack.pop();
                    String result = "";
                    switch (expressionArray[i]) {
                        case "+":
                            result = String.valueOf(Integer.parseInt(first) + Integer.parseInt(second));
                            break;
                        case "-":
                            result = String.valueOf(Integer.parseInt(first) - Integer.parseInt(second));
                            break;
                        case "*":
                            result = String.valueOf(Integer.parseInt(first) * Integer.parseInt(second));
                            break;
                        case "/":
                            result = String.valueOf(Integer.parseInt(first) / Integer.parseInt(second));
                            break;
                    }
                    stack.push(result);
                } else {
                    stack.push(expressionArray[i]);
                }
            }
            System.out.println("Result: " + stack.pop());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}