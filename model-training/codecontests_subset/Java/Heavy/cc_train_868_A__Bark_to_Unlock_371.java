import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class Main {

    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //(new FileReader("input.in"));
        StringBuilder out = new StringBuilder();
        PrintWriter p = new PrintWriter(System.out);
        StringTokenizer tk;
        Reader.init(System.in);
        String x=Reader.next();
        int q=Reader.nextInt();
        String []a=new String[q];
        for (int i = 0; i < q; i++) {
           a[i]=Reader.next();
        }
        for (int i = 0; i < q; i++) {
            
            for (int j = 0; j < q; j++) {
              String y=a[i]+a[j];
              if(y.contains(x)){
                    System.out.println("YES");
              return;
              }
            }
            
        }
        System.out.println("NO");
    }

}
class Reader {

    static StringTokenizer tokenizer;
    static BufferedReader reader;

    public static void init(InputStream input) throws UnsupportedEncodingException {
        reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        tokenizer = new StringTokenizer("");
    }

    public static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static String nextLine() throws IOException {
        return reader.readLine();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}