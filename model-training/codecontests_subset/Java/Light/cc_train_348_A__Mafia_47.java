//package c202;

import java.util.Arrays;
import java.util.Scanner;

public class q3
{

    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long a[]=new long[n];
        long sum=0;
        long max=0;
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextLong();
            if(a[i]>max)
                max=a[i];
            sum+=a[i];
        }
        long count=0;
        //System.out.println(sum);
        count=sum/(n-1);
        if(sum%(n-1)!=0)
        count++;
        System.out.println(Math.max(count,max));
        
    }
}
