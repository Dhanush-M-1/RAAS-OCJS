import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map;

//import jdk.internal.org.jline.utils.InputStreamReader;

import java.util.HashMap;

/* Name of the class has to be "Main" only if the class is public. */
public class q1 {
    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int t = Integer.parseInt(sc.next());
      while(t-->0)
      {
          int k = Integer.parseInt(sc.next());
          int n = Integer.parseInt(sc.next());
          int m = Integer.parseInt(sc.next());
          int[] a1= new int[n];
          int[] a2= new int[m];
          for(int i=0;i<n;i++)
          {
              a1[i]= Integer.parseInt(sc.next());
          }
          for(int i=0;i<m;i++)
          {
              a2[i]= Integer.parseInt(sc.next());
          }
          int f=0,s=0;
          int curr=0;
          int[] ans= new int[m+n];
          int flag=0;
          while(f<n || s<m )
          {
              if(f<n && a1[f]==0)
              {
                  ++k;
                  f++;
                  ans[curr++]=0;
                  continue;
              }
              if(s<m && a2[s]==0)
              {
                  ++k;
                  s++;
                  ans[curr++]=0;
                  continue;
              }
              if(s==m && a1[f]<=k)
              {
                  ans[curr++]=a1[f];
                  f++;
                  continue;
              }
              if(f==n && a2[s]<=k)
              {
                ans[curr++]=a2[s];
                  s++;
                  continue;
              }
              if(f<n && s<m && a1[f]<=a2[s] && a1[f]<=k)
              {
                ans[curr++]=a1[f];
                f++;
                continue;
              }
              if(f<n && s<m && a2[s]<a1[f] && a2[s]<=k)
              {
                ans[curr++]=a2[s];
                s++;
                continue;
              }
              else
              {
                  System.out.println("-1");
                  flag=1;
                  break;
              }
          }
          if(f==n && s==m )
          {
              for(int i=0;i<ans.length;i++)
              {
                  System.out.print(ans[i]+" ");
              }
              System.out.println("");
          }
      }
       
   }
  
}