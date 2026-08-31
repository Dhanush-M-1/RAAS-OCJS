import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
            int n1=0,n2=0,n3=0;
            int m1=Integer.MIN_VALUE,m2=Integer.MIN_VALUE,m3=Integer.MIN_VALUE;
            int a[]=new int[n];
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            {
                String s1[]=br.readLine().split(" ");
                a[i]=Integer.parseInt(s1[0]);
                b[i]=Integer.parseInt(s1[1]);  
            }
            int c[]=new int[n];
            c[n-1]=Integer.MAX_VALUE;
            for(int i=0;i<n-1;i++)
             c[i]=a[i+1];
            
            int n4=0; int m=Integer.MIN_VALUE;
            for(int i=0;i<n;i++)
            {
                 int x=a[i];
                 int h=b[i];
                 if(x-h>m)
                 { m=x; n4++; }
                 else if(x+h<c[i])
                 { m=x+h; n4++; }
                 else
                 { m=x; }
            }
            
            System.out.println(n4);
      }
}