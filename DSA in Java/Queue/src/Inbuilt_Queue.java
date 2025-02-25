import java.util.LinkedList;
import java.util.Queue;

public class Inbuilt_Queue{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Current Queue: " + queue);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Removed: " + queue.poll());

        System.out.println("Current Queue: " + queue);

        while (!queue.isEmpty()) {
            System.out.println("Removed: " + queue.poll());
        }

        System.out.println("Final Queue: " + queue);
    }
}
