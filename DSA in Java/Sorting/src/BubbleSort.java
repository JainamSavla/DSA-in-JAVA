import java.util.*;
public class BubbleSort {
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
      /*  for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        */
       Bubblesort(arr);
    }
    public static void Bubblesort(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("Array after pass " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println("the sorted array  is "+Arrays.toString(arr));
        return;
    }
}