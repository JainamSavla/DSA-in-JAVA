import java.util.*;

public class inputnumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements in array:");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.print("the elements you inputed:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the element to search for: ");
        int target = scan.nextInt();
        LinearSearch(arr, target);
    }

    public static void LinearSearch(int arr[],int target)
    {
      for(int i=0;i< arr.length;i++)
      {
          if(arr[i]==target)
          {
              System.out.println("found at element "+i);
              return;
          }
      }
      System.out.println("not found");
    }
}