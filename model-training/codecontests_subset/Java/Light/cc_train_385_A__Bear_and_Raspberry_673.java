import java.util.*;
import java.io.*;
public class apart
{
  public static void main(String args[]) throws IOException
  {
    try{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String ar[]=br.readLine().split(" ");
      int a=0,b=0;
      a=Integer.parseInt(ar[0]);
      b=Integer.parseInt(ar[1]);
      String arr[]=br.readLine().split(" ");
      int max=0;
      for(int i=0;i<a-1;i++)
      {
        max=Math.max(Integer.parseInt(arr[i])-Integer.parseInt(arr[i+1])-b,max);
      }
      System.out.println(max);
    }
    catch(Exception e){}
  }}