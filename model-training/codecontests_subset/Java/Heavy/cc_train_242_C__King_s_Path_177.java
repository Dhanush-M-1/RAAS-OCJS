import java.io.*;
import java.util.*;

/**
 * Created by assalielmehdi on 8/13/17.
 */
public class CF242_D2_C {
    private InputReader in;
    private PrintWriter out;
    private StringBuilder sb;
    private boolean onlineJudge = System.getProperty("ONLINE_JUDGE") != null;

    private CF242_D2_C() throws Exception {
        long s = System.currentTimeMillis();
        init();
        solve();
        if (!onlineJudge)
            sb.append(sb.charAt(sb.length() - 1) == '\n' ? "" : '\n').append("[OK in : ").append(System.currentTimeMillis() - s).append(" ms]");
        out.print(sb);
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new CF242_D2_C();
    }

    private void init() throws Exception {
        in = new InputReader(onlineJudge ? System.in : new FileInputStream(new File("in.txt")));
        out = new PrintWriter(System.out);
        sb = new StringBuilder();
    }

    private void solve() throws Exception {
        Point s = new Point(in.nextInt(), in.nextInt()), d = new Point(in.nextInt(), in.nextInt());
        Map<Integer, Set<Segment>> allowed = new HashMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int r = in.nextInt(), a = in.nextInt(), b = in.nextInt();
            Set<Segment> segments = allowed.get(r);
            if (segments == null) {
                segments = new TreeSet<>();
                allowed.put(r, segments);
            }
            segments.add(new Segment(a, b));
        }
        int ans = s.bfs(d, allowed);
        sb.append(ans);
    }

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isInMap() {
            return x >= 1 && x <= 1_000_000_000 && y >= 1 && y <= 1_000_000_000;
        }

        boolean isAllowed(Map<Integer, Set<Segment>> allowed) {
            Set<Segment> segments = allowed.get(x);
            if (segments == null) return false;
            return segments.contains(new Segment(y, y));
        }

        boolean isValid(Map<Integer, Set<Segment>> allowed) {
            return isAllowed(allowed) && isInMap();
        }

        int bfs(Point d, Map<Integer, Set<Segment>> allowed) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(this, 0));
            Map<Point, Boolean> visited = new HashMap<>();
            int ans = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                Pair pair = q.poll();
                Point p = pair.p;
                int steps = pair.steps;
                if (p.equals(d)) {
                    ans = Math.min(ans, steps);
                } else if (visited.get(p) == null) {
                    visited.put(p, true);
                    for (Point adj : p.adj()) {
                        if (visited.get(adj) == null && adj.isValid(allowed)) {
                            q.add(new Pair(adj, steps + 1));
                        }
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        List<Point> adj() {
            List<Point> ans = new LinkedList<>();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    ans.add(new Point(x + i, y + j));
                }
            }
            return ans;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != getClass()) return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }

        @Override
        public int hashCode() {
            int M = (int) 1e9 + 7;
            int ans = 1;
            ans = ((ans % M) + ((37 * ans) % M) + (x % M)) % M;
            ans = ((ans % M) + ((37 * ans) % M) + (y % M)) % M;
            return ans % M;
        }
    }

    class Pair {
        Point p;
        int steps;

        Pair(Point p, int steps) {
            this.p = p;
            this.steps = steps;
        }

        @Override
        public int hashCode() {
            int M = (int) 1e9 + 7;
            int ans = 1;
            ans = ((ans % M) + ((37 * ans) % M) + (p.hashCode() % M)) % M;
            ans = ((ans % M) + ((37 * ans) % M) + (steps % M)) % M;
            return ans % M;
        }
    }

    class Segment implements Comparable<Segment> {
        int a, b;

        Segment(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o.getClass() != getClass()) return false;
            Segment s = (Segment) o;
            return a <= s.a && s.b <= b;
        }

        @Override
        public int compareTo(Segment s) {
            if (s.equals(this)) return 0;
            if (s.a != a) return a - s.a;
            else return b - s.b;
        }
    }

    class InputReader {
        private int lenbuf = 0, ptrbuf = 0;
        private InputStream in;
        private byte[] inbuf = new byte[1024];

        InputReader(InputStream in) {
            this.in = in;
        }

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = in.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }


        long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long[][] nextLongMatrix(int n, int m) {
            long[][] map = new long[n][];
            for (int i = 0; i < n; i++) map[i] = nextLongArray(m);
            return map;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        double[] nextDoubleArray(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) a[i] = nextDouble();
            return a;
        }

        double[][] nextDoubleMatrix(int n, int m) {
            double[][] map = new double[n][];
            for (int i = 0; i < n; i++) map[i] = nextDoubleArray(m);
            return map;
        }

        String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        String[] nextArray(int n) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = next();
            return arr;
        }

        String[][] nextMatrix(int n, int m) {
            String[][] map = new String[n][];
            for (int i = 0; i < n; i++) map[i] = nextArray(m);
            return map;
        }

        String nextLine() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b) && b != ' ')) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        char nextChar() {
            return (char) skip();
        }

        char[] nextCharArray(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        char[][] nextCharMatrix(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) map[i] = nextCharArray(m);
            return map;
        }

        int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int[][] nextIntMatrix(int n, int m) {
            int[][] map = new int[n][];
            for (int i = 0; i < n; i++) map[i] = nextIntArray(m);
            return map;
        }
    }
}
