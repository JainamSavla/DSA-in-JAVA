import java.util.Scanner;

class Stack {
    private int[] arr;
    private int top;
    private int size;

    public Stack(int size) {
        this.arr = new int[size];
        this.top = -1;
        this.size = size;
    }

    public void push(int val) {
        if (top == size - 1) {
            System.out.println("Overflow");
            return;
        }
        arr[++top] = val;
        System.out.println("Pushed: " + val);
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Empty");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Custom_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        Stack s = new Stack(size);  // Fixed here, using Stack instead of Stacker

        while (true) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    s.push(val);
                    break;
                case 2:
                    int popped = s.pop();
                    if (popped != -1) System.out.println("Popped: " + popped);
                    break;
                case 3:
                    int peeked = s.peek();
                   System.out.println("Top: " + peeked);
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
