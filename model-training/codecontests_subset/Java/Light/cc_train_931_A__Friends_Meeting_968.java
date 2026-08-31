import java.io.*;
import java.util.*;
public class First
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        int a1=0,b1=0,s=0;
        int n=Math.abs(a-b);
        int j=0,k=0;
        for(int i=1;i<=n;i++)
        {
            if(i%2==1)
                {   j++;
                    a1=a1+j;
                }
            else if(i%2==0)
                {   k++;
                    b1=b1+k;
                }            
        }
        s=a1+b1;
        System.out.println(s);
    }
}