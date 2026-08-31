import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static FastReader in = new FastReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    private static final long MOD = (long) 1e9 + 7;

    public static void main(String[] args) {
        solve();
        out.flush();
    }

    private static void solve() {
        String n = in.next();
        int k = in.nextInt();

        long ans = 0;
        for (int digits = 1; digits <= n.length(); digits++) {
            if (digits < k) continue;

            if (digits < n.length()) {
                // all combinations are possible
                ans += 9 * combination(digits - 1, k - 1) * power(9, k - 1);
            } else {
                String msd = n.substring(0, 1);
                char[] chosen = new char[digits - 1];
                Arrays.fill(chosen, '0');
                ans += (Integer.parseInt(msd) - 1) * combination(digits - 1, k - 1) * power(9, k - 1);
                ans += check(n, msd, chosen, k - 1, 0);
            }
            // out.println(ans);
        }
        out.println(ans);
    }

    private static int check(String n, String msd, char[] chosen, int remain, int start) {
        if (remain == 0) {
            int ret = 0;
            // out.println("Comparing: " + (msd + String.valueOf(chosen)));
            if (n.compareTo(msd + String.valueOf(chosen)) >= 0) {
                ret++;
            }
            return ret;
        }

        int ret = 0;
        for (int i = start; i < chosen.length; i++) {
            if (chosen[i] != '0') continue;

            for (int digit = 1; digit <= 9; digit++) {
                chosen[i] = String.valueOf(digit).charAt(0);
                ret += check(n, msd, chosen, remain - 1, i + 1);
            }
            chosen[i] = '0';
        }
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

    private static int power(int x, int power) {
        int ret = 1;
        for (int i = 0; i < power; i++) {
            ret *= x;
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
