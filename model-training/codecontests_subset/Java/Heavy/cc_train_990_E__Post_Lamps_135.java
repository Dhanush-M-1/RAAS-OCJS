import java.util.*;
import java.io.*;

// Solution

public class Main 
{    
  public static void main (String[] argv) 
  {
	  new Main();
  } 
     
  boolean test = false;
  
  int n;
  int[] pre;
  public Main(){
	  FastReader in = new FastReader(new BufferedReader(new InputStreamReader(System.in)));
	  //FastReader in = new FastReader(new BufferedReader(new FileReader("Main.in")));
      n = in.nextInt();
      int nb = in.nextInt();
      int k = in.nextInt();
      pre = new int[n];
      
      boolean[] blocked = new boolean[n];
      for (int i = 0; i < nb; ++i) blocked[in.nextInt()] = true;
      
      
      if (blocked[0]) {
          System.out.println(-1);
          return;
      }
      
      if (nb == 0) in.next();
      
      for (int i = 0; i < n; i++) {
          if (blocked[i]) pre[i] = pre[i-1];
          else pre[i] = i;
      }
            
      long cost = Long.MAX_VALUE;
      for (int i = 1; i <= k; i++) {
          long curCost = process(i, in.nextInt());
          cost = Math.min(cost, curCost);
      }
      
      if (cost == Long.MAX_VALUE)
          cost = -1;
      System.out.println(cost);
               
  }  
  
  private long process(int power, int price) {
     long cost = price;
     int hi = 0;
     while (hi < n) {
         if (hi + power >= n) break;
         
         int next = pre[hi + power];
         if (next <= hi) return Long.MAX_VALUE;
         
         hi = next;
         cost += price;
     }
     
     return cost;
  }  
  private int max(int a, int b) {
      return a >  b ? a : b;
  }
  
  private int min(int a, int b) {
      return a >  b ? b : a;
  }
  
  
  static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(BufferedReader in)
        {            
            br = in;
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    String line = br.readLine();
                    if (line == null || line.length() == 0) return "";
                    st = new StringTokenizer(line);
                }
                catch (IOException  e)
                {
                    return "";
                    //e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                return "";
                //e.printStackTrace();
            }
            return str;
        }
    }
}