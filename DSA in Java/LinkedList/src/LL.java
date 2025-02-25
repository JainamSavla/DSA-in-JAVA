import java.util.Scanner;
class LinkedList {
     class Node {
        //Object Inialized
        int data;
        Node next;

        Node(int data) {                                       //constructor
            this.data = data;
            this.next = null;
        }
    }

    private Node head;   //used for data encaptulation so that head isnot modified outside of than linkedlist class

    public void addNode(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.data=data;
        head = newNode;
    }

    public void addNodeAtEnd(int data){
        Node newNode = new Node(data);
        if(head==null)
        {
            newNode.next = head;
            newNode.data=data;
            head = newNode;
            return;
        }
        Node temp=head;
        while (temp.next != null) {
            temp = temp.next;
        }
       temp.next=newNode;
    }
    public void addNodeAtIndex(int data,int index)
    {
        if (index == 0) {
            addNode(data);
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
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void deleteNodeAtStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }
    public void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next!= null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteNodeAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++)
        {
            if(temp==null || temp.next == null)
            {
                System.out.println("invalid index");
                return;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void getItemAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp == null) {
                System.out.println("Index out of bounds.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item at index " + index + ": " + temp.data);
    }
    public void findIndexOfItem(int value) {
        Node temp = head;
        for (int i = 0; temp!=null; i++) {
            if (temp.data == value) {
                System.out.println("Value " + value + " found at index: " + i);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Value not found.");
    }
    public void size() {
        if(head==null){
            System.out.println("list is empty");
            return ;
        }
        Node temp = head;int i;
        for (i = 0; temp != null; i++) {
         temp=temp.next;
        }
        System.out.println("Size of linkedlist is:"+i);
    }
}
public class LL {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Node at Start");
            System.out.println("2. Add Node at Index");
            System.out.println("3. Add Node at End");
            System.out.println("4. Delete Node at Start");
            System.out.println("5. Delete Node at Index");
            System.out.println("6. Delete Node at End");
            System.out.println("7. Display List");
            System.out.println("8. Get Item at Index");
            System.out.println("9. Find Index of Item");
            System.out.println("10. Size of linkedlist");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add: ");
                    int value1 = sc.nextInt();
                    list.addNode(value1);
                    break;

                case 2:
                    System.out.print("Enter the value to add: ");
                    int value2 = sc.nextInt();
                    System.out.print("Enter the index to add the node: ");
                    int index2 = sc.nextInt();
                    list.addNodeAtIndex(value2, index2);
                    break;

                case 3:
                    System.out.print("Enter the value to add: ");
                    int value3 = sc.nextInt();
                    list.addNodeAtEnd(value3);
                    break;

                case 4:
                    list.deleteNodeAtStart();
                    break;

                case 5:
                    System.out.print("Enter the index to delete the node: ");
                    int index5 = sc.nextInt();
                    list.deleteNodeAtIndex(index5);
                    break;

                case 6:
                    list.deleteNodeAtEnd();
                    break;

                case 7:
                    list.displayList();
                    break;

                case 8:
                    System.out.print("Enter the index to get the item: ");
                    int index8 = sc.nextInt();
                    list.getItemAtIndex(index8);
                    break;

                case 9:
                    System.out.print("Enter the value to find the index: ");
                    int value9 = sc.nextInt();
                    list.findIndexOfItem(value9);
                    break;

                case 11:
                    System.out.println("Exiting...");
                    break;

                case 10:list.size();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
        sc.close();
    }
}