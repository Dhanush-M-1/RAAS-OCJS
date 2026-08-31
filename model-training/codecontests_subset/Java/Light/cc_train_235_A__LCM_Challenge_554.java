import java.io.*;
import java.util.*;
public class LCMChallenge
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long ans=0,a=0,b=0,c=0;
        if(n==1)
        {
            System.out.println(1);
            System.exit(0);
        }
        if(n==2)
        {
            System.out.println(2);
            System.exit(0);
        }
        if(n==3)
        {
            System.out.println(6);
            System.exit(0);
        }
        if(n==4)
        {
            System.out.println(12);
            System.exit(0);
        }
        if(n%2!=0)
        {
            a=n;
            b=n-1;
            c=n-2;
        }
        else 
        {
            if(n%3!=0)
            {
                a=n;
                b=n-1;
                c=n-3;
            }
            else
            {
                a=n-1;
                b=n-2;
                c=n-3;
            }
        }
        ans=a*b*c;
        System.out.println(ans);
    }
}