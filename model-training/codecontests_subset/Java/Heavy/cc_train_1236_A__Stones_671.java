import java.io.*;
import java.util.*;

/**
  * Built using my Brain
  * Actual solution is at the bottom
  *
  * @author Lenard Hoffstader
*/

public class cfjava
{
  public static void main(String[] args)
  {
    OutputStream outputStream = System.out;
    FastReader in = new FastReader();
    PrintWriter out = new PrintWriter(outputStream);
    PROBLEM solver = new PROBLEM();
    int t=1;
    t=in.nextInt();
    for(int i=0;i<t;i++){
      solver.solve(in, out);
    }
    out.close();
  }

  static class PROBLEM
  {
    public void solve(FastReader in,PrintWriter out)
    {
      int a=in.nextInt(); 
      int b=in.nextInt(); 
      int c=in.nextInt();
      int ans = 0;
      int tmp = Math.min(b,c/2);
      b-=tmp;
      ans+=3*tmp;
      tmp=Math.min(a,b/2);
      ans+=3*tmp;
      out.println(ans);
    }
  }
  
  static class FastReader 
  {
    BufferedReader br; 
    StringTokenizer st;

    public FastReader() 
    { 
      br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next() 
    { 
      while (st == null || !st.hasMoreElements()) 
      {
        try
        { 
          st = new StringTokenizer(br.readLine()); 
        } 
        catch (IOException  e) 
        { 
          e.printStackTrace(); 
        } 
      } 
      return st.nextToken(); 
    } 

    int nextInt(){return Integer.parseInt(next());}

    long nextLong(){return Long.parseLong(next());} 

    double nextDouble(){return Double.parseDouble(next());}

    boolean nextBoolean(){return Boolean.parseBoolean(next());}

    String nextLine() 
    { 
      String str = ""; 
      try
      { 
        str = br.readLine(); 
      } 
      catch (IOException e){e.printStackTrace();} 
      return str; 
    } 
  }
}
