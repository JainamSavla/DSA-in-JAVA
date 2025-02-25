import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;
    public BinarySearchTree() {
        root = null;
    }
    Node createNode(int value) {
        return new Node(value);
    }

    // Add a node to the tree
    Node addNode(Node current, int value) {
        if (current == null) {
            return createNode(value);
        }
        if (value < current.data) {
            current.left = addNode(current.left, value);
        } else if (value > current.data) {
            current.right = addNode(current.right, value);
        }
        return current;
    }

    // Find the minimum value node
    Node findMin(Node current) {
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Delete a node from the tree
    Node deleteNode(Node current, int value) {
        if (current == null) {
            System.out.println("Value not found in the tree.");
            return current;
        }

        if (value < current.data) {
            current.left = deleteNode(current.left, value);
        } else if (value > current.data) {
            current.right = deleteNode(current.right, value);
        } else {
            // Node to be deleted found
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Node with two children
            Node temp = findMin(current.right);
            current.data = temp.data;
            current.right = deleteNode(current.right, temp.data);
        }

        return current;
    }

    // Inorder traversal (left, root, right)
    void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current.data + " -> ");
            inOrder(current.right);
        }
    }

    // Preorder traversal (root, left, right)
    void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " -> ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    // Postorder traversal (left, right, root)
    void postOrder(Node current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " -> ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int value, choice;

        do {
            // Menu options
            System.out.println("\n1. Add Value");
            System.out.println("2. Delete Value");
            System.out.println("3. Inorder View");
            System.out.println("4. Preorder View");
            System.out.println("5. Postorder View");
            System.out.println("6. End");
            System.out.print("Choose Option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    value = sc.nextInt();
                    bst.root = bst.addNode(bst.root, value);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    bst.root = bst.deleteNode(bst.root, value);
                    break;

                case 3:
                    if (bst.root == null) {
                        System.out.println("Tree has no nodes.");
                    } else {
                        System.out.print("Inorder View: ");
                        bst.inOrder(bst.root);
                        System.out.println();
                    }
                    break;

                case 4:
                    if (bst.root == null) {
                        System.out.println("Tree has no nodes.");
                    } else {
                        System.out.print("Preorder View: ");
                        bst.preOrder(bst.root);
                        System.out.println();
                    }
                    break;

                case 5:
                    if (bst.root == null) {
                        System.out.println("Tree has no nodes.");
                    } else {
                        System.out.print("Postorder View: ");
                        bst.postOrder(bst.root);
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Shutting down...");
                    break;

                default:
                    System.out.println("Not a valid selection!");
            }

        } while (choice != 6);

        sc.close();
    }
}
