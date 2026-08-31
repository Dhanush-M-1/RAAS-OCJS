import java.util.*;
import java.awt.geom.*;
import java.io.*;
import java.math.*;

public class Main
{

  public static void main(String[] args)
  {
    long startTime = System.nanoTime();
    int n=in.nextInt();
    double [] sequence = new double[n];
    double min=0;
    double max=0;
    for(int i=0;i<n;i++)
    {
        sequence[i]=in.nextInt();
        if(sequence[i]<min)
        {
            min=sequence[i];
        }
        if(sequence[i]>max)
        {
            max=sequence[i];
        }        
    }
    out.println(f(sequence,GSS(30000,-30000,0.0000000000000001,sequence)));
    long endTime = System.nanoTime();
    err.println("Execution Time : +" + (endTime-startTime)/1000000 + " milli secs");
    exit(0);
  }



  static double f(double [] sequence,double x)
  {
    double max_so_far_p=0;
    double max_ending_here_p=0;
    double max_so_far_n=0;
    double max_ending_here_n=0;
    for(int i=0;i<sequence.length;i++)
    {
        max_ending_here_p = Math.max(0, max_ending_here_p + sequence[i]-x);
        max_so_far_p = Math.max(max_so_far_p, max_ending_here_p);
        max_ending_here_n = Math.min(0, max_ending_here_n + sequence[i]-x);
        max_so_far_n = Math.min(max_so_far_n, max_ending_here_n);
    }
    return Math.max(max_so_far_p,Math.abs(max_so_far_n));
  }
  

  static double GSS(double a,double b,double precision,double [] sequence)
  {
    double gr = (Math.sqrt(5) + 1) / 2;
    double c = b - (b - a) / gr;
    double d = a + (b - a) / gr;
    //Find minimum of unimodal function f() within [left, right]
    //To find the  maximum, reverse the if/else statement or reverse the comparison.

    while(Math.abs(c-d) > precision ) 
    {
        if( f(sequence,c) < f(sequence,d) )
        {
            b=d;
        }
        else
        {
            a=c;
        }
        c = b - (b - a) / gr;
        d = a + (b - a) / gr;
    }
    return (a+b)/2.0;
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

}
