import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1[]=br.readLine().split(" ");
            int n=Integer.parseInt(s1[0]);
            long d=Long.parseLong(s1[1]);
            
            String s2[]=br.readLine().split(" ");
            long a[]=new long[n];
            for(int i=0;i<n;i++)
             a[i]=Long.parseLong(s2[i]);
            
            long S=0;
            long t=0;
            long v=0;
            for(int i=0;i<n;i++)
            {
                  if(a[i]==0)
                  {
                        long p=0;
                        if(S<0)
                        {
                         if(S+v>=0)
                         { v=S+v; S=0; }
                         S=Math.min(0,S+v);
                        }
                        if(S<0)
                        {
                              S=0;
                              p=1;
                        }
                        //System.out.println(p+" "+v);
                        if(p>0)
                        { t++; v=d; }
                  }
                   S+=a[i];
                  
                  if(S>d)
                  { t=-1; break;  }
                  v=Math.min(v,d-S);
            }
            
            System.out.println(t);
      }
}