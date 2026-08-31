import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(br.readLine());
    while(t--!=0)
    {
      StringTokenizer st=new StringTokenizer(br.readLine());
      int m=Integer.parseInt(st.nextToken());
      int n=Integer.parseInt(st.nextToken());
      StringTokenizer st1=new StringTokenizer(br.readLine());
      StringTokenizer st2=new StringTokenizer(br.readLine());

      int[] a=new int[1001];
      int flag=0;

      for(int i=0;i<m;i++)
      {
        int x=Integer.parseInt(st1.nextToken());
        a[x]=x;

      }
      for(int i=0;i<n;i++)
      {
        int x=Integer.parseInt(st2.nextToken());
        if(a[x]==0)
        {
          continue;
        }
        else
        {
          System.out.println("YES");
          System.out.println("1 "+x);
          flag=1;
          break;
        }
      }
      if(flag==0)
      System.out.println("NO");
    }
  }
}
