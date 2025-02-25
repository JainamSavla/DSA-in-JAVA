import java.util.Arrays;
import java.util.Scanner;

public class Using_Recursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements in array:");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the elements in ascending order:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.print("the elements you inputed:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the element to search for: ");
        int target = scan.nextInt();
        int left=0;
        int right=arr.length-1;
        int result= BinarySearch(arr, target,left, right);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
    private static int BinarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return BinarySearch(array, target, left, mid - 1);
        } else {
            return BinarySearch(array, target, mid + 1, right);
        }
    }
}
