import java.io.*;
import java.util.*;
public class InitialBet 
{
    public static void main(String[] args) throws IOException
    {
        //Locale.setDefault (Locale.US);
        Reader in = new Reader();
        StringBuilder out = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += in.nextInt();
        }
        if(sum%5==0 && sum/5 != 0)
            System.out.println(sum/5);
        else
            System.out.println("-1");
    }
    static class  Reader 
    {
        BufferedReader br;
        StringTokenizer st;
        Reader() { // To read from the standard input
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        Reader(int i) throws IOException { // To read from a file
            br = new BufferedReader(new FileReader("Sample Input.txt"));
        }
       String next() throws IOException {
          while (st == null || !st.hasMoreTokens())
             st = new StringTokenizer(br.readLine());
          return st.nextToken();
       }
       int nextInt() throws IOException { return Integer.parseInt(next()); }
       long nextLong() throws IOException { return Long.parseLong(next()); }
       double nextDouble() throws IOException { return Double.parseDouble(next()); }
       String nextLine() throws IOException { return br.readLine(); }
    }

}