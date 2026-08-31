import java.io.*;
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

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine(), " :");
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
        new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
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

    long[] readLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readLong();
        }
        return arr;
    }

    long INF = (long) 1_000_000_000 * 1_000_000_000;

    long add(long x, long y) {
        return Math.min(x + y, INF);
    }

    long mul(long x, long y) {
        if (x == 0 || y == 0) return 0;
        if (x > INF / y) return INF;
        return Math.min(x * y, INF);
    }

    long[] a;
    long[] b;

    class Edge {
        int x, k;

        public Edge(int x, int k) {
            this.x = x;
            this.k = k;
        }
    }

    ArrayList<Edge>[] graph;

    long solve(int x, int k) {
        long balance = -b[x];
        for (Edge e : graph[x]) {
            balance = add(balance, solve(e.x, e.k));
        }
        balance += a[x];
        if (balance < 0) return balance;
        return mul(balance, k);
    }

    void solve() throws IOException {
        int n = readInt();
        b = readLongArray(n);
        a = readLongArray(n);
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int x = readInt() - 1;
            graph[x].add(new Edge(i, readInt()));
        }
//        System.err.println(solve(0, 1));
        if (solve(0, 1) <= 0) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }


}