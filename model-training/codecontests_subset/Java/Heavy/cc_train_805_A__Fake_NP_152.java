import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Template implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }

    class GraphBuilder {
        int n, m;
        int[] x, y;
        int index;
        int[] size;


        GraphBuilder(int n, int m) {
            this.n = n;
            this.m = m;
            x = new int[m];
            y = new int[m];
            size = new int[n];
        }

        void add(int u, int v) {
            x[index] = u;
            y[index] = v;
            size[u]++;
            size[v]++;
            index++;
        }

        int[][] build() {
            int[][] graph = new int[n][];
            for (int i = 0; i < n; i++) {
                graph[i] = new int[size[i]];
            }
            for (int i = index - 1; i >= 0; i--) {
                int u = x[i];
                int v = y[i];
                graph[u][--size[u]] = v;
                graph[v][--size[v]] = u;
            }
            return graph;
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    int[] readIntArray(int size) throws IOException {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readLongArray(int size) throws IOException {
        long[] res = new long[size];
        for (int i = 0; i < size; i++) {
            res[i] = readLong();
        }
        return res;
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    <T> List<T>[] createGraphList(int size) {
        List<T>[] list = new List[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }
        return list;
    }

    public static void main(String[] args) {
        new Template().run();
        // new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    long memoryTotal, memoryFree;

    void memory() {
        memoryFree = Runtime.getRuntime().freeMemory();
        System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10)
                + " KB");
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            memoryTotal = Runtime.getRuntime().freeMemory();
            init();
            solve();
            out.close();
            if (System.getProperty("ONLINE_JUDGE") == null) {
                time();
                memory();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    Random random = new Random(5);

    class Treap {
        Treap l, r;
        int size;
        int y;
        int max;
        int val;
        int index;

        public Treap(int index, int val) {
            this.index = index;
            this.val = val;
            y = random.nextInt();
            max = val;
            size = 1;
        }
    }

    class Deramida {

        int max(Treap t) {
            return t == null ? Integer.MIN_VALUE : t.max;
        }

        int size(Treap t) {
            return t == null ? 0 : t.size;
        }

        Treap update(Treap t) {
            if (t == null) return null;
            t.size = size(t.l) + size(t.r) + 1;
            t.max = Math.max(Math.max(max(t.l), max(t.r)), t.val);
            return t;
        }

        Treap merge(Treap a, Treap b) {
            if (a == null) return b;
            if (b == null) return a;
            if (a.y > b.y) {
                a.r = merge(a.r, b);
                return update(a);
            } else {
                b.l = merge(a, b.l);
                return update(b);
            }
        }

        Treap[] split(Treap t, int maxCount, int underLimit) {
            if (t == null) return new Treap[2];

            if (Math.max(t.val, max(t.r)) < underLimit && size(t.r) + 1 <= maxCount) {
                Treap[] res = split(t.l, maxCount - size(t.r) - 1, underLimit);
                t.l = res[1];
                res[1] = update(t);
                return res;
            } else {
                Treap[] res = split(t.r, maxCount, underLimit);
                t.r = res[0];
                res[0] = update(t);
                return res;
            }
        }

        Treap root;

        void insert(int index, int a, int c) {
            Treap[] p = split(root, c, a);
            root = merge(merge(p[0], new Treap(index, a)), p[1]);
        }

        void print() {
            print(root);
        }

        void print(Treap t) {
            if (t == null) return;
            print(t.l);
            out.print(t.index + " ");
            print(t.r);
        }

    }

    void solve() throws IOException {
        int x = readInt();
        int y = readInt();
        if (x == y) {
            out.println(x);
        } else {
            out.println(2);
        }
    }

}