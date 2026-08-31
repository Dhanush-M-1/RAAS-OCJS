import java.io.*;
import java.util.*;

public class D implements Runnable {

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
        new D().run();
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

    class SegmentTree {
        int[] t;

        public SegmentTree(int size) {
            t = new int[size * 4];
        }

        void update(int v, int tl, int tr, int pos, int value, int maxValue) {
            if (tl == tr)
                t[v] = Math.min(maxValue, t[v] + value);
            else {
                int tm = (tl + tr) / 2;
                if (pos <= tm)
                    update(v << 1, tl, tm, pos, value, maxValue);
                else
                    update((v << 1) + 1, tm + 1, tr, pos, value, maxValue);
                t[v] = t[v << 1] + t[(v << 1) + 1];
            }
        }

        int sum(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return 0;
            if (l == tl && r == tr)
                return t[v];
            int tm = (tl + tr) / 2;
            return sum((v << 1), tl, tm, l, Math.min(r, tm))
                    + sum((v << 1) + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        }
    }

    final int MAX_DAYS = 2 * 100 * 1000 + 5;

    private void solve() {
        int n = readInt();
        int k = readInt();
        int a = readInt();
        int b = readInt();
        int q = readInt();

        SegmentTree beforeRepair = new SegmentTree(MAX_DAYS);
        SegmentTree afterRepair = new SegmentTree(MAX_DAYS);

        while (q --> 0) {
            int type = readInt();
            if (type == 1) {
                int dayNumber = readInt();
                int orders = readInt();
                beforeRepair.update(1, 0, MAX_DAYS - 1, dayNumber, orders, b);
                afterRepair.update(1, 0, MAX_DAYS - 1, dayNumber, orders, a);
            } else {
                int p = readInt();
                int sumBeforeRepair = beforeRepair.sum(1, 0, MAX_DAYS - 1, 0, p - 1);
                int sumAfterRepair = afterRepair.sum(1, 0, MAX_DAYS - 1, p + k, MAX_DAYS - 1);
                out.println(sumBeforeRepair + sumAfterRepair);
            }
        }
    }
}
