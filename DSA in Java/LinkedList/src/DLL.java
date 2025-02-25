import java.util.Scanner;

class DoublyLinkedList {

    // Node class for doubly linked list
       class Node {
        int data;
        Node next;
        Node prev;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Head of the doubly linked list

    // Method to insert a node at the start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Method to insert a node at a given index
    public void insertAtIndex(int data, int index) {
        if (index == 0) {
            insertAtStart(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            if(temp==null || temp.next == null){
                System.out.println("index not found");
                return;
            }
            temp=temp.next;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Method to delete a node from the start
    public void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Method to delete a node from the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }

    // Method to delete a node from a given index
    public void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (index == 0) {
            deleteAtStart();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp == null) {
                System.out.println("Index not found");
                return;
            }
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }


    // Method to display the doubly linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to get the size of the list
    public int size() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}

public class DLL{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        int choice;

        do {
            System.out.println("\nMenu:");
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

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert at start: ");
                    int valueStart = scanner.nextInt();
                    list.insertAtStart(valueStart);
                    break;
                case 2:
                    System.out.print("Enter the value to insert at end: ");
                    int valueEnd = scanner.nextInt();
                    list.insertAtEnd(valueEnd);
                    break;
                case 3:
                    System.out.print("Enter the value to insert: ");
                    int valueIndex = scanner.nextInt();
                    System.out.print("Enter the index to insert the node at: ");
                    int index = scanner.nextInt();
                    list.insertAtIndex(valueIndex, index);
                    break;
                case 4:
                    list.deleteAtStart();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter the index to delete the node from: ");
                    int deleteIndex = scanner.nextInt();
                    list.deleteAtIndex(deleteIndex);
                    break;
                case 7:
                    System.out.println("Displaying the list:");
                    list.display();
                    break;
                case 8:
                    int size = list.size();
                    System.out.println("Size of the list: " + size);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        scanner.close();
    }
}
