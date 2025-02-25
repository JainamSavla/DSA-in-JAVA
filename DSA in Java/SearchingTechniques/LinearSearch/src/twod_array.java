import java.util.*;
public class twod_array {
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
        Search(arr,target,row,col);

    }
    public static void Search(int[][] arr,int target,int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(arr[i][j]==target) {
                    i+=1;j+=1;
                    System.out.println("Element " + target + " found at row " + i + " and column " + j + ".");
                    return;
                }
            }
        }
        System.out.println("Element " + target + " not found.");

    }

}
