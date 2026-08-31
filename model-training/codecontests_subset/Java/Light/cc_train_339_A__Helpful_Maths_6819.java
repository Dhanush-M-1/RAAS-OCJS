import java.util.*;
import java.util.Arrays;
public class B{
    public static void main(String args[])
    {
        int i;
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int len=s.length();
        String a[]=new String[len+1];
        if(len==1)
        {
            System.out.println(s);
        }
        else
        {
            a=s.split("\\+");
            Arrays.sort(a);
             String st=String.join("+",a);
            System.out.println(st);
        }
        
        
    }
}