import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EduD implements Runnable {

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

    <T> ArrayDeque<T>[] createGraphDeque(int size) {
        ArrayDeque<T>[] list = new ArrayDeque[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayDeque<>();
        }
        return list;
    }

    public static void main(String[] args) {
        new EduD().run();
//        new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
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

    int[] log;

    class Sparse {
        int[][] data;

        Sparse(int[] d) {
            int k = 0;
            while ((1 << k) < d.length) {
                k++;
            }
            k++;
            data = new int[k][d.length];
            for (int i = 0; i < d.length; i++) {
                data[0][i] = d[i];
            }
            for (int level = 1; level < k; level++) {
                for (int start = 0; start < d.length; start++) {
                    int next = start + (1 << (level - 1));
                    if (next >= d.length) break;

                    data[level][start] = Math.max(data[level - 1][start], data[level - 1][next]);
                }
            }
        }

        int get(int l, int r) {
            int k = log[r - l];
            int a = data[k][l];
            int b = data[k][r - (1 << k) + 1];
            return Math.max(a, b);
        }
    }

    List<Integer>[] layersList;
    int[][] layers;
    List<Integer>[] g;
    int[] a;
    int[] tin;
    int[] tout;
    int[] height;
    int[] indexOnLayer;
    int timer;

    void dfs(int v, int p, int h) {
        tin[v] = timer++;
        height[v] = h;
        layersList[h].add(v);
        indexOnLayer[v] = layersList[h].size() - 1;
        for (int y : g[v]) {
            if (y == p) continue;
            dfs(y, v, h + 1);
        }
        tout[v] = timer++;
    }

    int findLeftIndex(int v, int k) {
        int targetH = height[v] + k;
        if (targetH >= layers.length) return Integer.MAX_VALUE;
        int l = 0;
        int r = layers[targetH].length - 1;

        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int vert = layers[targetH][mid];
            if (tin[vert] >= tin[v] && tout[vert] <= tout[v]) {
                //parent
                ans = mid;
                r = mid - 1;
            } else if (tout[vert] < tin[v]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    int findRightIndex(int v, int k) {
        int targetH = height[v] + k;
        if (targetH >= layers.length) return Integer.MIN_VALUE;
        int l = 0;
        int r = layers[targetH].length - 1;

        int ans = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int vert = layers[targetH][mid];
            if (tin[vert] >= tin[v] && tout[vert] <= tout[v]) {
                //parent
                ans = mid;
                l = mid + 1;
            } else if (tout[vert] < tin[v]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    void solve() throws IOException {
        int n = readInt();
        int d = readInt();
        long[] values = new long[n];
        int[] a = readIntArray(n);
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur += a[i];
            values[i] = cur;
        }

        long[] maxOnSuf = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            maxOnSuf[i] = values[i];
            if (i + 1 < n) {
                maxOnSuf[i] = Math.max(maxOnSuf[i], maxOnSuf[i + 1]);
            }
        }

        int answer = 0;
        if (maxOnSuf[0] > d) {
            out.println(-1);
            return;
        }

        long added = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                long now = values[i] + added;
                if (now < 0) {

                    long todayMaxOnSuf = maxOnSuf[i] + added;
                    long canAdd = d - todayMaxOnSuf;

                    if (now + canAdd < 0) {
                        out.println(-1);
                        return;
                    }
                    answer++;
                    added += canAdd;
                }
            }
        }
        out.println(answer);
    }


}