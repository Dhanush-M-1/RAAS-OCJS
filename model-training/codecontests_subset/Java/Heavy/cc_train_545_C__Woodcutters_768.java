import java.io.*;
import java.util.*;

public class Main implements Runnable {
    static boolean use_n_tests = false;
    static int stack_size = 1 << 27;

    void solve(FastScanner in, PrintWriter out, int testNumber) {
        int n = in.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            h[i] = in.nextInt();
        }
        int[][] dp = new int[n + 1][3];
        dp[0][0] = 1;
        if (n == 1 || (x[0] + h[0] < x[1])) {
            dp[0][1] = 1;
        }
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            int leftBound = x[i] - h[i];
            if (leftBound > x[i - 1]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][2] + 1);
            }
            if (leftBound > x[i - 1] + h[i - 1]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            }
            if (i == n - 1 || (x[i] + h[i] < x[i + 1])) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + 1);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][2] + 1);
            }
            dp[i][2] = Math.max(dp[i][2], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i][2], dp[i - 1][0]);
            dp[i][2] = Math.max(dp[i][2], dp[i - 1][2]);
        }
        out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));
    }

    // ****************************** template code ***********

    class Pair {
        int first;
        int second;

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    class Multiset<T> {
        int size = 0;

        Map<T, Integer> mp = new HashMap<>();

        void add(T x) {
            mp.merge(x, 1, Integer::sum);
            size++;
        }

        void remove(T x) {
            if (mp.containsKey(x)) {
                mp.merge(x, -1, Integer::sum);
                if (mp.get(x) == 0) {
                    mp.remove(x);
                }
                size--;
            }
        }

        int size() {
            return size;
        }

        int diffSize() {
            return mp.size();
        }
    }

    static class Range {
        int l, r;
        int id;

        public int getL() {
            return l;
        }

        public int getR() {
            return r;
        }

        public Range(int l, int r, int id) {
            this.l = l;
            this.r = r;
            this.id = id;
        }
    }

    static class Array {
        static Range[] readRanges(int n, FastScanner in) {
            Range[] result = new Range[n];
            for (int i = 0; i < n; i++) {
                result[i] = new Range(in.nextInt(), in.nextInt(), i);
            }
            return result;
        }

        static public Integer[] read(int n, FastScanner in) {
            Integer[] out = new Integer[n];
            for (int i = 0; i < out.length; i++) {
                out[i] = in.nextInt();
            }
            return out;
        }

        static public int[] readint(int n, FastScanner in) {
            int[] out = new int[n];
            for (int i = 0; i < out.length; i++) {
                out[i] = in.nextInt();
            }
            return out;
        }
    }

    class Graph {
        List<List<Integer>> create(int n) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            return graph;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream io) {
            br = new BufferedReader(new InputStreamReader(io));
        }

        public String line() {
            String result = "";
            try {
                result = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    void run_t_tests() {
        int t = in.nextInt();
        int i = 0;
        while (t-- > 0) {
            solve(in, out, i++);
        }
    }

    void run_one() {
        solve(in, out, -1);
    }

    @Override
    public void run() {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);
        if (use_n_tests) {
            run_t_tests();
        } else {
            run_one();
        }
        out.close();
    }

    static FastScanner in;
    static PrintWriter out;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(null, new Main(), "", stack_size);
        thread.start();
        thread.join();
    }
}