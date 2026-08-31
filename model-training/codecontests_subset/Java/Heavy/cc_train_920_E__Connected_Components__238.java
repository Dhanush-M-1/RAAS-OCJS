import java.util.*;
import java.io.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

public class ConnectedComponents {
    private static InputReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        new ConnectedComponents().run();
    }

    private static class InputReader {
        private final InputStream is;
        private final byte[] inbuf = new byte[1024];
        private int lenbuf = 0;
        private int ptrbuf = 0;

        public InputReader(InputStream stream) {
            is = stream;
        }

        private int readByte() {
            if (lenbuf == -1)
                throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public double nextDouble() {
            return Double.parseDouble(nextString());
        }

        public char nextChar() {
            return (char) skip();
        }

        public String nextString() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] nextString(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }

    private static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private static void debug(Object... o) {
        if (!oj) {
            System.out.println(Arrays.deepToString(o));
        }
    }

    /*==================================================================================================================*/

    int n, m;
    TreeSet<Integer>[] bad;
    ArrayList<ArrayList<Integer>> comps;
    TreeSet<Integer> nVis;

    void dfs(int u, ArrayList<Integer> comp) {
        comp.add(u);
        nVis.remove(u);
        for (Integer v = nVis.isEmpty() ? null : nVis.first(); v != null; v = nVis.higher(v)) {
            if (!bad[u].contains(v)) {
                dfs(v, comp);
            }
        }
    }

    void solve() {
        n = in.nextInt();
        m = in.nextInt();
        bad = new TreeSet[n + 1];
        Arrays.setAll(bad, i -> new TreeSet<>());
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            bad[u].add(v);
            bad[v].add(u);
        }

        nVis = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            nVis.add(i);
        }

        comps = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (nVis.contains(i)) {
                comps.add(new ArrayList<>());
                dfs(i, comps.get(comps.size() - 1));
            }
        }

        int[] sizes = new int[comps.size()];
        Arrays.setAll(sizes, i -> comps.get(i).size());
        Arrays.sort(sizes);

        out.println(comps.size());
        for (int x : sizes) {
            out.print(x + " ");
        }
        out.println();
    }

    public void run() {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        int tt = 1;
        // int tt = in.nextInt();
        for (int i = 1; i <= tt; i++) {
            solve();
        }
        out.flush();
    }
}