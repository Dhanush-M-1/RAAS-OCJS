import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by yujiahao on 5/9/16.
 */
public class cf_303_c {
    private FastScanner in;
    private PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        long[] x = new long[n];
        long[] h = new long[n];
        for (int i=0; i<n; i++){
            x[i] = in.nextLong();
            h[i] = in.nextLong();
        }

        /*
        int res = 2;
        boolean flag = false;
        for (int i=1; i<n-1; i++){
            if (x[i]-x[i-1]>h[i] && flag==false || x[i]-x[i-1]-h[i-1]>=h[i] && flag == true){
                res++;
                flag = false;
            }else if (x[i+1]-x[i] > h[i]){
                res++;
                flag = true;
            }
        }
        */

        int res = 0;
        if (n==2){
            out.print("2");
            return;
        }else if (n==1){
            out.print("1");
            return;
        }
        res = 2;

        long[] a = new long[n];
        int j = 0;
        a[0] = x[0];

        for (int i=1; i<n-1; i++){
            if (x[i]-x[i-1]>h[i] && x[i]-h[i]>a[j]){
                res ++;
                a[++j] = x[i];
            }else if (x[i+1]-x[i]>h[i]){
                res ++;
                a[++j] = x[i]+h[i];
            }
        }


        out.print(res);
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
        new cf_303_c().run();
    }
}
