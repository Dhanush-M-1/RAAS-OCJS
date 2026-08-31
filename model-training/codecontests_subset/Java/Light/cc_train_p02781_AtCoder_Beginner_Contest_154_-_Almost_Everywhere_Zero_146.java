import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

class Main {
    static In in = new In();
    static Out out = new Out();
    static long mod = 1000000007;
    static long inf = 0xfffffffffffffffL;

    void solve() {
        String s = in.next();
        int n = s.length();
        int k = in.nextInt();
        int[][] dp1 = new int[n][k + 2];
        int[][] dp2 = new int[n][k + 2];
        dp1[0][0] = 1;
        dp1[0][1] = (s.charAt(0) - '0') - 1;
        dp2[0][1] = 1;
        for (int i = 1; i < n; i++) {
            int c = s.charAt(i) - '0';
            for (int j = 0; j <= k; j++) {
                if (c == 0) {
                    dp1[i][j] += dp1[i - 1][j];
                    dp2[i][j] += dp2[i - 1][j];
                    dp1[i][j + 1] += dp1[i - 1][j] * 9;
                } else {
                    dp1[i][j] += dp1[i - 1][j];
                    dp1[i][j] += dp2[i - 1][j];
                    dp1[i][j + 1] += dp1[i - 1][j] * 9;
                    dp1[i][j + 1] += dp2[i - 1][j] * (c - 1);
                    dp2[i][j + 1] += dp2[i - 1][j];
                }
            }
        }
        out.println(dp1[n - 1][k] + dp2[n - 1][k]);
    }

    public static void main(String[]$) {
        new Main().solve();
        out.flush();
    }
}

class In {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 0x10000);
    private StringTokenizer tokenizer;

    String next() {
        try {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        } catch (IOException ignored) {
        }
        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    char[][] nextCharArray(int n, int m) {
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        return a;
    }

    int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    int[] nextIntArray(int n, IntUnaryOperator op) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = op.applyAsInt(nextInt());
        }
        return a;
    }

    long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        return a;
    }

    long[] nextLongArray(int n, LongUnaryOperator op) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = op.applyAsLong(nextLong());
        }
        return a;
    }
}

class Out {
    private static PrintWriter out = new PrintWriter(System.out);

    void println(Object... a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (Object obj : a) {
            joiner.add(String.valueOf(obj));
        }
        out.println(joiner);
    }

    void flush() {
        out.flush();
    }
}
