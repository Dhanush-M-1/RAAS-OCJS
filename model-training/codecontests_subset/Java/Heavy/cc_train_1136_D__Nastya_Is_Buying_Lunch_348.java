import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
        DNastyaIsBuyingLunch solver = new DNastyaIsBuyingLunch();
        solver.solve(1, in, out);
        out.close();
    }

    static class DNastyaIsBuyingLunch {
        int[][] G;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int[] pi = new int[n];
            for (int i = 0; i < n; i++) pi[i] = in.scanInt();
            int[] from = new int[m];
            int[] to = new int[m];
            for (int i = 0; i < m; i++) {
                from[i] = in.scanInt();
                to[i] = in.scanInt();
            }
            G = CodeHash.packGraphdirected(from, to, n);
            HashSet<Integer> set = new HashSet<>();
            set.add(pi[n - 1]);
            int ans = 0;
            for (int i = n - 2; i >= 0; i--) {
                int temp = 0;
                for (int j : G[pi[i]]) {
                    if (set.contains(j)) temp++;
                }
                if (temp == set.size()) {
                    ans++;
                } else {
                    set.add(pi[i]);
                }
            }
            out.println(ans);
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

    }

    static class CodeHash {
        public static int[][] packGraphdirected(int[] from, int[] to, int n) {
            return packGraphdirected(from, to, n, from.length);
        }

        public static int[][] packGraphdirected(int[] from, int[] to, int n, int m) {
            int[][] g = new int[n + 1][];
            int p[] = new int[n + 1];
            for (int i = 0; i < m; i++) p[from[i]]++;
            for (int i = 0; i <= n; i++) g[i] = new int[p[i]];
            for (int i = 0; i < from.length; i++) g[from[i]][--p[from[i]]] = to[i];
            return g;
        }

    }
}

