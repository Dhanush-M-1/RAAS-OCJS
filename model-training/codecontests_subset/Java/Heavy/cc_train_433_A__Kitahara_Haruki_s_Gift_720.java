import java.util.*;
import java.awt.geom.*;
import java.io.*;
import java.math.*;

public class Main
{

  public static void main(String[] args) throws Exception
  {
    long startTime = System.nanoTime();
    int n=in.nextInt();
    int [] data=new int[n];
    int total=0;
    int ans=0;
    for(int i=0;i<n;i++)
    {
        data[i]=in.nextInt();
        total+=data[i];
    }
    Arrays.sort(data);
    total/=2;
    for(int i=n-1;i>=0;i--)
    {
        if(total-data[i]>=0 )
        {
            total-=data[i];
            data[i]=0;
        }
    }
    out.println(total==0 ? "YES" : "NO");
    long endTime = System.nanoTime();
    err.println("Execution Time : +" + (endTime-startTime)/1000000 + " ms");
    exit(0);
  }

  static class InputReader
  {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble(){
           return Double.parseDouble(next());
        }
    }

    static void exit(int a)
    {
      out.close();
      err.close();
      System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
