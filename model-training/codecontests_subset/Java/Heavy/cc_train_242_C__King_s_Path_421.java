import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
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
        OutputWriter out = new OutputWriter(outputStream);
        CKingsPath solver = new CKingsPath();
        solver.solve(1, in, out);
        out.close();
    }

    static class CKingsPath {
        private HashMap<Util.Pair, Integer> hm = new HashMap<>();
        private int x0;
        private int y0;
        private int x1;
        private int y1;
        private int n;
        private Util.Pair start;
        private Util.Pair end;
        private int[] row = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        private int[] col = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        private void bfs() {
            hm.put(start, 0);
            Queue<Util.Pair> queue = new LinkedList<>();
            queue.offer(start);
            while (!queue.isEmpty()) {
                Util.Pair pair = queue.poll();
                for (int i = 0; i < 8; i++) {
                    Util.Pair to = new Util.Pair(row[i] + pair.x, col[i] + pair.y);
                    if (hm.containsKey(to) && hm.get(to) == -1) {
                        hm.put(to, hm.get(pair) + 1);
                        queue.offer(to);
                    }
                    if (to.equals(end)) return;
                }
            }
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            x0 = in.nextInt();
            y0 = in.nextInt();
            x1 = in.nextInt();
            y1 = in.nextInt();
            n = in.nextInt();
            start = new Util.Pair(x0, y0);
            end = new Util.Pair(x1, y1);
            for (int seg = 1; seg <= n; seg++) {
                int r = in.nextInt(), s = in.nextInt(), e = in.nextInt();
                for (int i = s; i <= e; i++) {
                    Util.Pair cell = new Util.Pair(r, i);
                    if (!hm.containsKey(cell)) hm.put(cell, -1);
                }
            }
            bfs();
            out.println(hm.get(end));
            out.flush();
        }

    }

    static class Util {
        public static class Pair {
            public int x;
            public int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public boolean equals(Object obj) {
                if (obj == this) return true;
                if (!(obj instanceof Util.Pair)) return false;
                Util.Pair pair = (Util.Pair) obj;
                return this.x == pair.x && this.y == pair.y;
            }

            public int hashCode() {
                return Objects.hash(x, y);
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public InputReader(FileInputStream file) {
            this.stream = file;
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
                res = (res << 3) + (res << 1) + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;
        private ArrayList<String> res = new ArrayList<>();
        private StringBuilder sb = new StringBuilder("");

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                sb.append(objects[i]);
            }
            res.add(sb.toString());
            sb = new StringBuilder("");
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            for (String str : res) writer.printf("%s\n", str);
            res.clear();
            sb = new StringBuilder("");
        }

    }
}

