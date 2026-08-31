import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by yujiahao on 6/15/16.
 */
public class cf_350_b {
    private FastScanner in;
    private PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        long k = in.nextLong();

        int[] a = new int[n];
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }

        if (k==1){
            out.print(a[0]);
            return;
        }

        long l = binarySearch((long)1, (long)n, (long)k);

        long alreayPass = (l-1+1)*(l-1)/2;
        k -= alreayPass;

        out.print(a[(int)k-1]);
    }

    public long binarySearch(long l, long r, long k){
        while (l<r){
            long m = l+(r-l)/2;
            long total = (m+1)*m/2;
            if (total<k){
                l = m+1;
            }else{
                r = m;
            }
        }

        return l;
    }


    public void run() {
        try {
            in = new FastScanner();
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() { return new BigInteger(next());}

    }

    public static void main(String[] arg) {
        new cf_350_b().run();
    }
}
