import java.io.*;
import java.util.*;
import java.lang.*;
public class test
{
    static long gcd(long a,long b)
    {
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long x=sc.nextLong();
        long i=(long)Math.sqrt(x);
        if(i*i==x&&i!=1)
        {
            i=i-1;
        }
        for(;i>=1;i--)
        {
            if(x%i==0)
            {
                if(gcd(i,x/i)==1)
                {
                    System.out.println(i+" "+ (x/i));
                    break;
                }
            }
        }
    }
}