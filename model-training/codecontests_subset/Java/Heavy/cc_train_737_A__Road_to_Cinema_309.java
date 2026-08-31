import java.io.*;
import java.util.*;

public class A implements Runnable {

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
        //new Thread(null, new A(), "", 128 * (1L << 20)).start();
        new A().run();
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

    Random random = new Random();

    int[] readG(int size, int s) {
        int[] arr = new int[size + 2];

        for (int i = 1; i <= size; i++) {
            arr[i] = readInt();
        }
        arr[size + 1] = s;

        size += 2;
        int it = size;
        while (it-- > 0) {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
        }
        Arrays.sort(arr);
        return arr;
    }

    private void solve() throws IOException {
        int n = readInt();
        int k = readInt();
        int s = readInt();
        int t = readInt();

        int[] c = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = readInt();
            v[i] = readInt();
        }

        int[] g = readG(k, s);
        k += 2;

        int minV = -1;
        int left = 0, right = 1000000000;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long spendedTime = 0;
            boolean good = true;
            for (int i = 0; i < k - 1; i++) {
                int dist = g[i + 1] - g[i];
                int curV = Math.min(mid, 2 * dist);
                if (dist > mid) {
                    left = mid + 1;
                    good = false;
                    break;
                }
                spendedTime += 3 * dist - curV;
            }
            if (!good) continue;
            if (spendedTime <= t) {
                right = mid - 1;
                minV = mid;
            } else {
                left = mid + 1;
            }
        }

        if (minV == -1) {
            out.println(-1);
            return;
        }

        int ansId = -1;
        for (int i = 0; i < n; i++) {
            if (v[i] >= minV) {
                if (ansId == -1 || c[ansId] > c[i]) {
                    ansId = i;
                }
            }
        }

        if (ansId == -1) {
            out.println(-1);
            return;
        }
        out.println(c[ansId]);
    }
}