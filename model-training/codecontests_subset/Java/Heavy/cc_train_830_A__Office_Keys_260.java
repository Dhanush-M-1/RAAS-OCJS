import java.io.*;
import java.util.*;

public class D {
    public static void solution(BufferedReader reader, PrintWriter writer)
            throws IOException {
        In in = new In(reader);
        Out out = new Out(writer);
        int n = in.nextInt(), k = in.nextInt();
        long p = in.nextInt();
        int[] a = in.nextIntArraySorted(n);
        int[] b = in.nextIntArraySorted(k);
        long left = -1, right = 2 * 1000 * 1000 * 1000;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            int ai = 0, bi = 0;
            while (ai < n && bi < k) {
                if (Math.abs(a[ai] - b[bi]) + Math.abs(b[bi] - p) <= mid) {
                    ai++;
                    bi++;
                }
                else
                    bi++;
            }
            if (ai == n)
                right = mid;
            else
                left = mid;
        }
        out.println(right);
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

        public void printb(int a) {
            writer.print(a);
            writer.print(' ');
        }

        public void println(Object a) {
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

        public void flush() {
            writer.flush();
        }

        public static void db(Object... objects) {
            if (local)
                System.out.println(Arrays.deepToString(objects));
        }
    }
}
