import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Ray S. Kan
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        HashSet<Point> set;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            long x0 = in.nextLong();
            long y0 = in.nextLong();
            long x1 = in.nextLong();
            long y1 = in.nextLong();
            int n = in.nextInt();
            set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                long ri = in.nextLong();
                long xi = in.nextLong();
                long yi = in.nextLong();
                for (long j = xi; j <= yi; j++) {
                    set.add(new Point(ri, j));
                }
            }
            //set.forEach(e->out.println(e.x+","+e.y+" "));
            //out.print('\n');
            out.print(DFS(new Point(x0, y0), new Point(x1, y1), set));
        }

        int DFS(Point start, Point end, HashSet<Point> set) {
            int counter = 0;
            int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
            int dy[] = {0, 0, 1, -1, 1, 1, -1, -1};
            HashSet<Point> vis = new HashSet<>();
            Queue<Point> q = new LinkedList<Point>();
            vis.add(start);
            int levelsize = 1;
            ((LinkedList<Point>) q).push(start);
            while (!q.isEmpty()) {
                int sz = levelsize;
                levelsize = 0;
                for (int i = 0; i < sz; i++) {
                    Point curr = q.poll();
                    if (curr.x == end.x && curr.y == end.y) {
                        return counter;
                    }
                    //System.out.println(curr.x+","+curr.y+" has: ");
                    for (int j = 0; j < 8; j++) {
                        Point pt = new Point(curr.x + dx[j], curr.y + dy[j]);
                        //System.out.println(set.contains(pt));
                        if (set.contains(pt) && (!vis.contains(pt))) {
                            // System.out.println("ran");
                            vis.add(pt);
                            ((LinkedList<Point>) q).add(pt);
                            //System.out.print(pt.x+","+pt.y+" ");
                            levelsize++;
                        }
                    }

                    //System.out.println();
                }
                counter++;
            }
            return -1;
        }

        class Point {
            long x;
            long y;

            public Point(long x, long y) {
                this.x = x;
                this.y = y;
            }


            public boolean equals(Object o) {
                if (this.x == ((Point) o).x && this.y == ((Point) o).y) {
                    return true;
                }
                return false;
            }


            public int hashCode() {
                int result = String.valueOf(x).hashCode();
                result = 31 * result + (int) y;
                return result;
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

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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

        public void print(int i) {
            writer.print(i);
        }

    }
}

