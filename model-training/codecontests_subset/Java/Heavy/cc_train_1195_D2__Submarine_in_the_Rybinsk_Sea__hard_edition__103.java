import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
    FastScanner in;
    PrintWriter out;
    boolean multitests = false;
    long mod = 998_244_353L; // (long) 1e9 + 7 || (long) 1e9 + 9
    ArrayList<Integer>[] graph;
    ArrayList<Integer>[] weigtedGraph;

    private void solve() throws IOException {
        solveA();
        // solveB();
        // solveC();
        // solveD();
        // solveE();
        // solveF();
        // solveG();
        // solveH();
    }

    private void solveA() throws IOException {
        int n = in.nextInt();
        long[] a = in.nextLongArray(n);

        long[] ten = new long[25];
        ten[0] = 1;
        for (int i = 1; i < ten.length; i++)
            ten[i] = ten[i - 1] * 10L % mod;

        long[] prefCnt = new long[17];
        for (int i = 0; i < n; i++)
            prefCnt[Long.toString(a[i]).length()]++;
        for (int i = 1; i < prefCnt.length; i++)
            prefCnt[i] += prefCnt[i - 1];

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long cur = a[i];
            for (int j = 0; cur > 0; cur /= 10, j++) {
                long digit = cur % 10;
                if (digit == 0) continue;

                ans += ten[j * 2] * (prefCnt[prefCnt.length - 1] - prefCnt[max(0, j - 1)]) * digit % mod;
                ans %= mod;
                for (int k = 1; j + k < j * 2; k++) {
                    ans += ten[j + k] * (prefCnt[k] - prefCnt[k - 1]) * digit % mod;
                    ans %= mod;
                }

                ans += ten[j * 2 + 1] * (prefCnt[prefCnt.length - 1] - prefCnt[j]) * digit % mod;
                ans %= mod;
                for (int k = 1; j + k <= j * 2; k++) {
                    ans += ten[j + k] * (prefCnt[k] - prefCnt[k - 1]) * digit % mod;
                    ans %= mod;
                }
            }
        }

        out.println(ans);
    }

    private void solveB() throws IOException {

    }

    private void solveC() throws IOException {

    }

    private void solveD() throws IOException {

    }

    private void solveE() throws IOException {

    }

    private void solveF() throws IOException {

    }

    private void solveG() throws IOException {

    }

    private void solveH() throws IOException {

    }

    void shuffleInt(int[] a) {
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int swap = a[j];
            a[j] = a[i];
            a[i] = swap;
        }
    }

    void shuffleLong(long[] a) {
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            long swap = a[j];
            a[j] = a[i];
            a[i] = swap;
        }
    }

    void reverseInt(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
    }

    void reverseLong(long[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            long swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
    }

    int maxInt(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (max < a[i])
                max = a[i];
        return max;
    }

    long maxLong(long[] a) {
        long max = a[0];
        for (int i = 1; i < a.length; i++)
            if (max < a[i])
                max = a[i];
        return max;
    }

    int minInt(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++)
            if (min > a[i])
                min = a[i];
        return min;
    }

    long minLong(long[] a) {
        long min = a[0];
        for (int i = 1; i < a.length; i++)
            if (min > a[i])
                min = a[i];
        return min;
    }

    long sum(int[] a) {
        long s = 0;
        for (int i = 0; i < a.length; i++)
            s += a[i];
        return s;
    }

    long sum(long[] a) {
        long s = 0;
        for (int i = 0; i < a.length; i++)
            s += a[i];
        return s;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long binpowmod(long a, long n) {
        long res = 1;
        a %= mod;
        n %= mod - 1;
        while (n > 0) {
            if (n % 2 == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            n /= 2;
        }
        return res;
    }

    class GraphPair implements Comparable<GraphPair> {
        int v;
        long w;

        GraphPair(int v, long w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(GraphPair o) {
            return w != o.w ? Long.compare(w, o.w) : Integer.compare(v, o.v);
        }
    }

    class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        boolean hasNext() throws IOException {
            return br.ready() || (st != null && st.hasMoreTokens());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            return a;
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextLong();
            return a;
        }

        ArrayList<Integer>[] nextGraph(int n, int m, boolean directed) throws IOException {
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int v = in.nextInt() - 1, u = in.nextInt() - 1;
                graph[v].add(u);
                if (!directed)
                    graph[u].add(v);
            }
            return graph;
        }

        ArrayList<GraphPair>[] nextWeightedGraph(int n, int m, boolean directed) throws IOException {
            ArrayList<GraphPair>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++)
                graph[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int v = in.nextInt() - 1, u = in.nextInt() - 1;
                long w = in.nextLong();
                graph[v].add(new GraphPair(u, w));
                if (!directed)
                    graph[u].add(new GraphPair(v, w));
            }
            return graph;
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        boolean hasNextLine() throws IOException {
            return br.ready();
        }
    }

    private void run() throws IOException {
        in = new FastScanner(System.in); // new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out); // new PrintWriter(new FileOutputStream(".out"));

        for (int t = multitests ? in.nextInt() : 1; t-- > 0; )
            solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}