import java.util.*;
import java.io.*;
public class solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long n= sc.nextLong();
        int flag=0;
        for(long i = (long)Math.sqrt(n);i>=1;i--)
        {
            if(n%i==0&&gcd(i,n/i)==1)
            {
                flag=1;
                System.out.println(n/i+" "+i);
                break;
            }
        }
        if(flag == 0)
        {
            System.out.println(1+" "+n);
        }
    }
    static long gcd(long a,long b)
    {
        if(a==0)
        {
            return b;
        }
        return gcd(b%a,a);
    }
}