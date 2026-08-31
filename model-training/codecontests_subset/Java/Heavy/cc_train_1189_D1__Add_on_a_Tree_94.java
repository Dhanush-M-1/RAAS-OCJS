import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D1AddOnATree solver = new D1AddOnATree();
        solver.solve(1, in, out);
        out.close();
    }

    static class D1AddOnATree {
        public void solve(int testNumber, FastReader s, PrintWriter out) {
            int n = s.nextInt();
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                int src = s.nextInt() - 1;
                int dest = s.nextInt() - 1;
                HashSet<Integer> set = map.getOrDefault(src, new HashSet<>());
                set.add(dest);
                map.put(src, set);
                set = map.getOrDefault(dest, new HashSet<>());
                set.add(src);
                map.put(dest, set);
            }

            Iterator<Integer> iter = map.keySet().iterator();
            boolean ok = true;
            while (iter.hasNext()) {
                int curr = iter.next();
                if (map.get(curr).size() == 2) {
                    ok = false;
                    break;
                }
            }

            out.println(ok ? "YES" : "NO");
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
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

