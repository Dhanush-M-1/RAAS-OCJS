

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EduDIv2jUNE {
        static boolean isPrime(long n)
    {
        int flag=0;
        for(long i=2;i*i<n;i++)
        {
            if(n%i==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
            return false;
        return true;
    }
    static long gcd(long a,long b)
    {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }

    public static void main(String[] args) {
    
        long max1=1;
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        if(isPrime(n))
            System.out.println("1 "+n);
        else
        {
            for(long i=1;i*i<n;i++)
            {
                if(n%i==0)
                {
                    if(gcd(i,n/i)==1)
                        max1=i;
                }
            }
        
        if(max1!=1)
            System.out.println(Math.min(n/max1,max1)+" "+Math.max(n/max1,max1));
        else
            System.out.println("1 "+n); 
            }
    }
}