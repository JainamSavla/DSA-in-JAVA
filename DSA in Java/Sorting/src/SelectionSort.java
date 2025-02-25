import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            System.out.println("enter no of elements in array:");
            int n=scan.nextInt();
            int[] arr=new int[n];
            System.out.println("enter array elements:");
            for(int i=0;i<n;i++)
            {
                arr[i]=scan.nextInt();
            }
            System.out.println("the elements you inserted:");
            System.out.println(Arrays.toString(arr));
            Selectionsort(arr);
        }
        public static void Selectionsort(int[] arr)
        {
            for(int i=0;i<arr.length-1;i++)
            {
                int min=i;
                for(int j = i + 1;j<arr.length;j++)
                {
                    if(arr[min]>arr[j])
                        min=j;
                }
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                System.out.println("Array after pass " + (i + 1) + ": " + Arrays.toString(arr));
            }
            System.out.println("sorted elements:"+Arrays.toString(arr));
        }
}
