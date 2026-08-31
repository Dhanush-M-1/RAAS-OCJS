import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private FastScanner scanner = new FastScanner();

    public static void main(String[] args) {
        new Main().solve();
    }

    List<List<Integer>> gr = new ArrayList<>();

    boolean used[];
    List<Integer> ans = new ArrayList<>();


    private void solve() {
        int n = scanner.nextInt();

        int a[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }

        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (a[i][0] - a[i][1] > a[i - 1][0]) {
                ans ++;
                continue;
            }

            if (i + 1 == n || a[i][0] + a[i][1] < a[i + 1][0]) {
                ans ++;
                a[i][0] += a[i][1];
            }
        }

        System.out.print(ans);
    }

    public static final <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    class Pair implements Comparable<Pair> {
        int a, i;

        public Pair(int a, int i) {
            this.a = a;
            this.i = i;
        }

        @Override
        public int compareTo(Pair o) {
            return this.a - o.a;
        }
    }

    long gcd(long a, long b) {
        if (b != 0) {
            return gcd(b, a % b);
        }
        return a;
    }

    void initGr(int n, int m) {
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1, v = scanner.nextInt() - 1;
            gr.get(u).add(v);
            gr.get(v).add(u);
        }
    }

    class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}