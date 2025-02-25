import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
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
       Insertionsort(arr);
    }
    public static void Insertionsort(int[] arr)
    {
        for(int i=1;i<arr.length;i++) {
           int key=arr[i];
           int j=i-1;
           while(arr[j]>key && j>=0) {
                arr[j+1]=arr[j];
                j--;
           }
           arr[j+1]=key;
            System.out.println("pass"+(i)+":"+Arrays.toString(arr));
        }
        System.out.println("the sorted array  is "+Arrays.toString(arr));
        return;
    }
}

