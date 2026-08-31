import java.util.*;
import java.io.*;
public class codeforces
{
   public static long GCD(long  a, long b) 
   {
       if (b==0) 
       return a;
       return GCD(b,a%b);
   }
   public static void main(String args[])
   {
       //PrintWriter out=new PrintWriter(System.out);
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int arr[]=new int[n];
       for(int i = 0 ;i<n;i++)
       arr[i]=sc.nextInt();
       int max=-1;
       for(int i =0;i<n;i++)
       {
           max=Math.max(max,Math.min(arr[i]-1,1000000-arr[i]));
        }
        System.out.println(max);
   }
}