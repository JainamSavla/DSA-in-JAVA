import java.util.Scanner;

class CircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    // 1. Insert Node at Start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circular link to itself
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Update the tail to point to the new head
        }
    }

    // 2. Insert Node at End
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circular link to itself
        } else {
            tail.next = newNode;
            tail = newNode;
            newNode.next = head; // Circular property maintained
        }
    }

    // 3. Insert Node at Index
    public void insertAtIndex(int data, int index) {
        if (index == 0) {
            insertAtStart(data);
            return;
        }
        if (index == getSize()) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 4. Delete Node from Start
    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head; // Circular link update
        }
    }

    // 5. Delete Node from End
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head == tail) { // Only one node
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) { // Traverse to the second-to-last node
                temp = temp.next;
            }
            temp.next = head;
            tail = temp; // Update the tail
        }
    }

    // 6. Delete Node from Index
    public void deleteAtIndex(int index) {
        if (index == 0) {
            deleteAtStart();
            return;
        }
        if (index == getSize() - 1) {
            deleteAtEnd();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next; // Bypass the node at the index
    }

    // 7. Display List
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // 8. Get Size of List - Separate Size Calculation Method
    public int getSize() {
        int count = 0;
        if (head == null) {
            return count; // If list is empty, return 0
        }
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class CLL{
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert Node at Start");
            System.out.println("2. Insert Node at End");
            System.out.println("3. Insert Node at Index");
            System.out.println("4. Delete Node from Start");
            System.out.println("5. Delete Node from End");
            System.out.println("6. Delete Node from Index");
            System.out.println("7. Display List");
            System.out.println("8. Get Size of List");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    int data1 = scanner.nextInt();
                    list.insertAtStart(data1);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    int data2 = scanner.nextInt();
                    list.insertAtEnd(data2);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    int data3 = scanner.nextInt();
                    System.out.print("Enter index: ");
                    int index3 = scanner.nextInt();
                    list.insertAtIndex(data3, index3);
                    break;
                case 4:
                    list.deleteAtStart();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter index: ");
                    int index6 = scanner.nextInt();
                    list.deleteAtIndex(index6);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.println("Size of List: " + list.getSize());
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
