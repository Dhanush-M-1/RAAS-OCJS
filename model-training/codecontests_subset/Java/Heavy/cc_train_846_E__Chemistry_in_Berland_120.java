import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */

public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EChemistryInBerland solver = new EChemistryInBerland();
        solver.solve(1, in, out);
        out.close();
    }

    static class EChemistryInBerland {
        long[] br;
        long[] ar;
        int[][][] G;
        boolean flag;

        public long dfs(int node, int parent) {
            for (int[] i : G[node]) {
                if (i[0] == parent) continue;
                long temp = dfs(i[0], node);
                if (temp >= (double) Long.MAX_VALUE / 2 / i[1]) flag = false;
                br[node] -= (temp * i[1]);
                if (br[node] <= Long.MIN_VALUE / 2) flag = false;
            }
            if (ar[node] <= br[node]) {
                if (parent != -1) br[parent] += (br[node] - ar[node]);
                return 0;
            } else {
                return ar[node] - br[node];
            }
        }

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            ar = new long[n + 1];
            br = new long[n + 1];
            for (int i = 1; i <= n; i++) br[i] = in.scanLong();
            for (int i = 1; i <= n; i++) ar[i] = in.scanLong();
            int[] from = new int[n - 1];
            int[] to = new int[n - 1];
            int[] weight = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                from[i] = i + 2;
                to[i] = in.scanInt();
                weight[i] = in.scanInt();
            }
            G = CodeHash.packGraphW(from, to, weight, n);
            flag = true;
            if (dfs(1, -1) == 0 && flag) out.println("YES");
            else out.println("NO");
        }

    }

    static class CodeHash {
        public static int[][][] packGraphW(int[] from, int[] to, int[] w, int n) {
            return packGraphW(from, to, w, n, from.length);
        }

        public static int[][][] packGraphW(int[] from, int[] to, int[] w, int n, int m) {
            int[][][] g = new int[n + 1][][];
            int[] p = new int[n + 1];
            for (int i = 0; i < m; i++) p[from[i]]++;
            for (int i = 0; i < m; i++) p[to[i]]++;
            for (int i = 0; i <= n; i++) g[i] = new int[p[i]][2];
            for (int i = 0; i < m; i++) {
                --p[from[i]];
                g[from[i]][p[from[i]]][0] = to[i];
                g[from[i]][p[from[i]]][1] = w[i];
                --p[to[i]];
                g[to[i]][p[to[i]]][0] = from[i];
                g[to[i]][p[to[i]]][1] = w[i];
            }
            return g;
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

        public long scanLong() {
            long integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

    }
}

