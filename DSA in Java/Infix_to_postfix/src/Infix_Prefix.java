import java.util.Scanner;
import java.util.Stack;

class InfixConverter {
    private static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return 0;
    }

    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static String infixToPrefix(String infix) {
        StringBuilder reversedInfix = new StringBuilder(infix).reverse();
        for (int i = 0; i < reversedInfix.length(); i++) {
            char c = reversedInfix.charAt(i);
            if (c == '(') {
                reversedInfix.setCharAt(i, ')');
            } else if (c == ')') {
                reversedInfix.setCharAt(i, '(');
            }
        }

        String postfix = infixToPostfix(reversedInfix.toString());
        return new StringBuilder(postfix).reverse().toString();
    }
}

public class Infix_Prefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfixConverter converter = new InfixConverter();

        System.out.print("Enter an infix expression: ");
        String infix = scanner.nextLine();

        String postfix = converter.infixToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);

        String prefix = converter.infixToPrefix(infix);
        System.out.println("Prefix expression: " + prefix);

        scanner.close();
    }
}
