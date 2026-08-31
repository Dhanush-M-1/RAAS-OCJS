import java.io.*;
import java.util.*;
public class abc
{
     public static void main(String agr[])throws IOException
     {
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          int t=Integer.parseInt(br.readLine());
          StringBuilder sb=new StringBuilder();
          while(t-->0)
          {
           int n=Integer.parseInt(br.readLine());
           String s[]=br.readLine().split(" ");
           long a[]=new long[n];
           for(int i=0;i<n;i++)
           a[i]=Long.parseLong(s[i]);
           Arrays.sort(a);
           int i=0;
           boolean t2=false;
           Upper:
          for( i=2;i<n;i++)
          {
          if(a[0]+a[1]<=a[i])
          {
               sb.append("1 2 "+String.valueOf(i+1)+"\n");
               
               t2=true;
               break Upper;
          }
          }
          if(!t2&&i==n)
          sb.append("-1\n");
          }
          System.out.println(String.valueOf(sb));
     }
}