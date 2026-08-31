import java.io.*;
import java.util.*;
public class sample
{
       public static void main(String args[])
       {
              Scanner sc=new Scanner(System.in);
              int n=sc.nextInt();
              long a[]=new long[n];
              long b[]=new long[n-1];
              long c[]=new long[n-1];
              long sum1=0,sum2=0,sum3=0;
              for(int i=0;i<n;i++)
              {
                 a[i]=sc.nextLong();
                 sum1=sum1+a[i];
              }
              for(int i=0;i<n-1;i++)
              {
                     b[i]=sc.nextLong();
                     sum2=sum2+b[i];
              }
              for(int i=0;i<n-2;i++)
              {
                     c[i]=sc.nextLong();
                     sum3=sum3+c[i];
              }
              System.out.println((sum1-sum2));
              System.out.println((sum2-sum3));
              
       }
}