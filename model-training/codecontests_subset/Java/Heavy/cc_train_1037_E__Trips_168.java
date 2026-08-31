import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author BSRK Aditya
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ETrips solver = new ETrips();
        solver.solve(1, in, out);
        out.close();
    }

    static class ETrips {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt(), m = in.readInt(), k = in.readInt();
            ArrayList<Integer>[] adj = new ArrayList[n];
            HashMap<P, Boolean> edgeMap = new HashMap<>();
            P[] edges = new P[m];
            for (int i = 0; i < n; ++i)
                adj[i] = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                int x = in.readInt() - 1, y = in.readInt() - 1;
                P e = new P(Integer.min(x, y), Integer.max(x, y));
                edges[i] = e;
                edgeMap.put(e, true);

                adj[x].add(y);
                adj[y].add(x);
            }

            //PriorityQueue<P> vertices = new PriorityQueue<>();
            TreeSet<P> vertices = new TreeSet<>();
            HashMap<Integer, Integer> vc = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                vertices.add(new P(adj[i].size(), i));
                vc.put(i, adj[i].size());
            }

            int count = n;
            while (!vertices.isEmpty() && vertices.first().x < k) {
                count--;
                P p = vertices.pollFirst();
                int v1 = p.y;
                for (int v2 : adj[v1]) {
                    P e = new P(Integer.min(v1, v2), Integer.max(v1, v2));
                    if (edgeMap.get(e)) {
                        edgeMap.put(e, false);

                        int v2c = vc.get(v2);
                        vertices.remove(new P(v2c, v2));
                        vertices.add(new P(v2c - 1, v2));
                        vc.put(v2, v2c - 1);
                    }
                }
            }

            int[] ans = new int[m];
            ans[m - 1] = count;
            for (int i = m - 2; i >= 0; i--) {
                P e = edges[i + 1];
                if (edgeMap.get(e)) {
                    edgeMap.put(e, false);

                    int v1 = e.x, v2 = e.y;
                    int v1c = vc.get(v1), v2c = vc.get(v2);

                    vertices.remove(new P(v1c, v1));
                    vertices.add(new P(v1c - 1, v1));
                    vc.put(v1, v1c - 1);

                    vertices.remove(new P(v2c, v2));
                    vertices.add(new P(v2c - 1, v2));
                    vc.put(v2, v2c - 1);

                    while (!vertices.isEmpty() && vertices.first().x < k) {
                        count--;
                        P p = vertices.pollFirst();
                        int v3 = p.y;
                        for (int v4 : adj[v3]) {
                            P e2 = new P(Integer.min(v3, v4), Integer.max(v3, v4));
                            if (edgeMap.get(e2)) {
                                edgeMap.put(e2, false);

                                int v4c = vc.get(v4);
                                vertices.remove(new P(v4c, v4));
                                vertices.add(new P(v4c - 1, v4));
                                vc.put(v4, v4c - 1);
                            }
                        }
                    }
                }
                ans[i] = count;
            }
            for (int i = 0; i < m; ++i) out.printLine(ans[i]);
        }

        class P implements Comparable<P> {
            final int x;
            final int y;

            P(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int compareTo(P o) {
                int v1 = Integer.compare(x, o.x);
                if (v1 != 0) return v1;
                else return Integer.compare(y, o.y);
            }

            public boolean equals(Object obj) {
                P p = (P) obj;
                return x == p.x && y == p.y;
            }

            public int hashCode() {
                return x + 3 * y;
            }

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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
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
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

