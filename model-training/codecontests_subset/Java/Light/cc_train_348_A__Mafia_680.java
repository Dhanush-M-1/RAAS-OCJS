import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         int n=Integer.parseInt(br.readLine());
         String s1[]=br.readLine().split(" ");
         long a[]=new long[n];
         long S=0,max=0;
         for(int i=0;i<n;i++)
         { a[i]=Long.parseLong(s1[i]);  max=Math.max(max,a[i]); S+=a[i]; }
         
         long x=(long)(n-1);
         long u=S/x;
         S=S%x;
         u+=(long)Math.ceil((double)S/x);
         max=Math.max(max,u);
         System.out.println(max);
      }
}