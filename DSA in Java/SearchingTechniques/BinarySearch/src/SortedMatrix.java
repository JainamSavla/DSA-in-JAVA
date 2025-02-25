import java.util.Arrays;
import java.util.Scanner;

public class SortedMatrix {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("enter number of rows");
        int row=scan.nextInt();
        System.out.println("enter number of columns:");
        int col=scan.nextInt();
        int[][] arr=new int[row][col];
        System.out.println("enter the elements:");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                arr[i][j]=scan.nextInt();
            }
        }
        System.out.println("the elements are:");


        System.out.println(Arrays.deepToString(arr));//also used to demonstate array


        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("element u want to search for");
        int target=scan.nextInt();
        BinarySearch(arr,target,row,col);

    }
    public static void BinarySearch(int[][] arr, int target, int row, int col) {
        boolean found = false;

        // Perform binary search for each row
        for (int i = 0; i < row; i++) {
            int low = 0;
            int high = col - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[i][mid] == target) {
                    System.out.println("Element " + target + " found at (" + (i+1) + ", " + (mid+1) + ")");
                    found = true;
                    break;
                } else if (arr[i][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (found) break; // If found in any row, stop searching
        }

        if (!found) {
            System.out.println("Element " + target + " not found in the array.");
        }
    }

}
