import java.util.*;
import java.io.*;
public class apart
{
  public static void main(String args[]) throws IOException
  {
    try{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int t=0;
    t=Integer.parseInt(br.readLine());
    while(t-->0)
    {
      String ar[]=br.readLine().split(" ");
      int n=0,m=0;
      n=Integer.parseInt(ar[0]);
      m=Integer.parseInt(ar[1]);
      char s[]=br.readLine().toCharArray();
      long alpha[]=new long[26];
      String p[]=br.readLine().split(" ");
      int pos[]=new int[m];
      long count[]=new long[n];
      for(int i=0;i<m;i++)
      {
        count[Integer.parseInt(p[i])-1]+=1;
      }
      for(int i=n-1;i>=1;i--)
      {
        count[i-1]+=count[i];
      }
      for(int i=0;i<s.length;i++)
      {
        alpha[(int)s[i]-'a']+=count[i]+1;
      }
      for(int i=0;i<26;i++)
      {
        System.out.print(alpha[i]+" ");
      }
      System.out.println();
    }}
    catch(Exception e){}
  }}