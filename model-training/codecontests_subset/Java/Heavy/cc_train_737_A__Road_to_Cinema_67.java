import java.io.*;
import java.util.*;
import java.util.List;

public class Template implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            String filename = "";
            if (filename.isEmpty()) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader(filename + ".in"));
                out = new PrintWriter(filename + ".out");
            }
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

    int time(int len, int volume) {
        if (len > volume) return -1;
        int time = len * 2;
        int ost = volume - len;
        time -= Math.min(ost, len);
        return time;
    }

    void solve() throws IOException {
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
        int[] g = readIntArray(k);
        Arrays.sort(g);

        int l = 0;
        int r = 1000000000 + 10;

        int answer = -1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            int maxV = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (mid >= c[i]) {
                    maxV = Math.max(maxV, v[i]);
                }
            }
            boolean bad = false;
            if (maxV == Integer.MIN_VALUE) {
                l = mid + 1;
                continue;
            }
            int allTime = 0;
            int prev = 0;
            for (int i = 0; i < k; i++) {
                int ttime = time(g[i] - prev, maxV);
                if (ttime == -1) bad = true;
                allTime += time(g[i] - prev, maxV);
                prev = g[i];
            }
            if (time(s - prev, maxV) == -1) bad = true;

            if (bad) {
                l = mid + 1;
                continue;
            }
            allTime += time(s - prev, maxV);
            if (allTime <= t) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        out.println(answer);
    }

}