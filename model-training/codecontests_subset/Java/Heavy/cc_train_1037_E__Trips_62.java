import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        Set[] graph;
        int[] deg;
        Set<Integer> s;
        int k;
        int n;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            int m = in.nextInt();
            k = in.nextInt();

            graph = new Set[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new HashSet();
            }

            deg = new int[n];

            List<edge> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                edges.add(new edge(u, v));
                graph[u].add(v);
                graph[v].add(u);
                deg[u]++;
                deg[v]++;
            }


            s = new HashSet<>();

            List<vertex> vertices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                s.add(i);
                vertices.add(new vertex(i, deg[i]));
            }

            vertices.sort((v1, v2) -> v1.d - v2.d);

            int i = 0;
            for (i = 0; i < n; i++) {
                if (vertices.get(i).d < k) {
                    int u = vertices.get(i).u;
                    if (s.contains(u))
                        dfs(u, -1, -1);
                } else {
                    break;
                }
            }

            //out.println(s.size());
            List<Integer> ans = new ArrayList<>();
            ans.add(s.size());
            for (int j = m - 1; j > 0; j--) {
                edge ce = edges.get(j);
                graph[ce.u].remove(ce.v);
                graph[ce.v].remove(ce.u);
                if (s.contains(ce.u) && s.contains(ce.v)) {
                    dfs(ce.u, ce.v, ce.u);
                    if (s.contains(ce.v))
                        dfs(ce.v, ce.u, ce.v);
                }
                ans.add(s.size());
            }

            for (int j = ans.size() - 1; j >= 0; j--) {
                out.println(ans.get(j));
            }
        }

        void dfs(int u, int ov, int ou) {
            deg[u]--;

            if (deg[u] >= k) {
                return;
            }

            s.remove(u);

            for (int v : (Set<Integer>) graph[u]) {
                if (s.contains(v)) {
                    dfs(v, ov, ou);
                }
            }


        }

        class edge {
            int u;
            int v;

            public edge(int u, int v) {
                this.u = u;
                this.v = v;
            }

        }

        class vertex {
            int u;
            int d;

            public vertex(int u, int d) {
                this.u = u;
                this.d = d;
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

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}
