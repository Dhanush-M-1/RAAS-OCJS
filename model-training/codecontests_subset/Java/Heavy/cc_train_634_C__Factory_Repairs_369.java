import java.io.*;
import java.util.StringTokenizer;

public class SNSTemplate implements Runnable {

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

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        new Thread(null, new SNSTemplate(), "", 1l * 200 * 1024 * 1024).start();
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

    class SegmentTree {
        int[] value;
        int size;
        int n;
        int limit;

        SegmentTree(int n, int limit) {
            this.n = n;
            this.limit = limit;
            this.size = 4 * n;
            value = new int[size];
        }

        void add(int v, int tl, int tr, int index, int val) {
            if (tl == tr) {
                value[v] = Math.min(value[v] + val, limit);
                return;
            }
            int mid = (tl + tr) >> 1;
            if (index <= mid) {
                add(v * 2, tl, mid, index, val);
            } else {
                add(v * 2 + 1, mid + 1, tr, index, val);
            }
            value[v] = value[v * 2] + value[v * 2 + 1];
        }

        int get(int v, int tl, int tr, int left, int right) {
            if (tl == left && tr == right) {
                return value[v];
            }

            int mid = (tl + tr) >> 1;
            if (right <= mid) return get(v * 2, tl, mid, left, right);
            if (left > mid) return get(v * 2 + 1, mid + 1, tr, left, right);
            return get(v * 2, tl, mid, left, mid) + get(v * 2 + 1, mid + 1, tr, mid + 1, right);
        }

        void add(int index, int val) {
            add(1, 1, n, index, val);
        }

        int get(int left, int right) {
            return get(1, 1, n, left, right);
        }
    }


    void solve() throws IOException {
        int n = readInt();
        int k = readInt();
        int a = readInt();
        int b = readInt();
        int q = readInt();

        SegmentTree sta = new SegmentTree(n, a);
        SegmentTree stb = new SegmentTree(n, b);

        for (int i=0;i<q;i++) {
            int type = readInt();
            if (type == 1) {
                int d = readInt();
                int val = readInt();
                sta.add(d, val);
                stb.add(d, val);
            } else {
                int dayFirst = readInt();
                int dayLast = dayFirst + k - 1;
                int answer = 0;
                if (dayFirst != 1) {
                    answer += stb.get(1, dayFirst - 1);
                }
                if (dayLast != n) {
                    answer += sta.get(dayLast + 1, n);
                }
                out.println(answer);
            }
        }
    }


}