import java.util.Scanner;

 class Circular {
    private int[] arr;
    private int size;
    private int rear;
    private int front;

    // Constructor
    Circular(int size) {
        this.size = size;
        this.arr = new int[size];
        this.rear = -1;
        this.front = -1;
    }

    // Check if the queue is empty
    public boolean isempty() {
        return front == -1 && rear == -1;
    }

    // Check if the queue is full
    public boolean isfull() {
        return (rear + 1) % size == front;  // Check if next position is front
    }

    // Enqueue an element to the queue
    public void enqueue(int data) {
        if (isfull()) {
            System.out.println("Overflow: The queue is full.");
            return;
        }

        // If the queue is empty, set front and rear to 0
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            // Move rear to the next position in the circular array
            rear = (rear + 1) % size;
        }

        arr[rear] = data;
        System.out.println(data + " added to the queue.");
    }

    // Dequeue an element from the queue
    public void dequeue() {
        if (isempty()) {
            System.out.println("Underflow: The queue is empty.");
            return;
        }

        // Print the dequeued element
        System.out.println("The dequeued element is: " + arr[front]);

        // If front equals rear, reset the queue
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // Move front to the next position in the circular array
            front = (front + 1) % size;
        }
    }

    // Peek at the front element of the queue
    public void peek() {
        if (isempty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("The first element is: " + arr[front]);
    }

    // Display the elements of the queue
    public void displayQueue() {
        if (isempty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements: ");
        if (front <= rear) {
            // Display elements from front to rear (no wrap-around)
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            // Display elements from front to the end of the array, then from start to rear
            for (int i = front; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}

public class CircularQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the queue
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        Circular queue = new Circular(size);

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
                    System.out.print("Enter a number to enqueue: ");
                    int data = scanner.nextInt();
                    queue.enqueue(data);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.displayQueue();
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
}
