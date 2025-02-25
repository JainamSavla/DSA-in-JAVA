import java.util.Scanner;
class LLQ {
    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }
  private node front,rear;
    LLQ(){
        front=null;
        rear=null;
    }
    public void enqueue(int data){
        node newNode = new node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void dequeue(){
        if (front==null) {
            System.out.println("Queue is empty!");
            return;
        }
        front=front.next;
        if(front==null){
            rear=null;
        }

    }

    public void peek() {
        if (front==null) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("The front element is: " + front.data);
        }
    }

    public void display() {
        if (front==null) {
            System.out.println("Queue is empty!");
            return;
        }
        node temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}


public class Q_using_Linkedlist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LLQ queue = new LLQ();

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
                    queue.display();
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
