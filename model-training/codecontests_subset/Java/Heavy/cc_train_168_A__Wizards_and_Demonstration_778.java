import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
  
  static void banana() throws IOException
  {
    int n = nextInt();
    int x = nextInt();
    
    int y = nextInt();
    
    int counter = 0;
    while ((x++) * 100 < n * y)
      ++counter;
    System.out.println(counter);
  }
}