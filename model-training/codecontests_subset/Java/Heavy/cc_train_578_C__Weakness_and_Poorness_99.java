import java.io.*;
import java.util.*;

public class Solution {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;

    static final int Mod = 1000000007;
    static final double inf = 10000000000.0;

    double calcMax(double f[]) {
        double res = 0, cur = 0;
        for (int i = 0; i < f.length; i++) {
            cur = Math.max(f[i], cur + f[i]);
            res = Math.max(res, cur);
        }
        return res;
    }

    double calcMin(double f[]) {
        double res = 0, cur = 0;
        for (int i = 0; i < f.length; i++) {
            cur = Math.min(f[i], cur + f[i]);
            res = Math.min(res, cur);
        }
        return res;
    }

    void solve() throws IOException {
        int n = nextInt();
        double a[] = new double[n];
        double b[] = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextDouble();
        }
        double l = -inf, r = inf;
        for (int it = 0; it < 200; it++) {
            double x = (l + r) / 2;
            for (int i = 0; i < n; i++) {
                b[i] = a[i] - x;
            }
            double max = calcMax(b), min = calcMin(b);
            if (-min > max) r = x;
            else l = x;
        }
        for (int i = 0; i < n; i++) {
            b[i] = a[i] - l;
        }
        double res = calcMax(b);
        out.println(res);
    }

    Solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}