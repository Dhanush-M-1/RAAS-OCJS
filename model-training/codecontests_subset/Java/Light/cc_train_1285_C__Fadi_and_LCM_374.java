import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        long n=0;

        if(scan.hasNext())
            n=scan.nextLong();

        long k=1;
        for(long i=1;i<Math.sqrt(n);i++){
            if(n%i==0 && gcd(i,n/i)==1){
                k=i;
            }
        }
        long p=n/k;
        if(p>k){
            long temp=p;
            p=k;
            k=temp;
        }
        System.out.println(p+" "+k);
    }
    static long gcd(long a, long b)
    {

        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a%b, b);
        return gcd(a, b%a);
    }
}
