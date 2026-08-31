import javax.swing.event.ListDataEvent;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class J implements Runnable {

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

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());

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

    int[] readIntArray(int size) throws IOException {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = readInt();
        }
        return a;
    }

    public static void main(String[] args) {
        //new Thread(null, new _Solution(), "", 128 * (1L << 20)).start();
        new J().run();
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

    class Point implements Comparable<Point> {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x) return x - o.x;
            return y - o.y;
        }
    }

    void solve() throws IOException {
        int x0 = readInt(), y0 = readInt();
        int x1 = readInt(), y1 = readInt();
        int n = readInt();
        TreeSet<Point> good = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int r = readInt();
            int a = readInt();
            int b = readInt();
            for (int j = a; j <= b; j++) {
                good.add(new Point(r, j));
            }
        }
        ArrayDeque<Point> pq = new ArrayDeque<>();
        TreeMap<Point, Integer> dist = new TreeMap<>();
        dist.put(new Point(x0, y0), 0);
        pq.add(new Point(x0, y0));

        int[] dx = {0, 0, -1, -1, 1, 1, 1, -1};
        int[] dy = {-1, 1, 1, -1, 1, -1, 0, 0};
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            for (int s = 0; s < dx.length; s++) {
                Point now = new Point(cur.x + dx[s], cur.y + dy[s]);
                if (dist.containsKey(now)) continue;
                if (!good.contains(now)) continue;
                pq.add(now);
                dist.put(now, dist.get(cur) + 1);
            }
        }
        out.println(dist.getOrDefault(new Point(x1, y1), -1));


    }

}