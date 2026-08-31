import java.io.*;
import java.util.*;

public class Temp {
    static BufferedReader reader;
    static StringTokenizer tokenizer = null;
    static PrintWriter writer;

    static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    static String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
    

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(new OutputStreamWriter(System.out));

        int n = nextInt(), x=nextInt(), y=nextInt();
        int k = y*n/100-x;
        if ((x+k)*100/n<y) ++k;
        if (k<0) k=0;


        writer.println(k);
        
        reader.close();
        writer.close();
    }
}