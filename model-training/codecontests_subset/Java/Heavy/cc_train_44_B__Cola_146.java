import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    FastScanner in = new FastScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Main().solve();
    }
    

    void solve() {     
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        
        long counter = 0;
        n = n * 2;
        for (int j = 0; j <= b; j++){
            for (int k = 0; k <= c; k++){
                int tmp = n - 2*j - 4*k;
                if (tmp >= 0 && tmp <= a){
                    counter++;
                }               
            }
        }
        System.out.println(counter);
    }   
}

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                System.err.println(e);
                return "";
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    float nextFloat() {
        return Float.parseFloat(next());
    }

     BigInteger nextBigInt() {
         return new BigInteger(next());
     }

    void close() {
        try {
            br.close();
        } catch (IOException e) {
        }
    }
}