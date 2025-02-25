import java.util.*;
public class Using_Recursion {
         public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the number of elements in array:");
            int n = scan.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements in the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.print("The elements you inputted: ");
            System.out.println(Arrays.toString(arr));
            System.out.println("Enter the element to search for: ");
            int target = scan.nextInt();
            int result = linearSearch(arr, target, 0);
            if (result != -1) {
                System.out.println("Element found at index: " + result);
            } else {
                System.out.println("Element not found in the array.");
            }
            scan.close();
        }

        private static int linearSearch(int[] array, int target, int index) {
            if (index == array.length) {
                return -1;
            }
            if (array[index] == target) {
                return index;
            }
            return linearSearch(array, target, index + 1);
        }
    }

