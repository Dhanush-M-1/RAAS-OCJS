import java.io.*;
import java.util.*;

public class D {
    DeluxeScanner in = new DeluxeScanner(null);
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);


    void run() {
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = in.nextIntArray(n);
        int cnt = 0;
        long low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                high = Math.min(high + a[i], d);
                low += a[i];
                if (low > high) {
                    out.print(-1);
                    out.close();
                    return;
                }
            }
            else {
                if (high >= 0) {
                    low = Math.max(0, low);
                }
                else {
                    cnt++;
                    high = d;
                    low = 0;
                }
            }
        }
        out.print(cnt);
        out.close();
    }

    public static void main(String[] args) {
        new D().run();
    }

    static class DeluxeScanner {
        BufferedReader br;
        StringTokenizer st;

        DeluxeScanner(String filename) {
            if (filename != null)
                try {
                    br = new BufferedReader(new FileReader(filename));
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            else
                br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
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

        char[] nextCharArray(int n) {
            char[] g = new char[n];
            g = next().toCharArray();
            return g;
        }

        char[][] nextChar2DArray(int n, int m) {
            char[][] g = new char[n][m];
            for (int i = 0; i < n; i++)
                g[i] = nextCharArray(m);
            return g;
        }

        double[] nextDoubleArray(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++)
                a[i] = nextDouble();
            return a;
        }

        double[][] nextDouble2DArray(int n, int m) {
            double[][] a = new double[n][m];
            for (int i = 0; i < n; i++)
                a[i] = nextDoubleArray(m);
            return a;
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        int[][] nextInt2DArray(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++)
                a[i] = nextIntArray(m);
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long[][] nextLong2DArray(int n, int m) {
            long[][] a = new long[n][m];
            for (int i = 0; i < n; i++)
                a[i] = nextLongArray(m);
            return a;
        }
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair (int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo (Pair pair) {
            if (this.first != pair.first)
                return this.first - pair.first;
            else
                return this.second - pair.second;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair))
                return false;
            Pair p = (Pair) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode() {
            return this.first  ^ this.second;
        }

        @Override
        public String toString() {
            return "" + '(' + this.first + ',' + this.second + ')';
        }
    }
}