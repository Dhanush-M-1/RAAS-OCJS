import java.util.*;
import java.math.BigInteger;
import java.lang.Math;

public class Sample
{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        int ans=0;
        for(int i=(int)Math.sqrt(n);i>=1;i--)
        {
            if(n%i==0 && lcm(i,n/i)==n)
            {
                ans=i;
                break;
            }
        }
        System.out.println(ans+" "+(n/ans));

    }

    // static long gcd(long a, long b) 
    // { 
    // if (a == 0) 
    //     return b; 
    // return gcd(b % a, a); 
    // }
    
    static int gcd(long a, long b) {
    BigInteger b1 = BigInteger.valueOf(a);
    BigInteger b2 = BigInteger.valueOf(b);
    BigInteger gcd = b1.gcd(b2);
    return gcd.intValue();
}


    static long lcm(long a,long b)
    {
        return( a/gcd(a,b) *b);
    }
}