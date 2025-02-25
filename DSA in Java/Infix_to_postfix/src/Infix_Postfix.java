import java.util.Scanner;
import java.util.Stack;

 class InfixToPostfix {

     // Method to check precedence of operators
     private static int precedence(char c) {
         if (c == '+' || c == '-') {
             return 1;
         } else if (c == '*' || c == '/') {
             return 2;
         }
         return 0;
     }

     // Method to perform infix to postfix conversion
     public static String infixToPostfix(String infix) {
         Stack<Character> stack = new Stack<>();
         StringBuilder postfix = new StringBuilder();

         for (int i = 0; i < infix.length(); i++) {
             char c = infix.charAt(i);

             // If the character is an operand (e.g., letter or digit), add it to the result
             if (Character.isLetterOrDigit(c)) {
                 postfix.append(c);
             }
             // If the character is '(', push it to the stack
             else if (c == '(') {
                 stack.push(c);
             }
             // If the character is ')', pop and append all operators from the stack until '('
             else if (c == ')') {
                 while (!stack.isEmpty() && stack.peek() != '(') {
                     postfix.append(stack.pop());
                 }
                 stack.pop(); // Remove '(' from the stack
             }
             // If the character is an operator
             else {
                 while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                     postfix.append(stack.pop());
                 }
                 stack.push(c); // Push the current operator onto the stack
             }
         }

         // Pop any remaining operators in the stack
         while (!stack.isEmpty()) {
             postfix.append(stack.pop());
         }

         return postfix.toString();
     }
 }
    public class Infix_Postfix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       InfixToPostfix inpo=new InfixToPostfix();
        // Take user input for the infix expression
        System.out.print("Enter an infix expression: ");
        String infix = scanner.nextLine();

        // Convert to postfix
        String postfix = inpo.infixToPostfix(infix);

        // Display the result
        System.out.println("Infix expression: " + infix);
        System.out.println("Postfix expression: " + postfix);

        scanner.close();
    }
}
