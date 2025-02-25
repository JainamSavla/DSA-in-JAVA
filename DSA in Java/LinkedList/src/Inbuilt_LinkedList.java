import java.util.LinkedList;
import java.util.*;
public class Inbuilt_LinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println("LinkedList: " + numbers);

        numbers.add(1, 15);
        System.out.println("Updated LinkedList: " + numbers);

        int secondNumber = numbers.get(1);
        System.out.println("Element at index 1: " + secondNumber);

        numbers.remove(Integer.valueOf(20));
        System.out.println("After removing '20': " + numbers);

        System.out.println("Accessing linked list elements:");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
    }
}