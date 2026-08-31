import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.TreeSet;
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
        ETrips solver = new ETrips();
        solver.solve(1, in, out);
        out.close();
    }

    static class ETrips {
        int[][] G;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int m = in.scanInt();
            int k = in.scanInt();
            TreeSet<pair> bstCustom = new TreeSet<>();
            int from[] = new int[m];
            int to[] = new int[m];
            for (int i = 0; i < m; i++) {
                from[i] = in.scanInt();
                to[i] = in.scanInt();
            }
            int[] ans = new int[m];
            G = CodeHash.packGraph(from, to, n);
            int degree[] = new int[n + 1];
            for (int i = 1; i <= n; i++) bstCustom.add(new pair(degree[i] = G[i].length, i));
            boolean[] is_inside = new boolean[n + 1];
            Arrays.fill(is_inside, true);
            HashSet<Long> set = new HashSet<>();
            while (bstCustom.size() > 0 && bstCustom.first().x < k) {
                pair tt = bstCustom.first();
                for (int i : G[tt.y]) {
                    if (is_inside[i]) {
                        if (set.contains(i * 1000000000l + tt.y) || set.contains(tt.y * 1000000000l + i))
                            continue;
                        bstCustom.remove(new pair(degree[i], i));
                        degree[i]--;
                        degree[tt.y]--;
                        bstCustom.add(new pair(degree[i], i));
                        set.add(i * 1000000000l + tt.y);
                    }
                }
                is_inside[tt.y] = false;
                bstCustom.remove(tt);
            }
            ans[m - 1] = bstCustom.size();
            for (int i = m - 1; i >= 1; i--) {
                if (is_inside[from[i]] && is_inside[to[i]]) {
                    bstCustom.remove(new pair(degree[from[i]], from[i]));
                    degree[from[i]]--;
                    bstCustom.add(new pair(degree[from[i]], from[i]));
                    bstCustom.remove(new pair(degree[to[i]], to[i]));
                    degree[to[i]]--;
                    bstCustom.add(new pair(degree[to[i]], to[i]));
                    set.add(1000000000l * from[i] + to[i]);
                }
                while (bstCustom.size() > 0 && bstCustom.first().x < k) {
                    pair tt = bstCustom.first();
                    for (int j : G[tt.y]) {
                        if (is_inside[j]) {
                            if (set.contains(j * 1000000000l + tt.y) || set.contains(tt.y * 1000000000l + j))
                                continue;
                            bstCustom.remove(new pair(degree[j], j));
                            degree[j]--;
                            bstCustom.add(new pair(degree[j], j));
                            set.add(j * 1000000000l + tt.y);
                        }
                    }
                    is_inside[tt.y] = false;
                    bstCustom.remove(tt);
                }
                ans[i - 1] = bstCustom.size();
            }
            for (int i = 0; i < m; i++) out.println(ans[i]);
        }

        class pair implements Comparable<pair> {
            int x;
            int y;

            public int compareTo(pair o) {
                if (this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }

            public pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

        }

    }

    static class CodeHash {
        public static int[][] packGraph(int[] from, int[] to, int n) {
            int[][] g = new int[n + 1][];
            int p[] = new int[n + 1];
            for (int i : from) p[i]++;
            for (int i : to) p[i]++;
            for (int i = 0; i <= n; i++) g[i] = new int[p[i]];
            for (int i = 0; i < from.length; i++) {
                g[from[i]][--p[from[i]]] = to[i];
                g[to[i]][--p[to[i]]] = from[i];
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

    }
}

