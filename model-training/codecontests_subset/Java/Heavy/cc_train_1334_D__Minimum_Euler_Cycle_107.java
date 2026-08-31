import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int p=0;p<t;p++)
            {
                  String s1[]=br.readLine().split(" ");
                  int n=Integer.parseInt(s1[0]);
                  long l=Long.parseLong(s1[1]);
                  long r=Long.parseLong(s1[2]);
                  
                  
                  int u=1;
                  long x=0;
                  while(x<l && u<n)
                  {
                      x+=2*n-2*u;
                      if(x<l)
                       u++;
                      else
                      { x-=2*n-2*u; break; }
                  }
                  
                 //System.out.println(x+" "+u);
                  StringBuffer sb=new StringBuffer();
                  while(x<r)
                  {
                        for(int i=u+1;i<=n;i++)
                        {
                              x++;
                              if(x>=l && x<=r)
                               sb.append(u).append(" ");
                              x++;
                              if(x>=l && x<=r)
                               sb.append(i).append(" ");
                              // if(i!=n || (i==n && u==n-1))
                              //  x++;
                              // if(i!=n && x>=l && x<=r)
                              // System.out.println(u);
                              // if(i==n && u==n-1 && x+1>=l && x+1<=r)
                              // { System.out.print("1 "); x++; }
                        }
                        u++;
                        if(u>=n && x+1>=l && x+1<=r)
                        { sb.append("1 "); x++; }
                        //System.out.println("fcgjh");
                  }
                  
                  //System.out.println(sb);
                  System.out.println(sb);
            }
      }
}