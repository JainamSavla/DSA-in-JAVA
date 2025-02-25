import java.util.Scanner;

class CustomHashMapping {
    private Node[] table;
    private int capacity;

    static class Node {
        int key;
        String value;
        Node next;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public CustomHashMapping(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public String get(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;  // Key not found
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            Node current = table[i];
            if (current != null) {
                while (current != null) {
                    System.out.println("Key: " + current.key + ", Value: " + current.value);
                    current = current.next;
                }
            }
        }
    }
}

public class CustomHashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the capacity for the custom HashMap:");
        int capacity = scanner.nextInt();
        CustomHashMapping customHashMap = new CustomHashMapping(capacity);

        while (true) {
            System.out.println("\n1. Add a key-value pair");
            System.out.println("2. Get a value by key");
            System.out.println("3. Remove a key-value pair");
            System.out.println("4. Display all entries");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key (integer): ");
                    int key = scanner.nextInt();
                    System.out.print("Enter value (string): ");
                    String value = scanner.next();
                    customHashMap.put(key, value);
                    break;

                case 2:
                    System.out.print("Enter key to get value: ");
                    key = scanner.nextInt();
                    String result = customHashMap.get(key);
                    if (result != null) {
                        System.out.println("Value: " + result);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter key to remove: ");
                    key = scanner.nextInt();
                    customHashMap.remove(key);
                    System.out.println("Key-value pair removed.");
                    break;

                case 4:
                    customHashMap.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
