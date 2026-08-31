import java.util.*;
import java.math.*;

public class Main{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        int i,j=0;
        for(i=0;i<n;i++)
        {
            int a=scan.nextInt();
            if(k%a==0)
            {
                if(a>j)
                j=a;
            }
        }
        System.out.println(k/j);
    }
}