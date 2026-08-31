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
            for(int i=0;i<n;i++)
            {
                 int x=a[i];
                 int h=b[i];
                 int u=0,v=0,r=0;
                 if(x-h>m1)
                  u=Math.max(n1+1,u);
                 if(x-h>m2)
                  u=Math.max(n2+1,u);
                 if(x-h>m3)
                  u=Math.max(n3+1,u);
                 
                 
                 v=Math.max(v,n1);  v=Math.max(v,n2);  v=Math.max(v,n3);
                 
                 if(x+h<c[i])
                 { r=Math.max(n1+1,r); r=Math.max(r,n2+1);  r=Math.max(r,n3+1); 
                   //System.out.println(i+" "+r);
                 }
                 u=Math.max(u,n1);  u=Math.max(u,n2);  u=Math.max(u,n3);
                 r=Math.max(r,n1);  r=Math.max(r,n2);  r=Math.max(r,n3);
                 n1=u; n2=v; n3=r;
                 //System.out.println((x+h)+" "+c[i]);
                 //System.out.println(n1+" "+n2+" "+n3);
                 m1=x;  m2=x; m3=x+h;
            }
            
            System.out.println(Math.max(n1,Math.max(n2,n3)));
      }
}