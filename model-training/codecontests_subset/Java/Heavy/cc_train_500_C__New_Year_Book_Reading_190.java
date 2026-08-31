import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.awt.Point;
import java.math.BigInteger;

import static java.lang.Math.*;

public class CodeforcesC implements Runnable {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
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

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        new Thread(null, new CodeforcesC(), "", 128 * (1L << 20)).start();
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

    void debug(Object... objects) {
        if (DEBUG) {
            for (Object o : objects) {
                System.err.println(o.toString());
            }
        }
    }

    int[] readIntArray(int n) throws IOException {
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = readInt();
        return array;
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            memoryTotal = Runtime.getRuntime().freeMemory();
            init();
            solve();
            out.close();
            time();
            memory();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    boolean DEBUG = false;

    void solve() throws IOException {

        int n = readInt();
        int m = readInt();

        int[] w = new int[n];

        for (int i = 0; i < n; i++)
            w[i] = readInt();

        int answer = 0;
        int[] books = new int[m];

        for (int i = 0; i < m; i++)
            books[i] = readInt() - 1;

        for (int i = 0; i < m; i++) {
            int sum = 0;
            TreeSet<Integer> set = new TreeSet<Integer>();
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(books[j])) continue;
                if (books[j] == books[i]) break;
                sum += w[books[j]];
                set.add(books[j]);
            }
            answer += sum;
        }

        out.println(answer);
    }
}