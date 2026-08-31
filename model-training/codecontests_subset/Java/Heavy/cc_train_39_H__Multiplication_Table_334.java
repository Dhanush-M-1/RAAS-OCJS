import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    void solve() throws IOException {
        int n = ni();
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                BigInteger a = BigInteger.valueOf(i * j);
                out.print(a.toString(n) + " ");
            }
            out.println();
        }
    }

    public Main() throws IOException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    String ns() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int ni() throws IOException {
        return Integer.valueOf(ns());
    }

    long nl() throws IOException {
        return Long.valueOf(ns());
    }

    double nd() throws IOException {
        return Double.valueOf(ns());
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
