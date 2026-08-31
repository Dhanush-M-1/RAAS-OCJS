import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.Set;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author El-Bishoy
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        D2C242_KingsPaths__TYPE__SSP_GRID solver = new D2C242_KingsPaths__TYPE__SSP_GRID();
        solver.solve(1, in, out);
        out.close();
    }

    static class D2C242_KingsPaths__TYPE__SSP_GRID {
        int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        public void solve(int testNumber, InputReader in, OutputWriter out) {

            int si = in.nextInt(), sj = in.nextInt(), di = in.nextInt(), dj = in.nextInt();


            //(r|c)
            Set<String> allowed = new HashSet<>();
            int n = in.nextInt();

            //construct allowed O(N) as in problem statement
            for (int i = 0; i < n; i++) {
                int row = in.nextInt(), from = in.nextInt(), to = in.nextInt();
                for (int j = from; j <= to; j++) {
                    allowed.add(row + "|" + j);
                }
            }

            int pathsLen = sp(si, sj, di, dj, allowed);

            out.println(pathsLen == 0 ? -1 : pathsLen);

        }

        int sp(int si, int sj, int di, int dj, Set<String> allowed) {

            Queue<Integer> row = new LinkedList<>();
            Queue<Integer> col = new LinkedList<>();

            Set<String> visited = new HashSet<>();
            // path len from st to every node
            Map<String, Integer> len = new HashMap<>();


            row.add(si);
            col.add(sj);
            markVisited(si, sj, visited);
            len.put(si + "|" + sj, 0);

            while (!row.isEmpty()) {

                int r = row.poll();
                int c = col.poll();

                //if destination reached
                if (r == di && c == dj) break;

                for (int i = 0; i < dx.length; i++) {
                    int nr = dy[i] + r;
                    int nc = dx[i] + c;

                    if (!valid(nr, nc)) continue;
                    if (isVisited(nr, nc, visited)) continue;
                    if (!allowed(nr, nc, allowed)) continue;

                    markVisited(nr, nc, visited);
                    row.add(nr);
                    col.add(nc);

                    len.put(nr + "|" + nc, len.get(r + "|" + c) + 1);
                }


            }


            return len.getOrDefault(di + "|" + dj, -1);
        }

        private boolean allowed(int r, int c, Set<String> allowed) {
            return allowed.contains(r + "|" + c);
        }

        private void markVisited(int r, int c, Set<String> visited) {
            visited.add(r + "|" + c);
        }

        private boolean isVisited(int r, int c, Set<String> visited) {
            return visited.contains(r + "|" + c);
        }

        boolean valid(int r, int c) {
            return r <= 1e9 && c <= 1e9 && r >= 1 && c >= 1;
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

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }
}

