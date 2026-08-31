import java.io.*;
import java.util.*;

public class CF implements Runnable {

    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tok = new StringTokenizer("");

    private void init() throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        String fileName = "";
        if (ONLINE_JUDGE && fileName.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            if (fileName.isEmpty()) {
                in = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            } else {
                in = new BufferedReader(new FileReader(fileName + ".in"));
                out = new PrintWriter(fileName + ".out");
            }
        }
    }

    String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() {
        return Integer.parseInt(readString());
    }

    long readLong() {
        return Long.parseLong(readString());
    }

    double readDouble() {
        return Double.parseDouble(readString());
    }

    int[] readIntArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = readInt();
        }
        return a;
    }

    public static void main(String[] args) {
        //new Thread(null, new _Solution(), "", 128 * (1L << 20)).start();
        new CF().run();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    @Override
    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            init();
            solve();
            out.close();
            time();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private int aiverson(boolean good) {
        return good ? 1 : 0;
    }

    int[][] buildGraph(int n, int[] u, int[] v) {
        int[][] graph = new int[n][];
        int[] q = new int[n];
        for (int i = 0; i < u.length; i++) {
            q[u[i]]++;
            q[v[i]]++;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[q[i]];
        }
        for (int i = 0; i < u.length; i++) {
            graph[u[i]][--q[u[i]]] = v[i];
            graph[v[i]][--q[v[i]]] = u[i];
        }
        return graph;
    }

    private void solve() {
        int n = readInt();
        int k = readInt();
        int p = readInt();
        int[] a = readIntArray(n);
        Arrays.sort(a);
        int[] b = readIntArray(k);
        Arrays.sort(b);

        long answer = Long.MAX_VALUE;
        for (int i = 0; i <= k - n; i++) {
            long curAnswer = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                curAnswer = Math.max(curAnswer, Math.abs(a[j] - b[j + i]) + Math.abs(p - b[j + i]));
            }
            answer = Math.min(answer, curAnswer);
        }

        out.println(answer);
    }
}
