import java.util.*;
public class inputstring {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter string:");
        String str=scan.nextLine();
        System.out.println("enter letter u want to find");
        String a=scan.next();
        System.out.println(search(str,a));
    }

    public static boolean search(String str,String a)
    {
        if(str.length()==0){
           return false;
        }
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==a.charAt(0))
                return true;

        }
        return false;
    }

}
