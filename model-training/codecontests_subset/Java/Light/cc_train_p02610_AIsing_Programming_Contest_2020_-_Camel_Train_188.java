import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public class Main {
    static In in = new In();
    static Out out = new Out();
    static final long mod = 1000000007;
    static final long inf = 0x1fffffffffffffffL;
    static final int iinf = 0x3fffffff;

    void solve() {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            out.println(solveCase());
        }
    }

    long solveCase() {
        int n = in.nextInt();
        List<Pair> left = new ArrayList<>();
        List<Pair> right = new ArrayList<>();
        long base = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            base += Math.min(l, r);
            if (l < r) {
                right.add(new Pair(k, r - l));
            } else if (l > r) {
                left.add(new Pair(k, l - r));
            }
        }
        right.sort(Comparator.comparingInt(pair -> pair.first));
        left.sort(Comparator.comparingInt(pair -> -pair.first));
        int m = left.size();
        {
            PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int j = 0;
            for (int i = m; i < n; i++) {
                while (j < right.size() && right.get(j).first <= i) {
                    queue.add(right.get(j).second);
                    j++;
                }
                if (!queue.isEmpty()) {
                    ans += queue.poll();
                }
            }
        }
        {
            PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int j = 0;
            for (int i = m - 1; i >= 0; i--) {
                while (j < left.size() && left.get(j).first > i) {
                    queue.add(left.get(j).second);
                    j++;
                }
                if (!queue.isEmpty()) {
                    ans += queue.poll();
                }
            }
        }
        return ans + base;
    }

    public static void main(String[]$) {
        new Main().solve();
        out.flush();
    }
}

class Pair implements Comparable<Pair> {
    int first;
    long second;

    Pair(int first, long second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair that = (Pair)o;
        return first == that.first && second == that.second;
    }

    @Override
    public int compareTo(Pair o) {
        return first == o.first ? Long.compare(second, o.second) : Integer.compare(first, o.first);
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", first, second);
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

    char[] nextCharArray() {
        return next().toCharArray();
    }

    char[][] nextCharGrid(int n, int m) {
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

    List<List<Integer>> nextEdges(int n, int m) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            res.get(u).add(v);
            res.get(v).add(u);
        }
        return res;
    }
}

class Out {
    private PrintWriter out = new PrintWriter(System.out);
    boolean autoFlush = false;

    void println(Object... a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (Object obj : a) {
            joiner.add(String.valueOf(obj));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(char[] s) {
        out.println(String.valueOf(s));
        if (autoFlush) {
            out.flush();
        }
    }

    void println(int[] a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (int i : a) {
            joiner.add(Integer.toString(i));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(long[] a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (long i : a) {
            joiner.add(Long.toString(i));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void flush() {
        out.flush();
    }
}
