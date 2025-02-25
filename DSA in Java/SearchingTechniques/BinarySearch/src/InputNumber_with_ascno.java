import java.util.Arrays;
import java.util.Scanner;

public class InputNumber_with_ascno {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements in array:");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the elements in ascending order:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        if (!isSortedAscending(arr)) {
            System.out.println("The array is not in ascending order. Please try again.");
            return;
        }

        System.out.print("the elements you inputed:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the element to search for: ");
        int target = scan.nextInt();
        BinarySearch(arr, target);
    }

    public static boolean isSortedAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public static void BinarySearch(int[] arr,int target){
    int left=0;
    int right=arr.length-1;
    int result=0;
    int found;
    while(left<=right)
    {
        int mid=(right+ left)/2;
        if(arr[mid]==target){
             result=mid;
            System.out.println("Found at index " + mid);
            return;
        }
        else if(arr[mid]>target){
            right=mid-1;
        }
       else{
           left=mid+1;
        }
    }
        System.out.println("not found");
        return;
  }
}

// if is in descending order
/*
     if (!isSortedAscending(arr)) {
        if (isSortedDescending(arr)) {
        System.out.println("The array is in descending order. Converting to ascending order...");
        reverseArray(arr); // Convert to ascending order
            } else {
                    System.out.println("The array is not sorted. Please enter the elements in sorted (ascending) order.");
                return; // Exit the program
                   }
        }
            public static boolean isSortedDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Function to reverse the array (used to convert descending to ascending order)
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap elements at left and right indices
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
 */