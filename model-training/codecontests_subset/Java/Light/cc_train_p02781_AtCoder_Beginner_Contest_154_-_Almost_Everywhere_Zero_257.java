import java.io.*;
import java.util.*;

public class Main {

    private static FastReader in = new FastReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    private static final long MOD = (long) 1e9 + 7;

    public static void main(String[] args) {
        solve();
        out.flush();
    }

    private static void solve() {
        String s = in.next();
        int k = in.nextInt();

        out.println(check(s, 0, k));
    }

    private static int check(String s, int current, int remain) {
        if (current == s.length()) {
            return remain == 0 ? 1 : 0;
        }

        if (remain == 0) {
            return 1;
        }

        int d = s.charAt(current) - '0';
        int ret = 0;
        for (int i = 0; i < d; i++) {
            if (i == 0) {
                ret += combination(s.length() - current - 1, remain) * power(9, remain);
            } else {
                ret += combination(s.length() - current - 1, remain - 1) * power(9, remain - 1);
            }
        }
        ret += check(s, current + 1, d == 0 ? remain : remain - 1);
        return ret;
    }

    private static int combination(int n, int r) {
        int ret = 1;
        for (int i = 0; i < r; i++) {
            ret *= (n - i);
        }
        for (int i = 1; i <= r; i++) {
            ret /= i;
        }
        return ret;
    }

    private static int power(int n, int pow) {
        int ret = 1;
        for (int i = 0; i < pow; i++) {
            ret *= n;
        }
        return ret;
    }

    // https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
                    e.printStackTrace();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        // https://qiita.com/masakinpo/items/5f77f2a879578a85a0bb
        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }
}
