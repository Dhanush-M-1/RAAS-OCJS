import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.TreeSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        KingPath solver = new KingPath();
        solver.solve(1, in, out);
        out.close();
    }

    static class KingPath {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int x0 = in.nextInt();
            int y0 = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int n = in.nextInt();
            TreeSet<KingPath.Pair> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                int r = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();

                for (int c = a; c <= b; c++) {
                    set.add(new KingPath.Pair(r, c));
                }
            }

            TreeMap<KingPath.Pair, Integer> dist = new TreeMap<>();
            dist.put(new KingPath.Pair(x0, y0), 0);
            int xx[] = {-1, 1, -1, 1, 0, 0, 1, -1};
            int yy[] = {-1, 1, 1, -1, 1, -1, 0, 0};
            Queue<KingPath.Pair> queue = new LinkedList<>();
            queue.add(new KingPath.Pair(x0, y0));
            set.remove(new Pair(x0,y0));
            int ans = -1;
            while (!queue.isEmpty()) {
                KingPath.Pair p = queue.poll();
                int val = dist.get(p);

                if (p.equals(new KingPath.Pair(x1, y1))) {
                    ans = val;
                    break;
                }

                for (int k = 0; k < 8; k++) {
                    int xxx = xx[k] + p.x;
                    int yyy = yy[k] + p.y;
                    KingPath.Pair p1 = new KingPath.Pair(xxx, yyy);
                    if (set.contains(p1)) {
                        queue.add(p1);
                        dist.put(p1, val + 1);
                        set.remove(p1);
                    }

                }
            }

            out.println(ans);

        }

        static class Pair implements Comparable<KingPath.Pair> {
            int x;
            int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public boolean equals(KingPath.Pair o) {
                return x == o.x && y == o.y;
            }


            public int compareTo(KingPath.Pair pair) {
                if (x != pair.x) {
                    return x - pair.x;
                } else {
                    return y - pair.y;
                }
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}