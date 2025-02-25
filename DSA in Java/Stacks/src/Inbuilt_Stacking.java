import java.util.Scanner;
import java.util.Stack;

public class Inbuilt_Stacking {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("1. Push an Element");
            System.out.println("2. Pop an Element");
            System.out.println("3. Peek at the Top Element");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    System.out.println("Pushed " + element + " to the stack.");
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty. Nothing to pop.");
                    } else {
                        int pop = stack.pop();
                        System.out.println("Popped " + pop + " from the stack.");
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty. Nothing to peek.");
                    } else {
                        int top = stack.peek();
                        System.out.println("Top element is: " + top);
                    }
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack elements: " + stack);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
