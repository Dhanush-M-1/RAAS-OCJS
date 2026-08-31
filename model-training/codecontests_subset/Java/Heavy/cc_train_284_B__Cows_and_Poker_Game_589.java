import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  static PrintWriter writer;
  
  static int nextInt() throws IOException
  {
    return Integer.parseInt(nextToken());
  }
  
  static long nextLong() throws IOException
  {
    return Long.parseLong(nextToken());
  }
  
  static double nextDouble() throws IOException
  {
    return Double.parseDouble(nextToken());
  }
  
  static boolean eof = false;
  
  static String nextToken() throws IOException
  {
    while (tokenizer == null || !tokenizer.hasMoreTokens())
    {
      tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }
  
  public static void main(String[] args) throws IOException
  {
    tokenizer = null;
    reader = new BufferedReader(new InputStreamReader(System.in));
    writer = new PrintWriter(System.out);
    banana();
    reader.close();
    writer.close();
  }
  
  static class Point
  {
    public long x, y;
    
    public Point(long x, long y)
    {
      this.x = x;
      this.y = y;
    }
  }
  
  static void banana() throws IOException
  {
    int n = nextInt();
    String s = nextToken();
    
    int t = 0;
    for (int i = 0; i < n; ++i)
      if (s.charAt(i) == 'I')
        t++;
    if (t == 0)
    {
      for (int i = 0 ; i < n; ++i)
        if (s.charAt(i) == 'A')
          ++t;
      System.out.println(t);
    }
    else if (t == 1)
    {
      System.out.println(1);
    }
    else
      System.out.println(0);
    
  }
}