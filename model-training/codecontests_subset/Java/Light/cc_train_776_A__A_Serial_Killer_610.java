import java.util.*;
import java.util.Arrays;
public class Main
{
    public static void main (String[] args)  
    {  
        Scanner sc=new Scanner(System.in);
        String na=sc.next();
        String nb=sc.next();
        String a , b;
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println(na+" "+nb);
            a=sc.next();
            b=sc.next();
            if(na.equals(a))
            {
                na=b;
            }
            else
            {
                nb=b;
            }
        }
        System.out.println(na+" "+nb);
    }  
} 
        