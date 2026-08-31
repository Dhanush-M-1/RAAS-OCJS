import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class D {

    void solve() throws Exception {
        long n = nl();
        long l = nl();
        long r = nl();
        long h = 0L;
        long b = 1L;
        for (long i = n - 1; h + 2 * i < l && i > 0; i--) {
            h += 2*i;
            b++;
        }
        long c = b;
        if (b == n) {
            out.println(1);
            return;
        }

        while (h < l) {
            h++;
            if ((h & 1) == 1) {
                c++;
            }
        }
        while (h <= r) {
            if ((h & 1) == 1) {
                out.print(b + " ");
            } else {
                out.print(c + " ");
                c++;
                if (c > n) {
                    b++;
                    c = b + 1;
                    if (b == n) {
                        b = 1;
                    }
                }
            }
            h++;
        }
        out.println();
    }

    void run() throws Exception {
        initIO();
        int t = ni();
        while (t-- > 0) {
            solve();
            out.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        new D().run();
    }

    /**
     * IO.
     */

    PrintWriter out;
    BufferedReader br;
    StringTokenizer tokenizer;

    void initIO() {
        out = new PrintWriter(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = null;
    }

    int ni() throws Exception {
        return Integer.parseInt(ns());
    }

    long nl() throws Exception {
        return Long.parseLong(ns());
    }

    double nd() throws Exception {
        return Double.parseDouble(ns());
    }

    int[] nia(int n) throws Exception {
        int[] x = new int[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = ni();
        }
        return x;
    }

    long[] nla(int n) throws Exception {
        long[] x = new long[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = nl();
        }
        return x;
    }

    double[] nda(int n) throws Exception {
        double[] x = new double[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = nd();
        }
        return x;
    }

    String ns() throws Exception {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(br.readLine());
        return tokenizer.nextToken();
    }

    String nline() throws Exception {
        tokenizer = null;
        return br.readLine();
    }
}
