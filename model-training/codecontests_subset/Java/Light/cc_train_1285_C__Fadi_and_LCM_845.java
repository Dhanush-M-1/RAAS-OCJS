import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class cff6 {
    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        // int v[]=new int[(int)10e6+1];

        System.out.println(ans(n));
        //etalld(n);
    }
    public static long lcm(long a,long b)
    {
        return a*b/gcd(a,b);
    }
    public static long gcd(long a,long b)
    {
        if(b==0)
        return a;
        
        return gcd(b,a%b);
    }
   public static String ans(long n)
    {
        long max=n;
        for(long j=1;j*j<=n;j++)
        {
            if(n%j==0&&lcm(j,n/j)==n)
            {
                max=j;
            }
        }
        return ""+(max<n/max?max:n/max)+" "+(max>n/max?max:n/max);
        //System.out.println(v);
        
        
      
    }
}
