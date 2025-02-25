import java.util.Scanner;

class Queue {
    private int[] arr;
    private int size;
    private int rear;
    private int front;

    Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.rear = -1;
        this.front = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear++;
        arr[rear] = data;
        System.out.println(data + " added to the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }
        System.out.println("The dequeued element is: " + arr[front]);
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("The first element is: " + arr[front]);
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Custom_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enqueue(queue, scanner);  // Separate method for enqueue
                    break;
                case 2:
                    dequeue(queue);  // Separate method for dequeue
                    break;
                case 3:
                    peek(queue);  // Separate method for peek
                    break;
                case 4:
                    displayQueue(queue);  // Separate method for display
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void enqueue(Queue queue, Scanner scanner) {
        System.out.print("Enter a number to enqueue: ");
        int data = scanner.nextInt();
        queue.enqueue(data);
    }

    public static void dequeue(Queue queue) {
        queue.dequeue();
    }

    public static void peek(Queue queue) {
        queue.peek();
    }

    public static void displayQueue(Queue queue) {
        queue.displayQueue();
    }
}
