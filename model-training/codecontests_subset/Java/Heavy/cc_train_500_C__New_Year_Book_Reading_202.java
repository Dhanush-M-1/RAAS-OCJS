import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1[]=br.readLine().split(" ");
            int n=Integer.parseInt(s1[0]);
            int m=Integer.parseInt(s1[1]);
            
            String s2[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++)
             a[i]=Integer.parseInt(s2[i]);
            
            Stack<Integer> st=new Stack<Integer>();
            Stack<Integer> st1=new Stack<Integer>();
            HashSet<Integer> hs=new HashSet<Integer>();
            String s3[]=br.readLine().split(" ");
            int b[]=new int[m];
            for(int i=0;i<m;i++)
            {
                  int u=Integer.parseInt(s3[i]);
                  b[i]=u;
                  if(!hs.contains(u))
                  st.push(u);
                  hs.add(u);
            }
            
            while(!st.empty())
            {
                  st1.push(st.pop());
            }
            
            int S=0;
            for(int i=0;i<m;i++)
            {
                  while(!st1.empty() && st1.peek()!=b[i])
                  {
                        int u=st1.pop();
                        S+=a[u-1];
                        st.add(u);
                  }
                  
                  st1.pop();
                  while(!st.empty())
                  {
                  st1.push(st.pop());
                  }
                  
                  st1.push(b[i]);
            }
            
            System.out.println(S);
      }
}