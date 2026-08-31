import java.io.*;
import java.util.*;

public class J {
    public static void solution(BufferedReader reader, PrintWriter writer)
            throws IOException {
        In in = new In(reader);
        Out out = new Out(writer);
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(n);
        int total = 0;
        for (int i = 0; i < n; i++)
            total += a[i];
        int MAX = 10000;
        int[][][] dp = new int[n + 1][n + 1][MAX + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                Arrays.fill(dp[i][j], -1);
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= i; j++)
                for (int k = 0; k <= MAX; k++)
                    if (dp[i][j][k] != -1) {
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k],
                                dp[i][j][k]);
                        dp[i + 1][j + 1][k + b[i]] = Math.max(
                                dp[i + 1][j + 1][k + b[i]], dp[i][j][k] + a[i]);
                    }
        int k = n, t = MAX;
        for (int i = 0; i <= k; i++)
            for (int j = total; j <= MAX; j++)
                if (dp[n][i][j] != -1) {
                    k = i;
                    t = Math.min(t, total - dp[n][i][j]);
                }
        out.println(String.format("%d %d", k, t));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(System.out)));
        solution(reader, writer);
        writer.close();
    }

    protected static class In {
        private BufferedReader reader;
        private StringTokenizer tokenizer = new StringTokenizer("");

        public In(BufferedReader reader) {
            this.reader = reader;
        }

        public String next() throws IOException {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public int[] nextIntArray1(int n) throws IOException {
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = nextInt();
            return a;
        }

        public int[] nextIntArraySorted(int n) throws IOException {
            int[] a = nextIntArray(n);
            Random r = new Random();
            for (int i = 0; i < n; i++) {
                int j = i + r.nextInt(n - i);
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
            Arrays.sort(a);
            return a;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public long[] nextLongArray1(int n) throws IOException {
            long[] a = new long[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = nextLong();
            return a;
        }

        public long[] nextLongArraySorted(int n) throws IOException {
            long[] a = nextLongArray(n);
            Random r = new Random();
            for (int i = 0; i < n; i++) {
                int j = i + r.nextInt(n - i);
                long t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
            Arrays.sort(a);
            return a;
        }
    }

    protected static class Out {
        private PrintWriter writer;
        private static boolean local = System
                .getProperty("ONLINE_JUDGE") == null;

        public Out(PrintWriter writer) {
            this.writer = writer;
        }

        public void print(char c) {
            writer.print(c);
        }

        public void print(int a) {
            writer.print(a);
        }

        public void println(String s) {
            writer.println(s);
        }

        public void println(int a) {
            writer.println(a);
        }

        public void println(long a) {
            writer.println(a);
        }

        public void println(Object[] os) {
            for (int i = 0; i < os.length; i++) {
                writer.print(os[i]);
                writer.print(' ');
            }
            writer.println();
        }

        public void println(int[] a) {
            for (int i = 0; i < a.length; i++) {
                writer.print(a[i]);
                writer.print(' ');
            }
            writer.println();
        }

        public void println(long[] a) {
            for (int i = 0; i < a.length; i++) {
                writer.print(a[i]);
                writer.print(' ');
            }
            writer.println();
        }

        public static void db(Object... objects) {
            if (local)
                System.out.println(Arrays.deepToString(objects));
        }
    }
}
