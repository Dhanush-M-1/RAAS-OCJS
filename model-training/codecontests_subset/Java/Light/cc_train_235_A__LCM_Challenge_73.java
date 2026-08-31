import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine());
        if(n<3) {System.out.print(n); return;}
        if(n%2==1)
        {
            long ans=1l*n*(n-1)*(n-2);
            System.out.print(ans);
        }
        else
        {
            long ans=0; int i,j,k;
            for(i=n;i>=Math.max(1,n-20);i--)
            for(j=n;j>=Math.max(1,n-20);j--)
            for(k=n;k>=Math.max(1,n-20);k--)
            ans=Math.max(ans,lcm(lcm(i,j),k));
            System.out.print(ans);
        }
    }

    static long lcm(long a,long b)
    {
        long g=1,t,x=a,y=b;
        if(a<b) a=a^b^(b=a);
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        g=a;

        return (x*y)/g;
    }
}