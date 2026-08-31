import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prakharjain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        _1065F solver = new _1065F();
        solver.solve(1, in, out);
        out.close();
    }

    static class _1065F {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            Thread th = new Thread(null, new Solve(testNumber, in, out), "Main", 1l << 26);
            th.start();
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        class Solve implements Runnable {
            List[] g;
            int n;
            int k;
            int testNumber;
            InputReader in;
            OutputWriter out;
            int[] dpmax;
            int[] dpreach;
            int[] mindep;
            int[] depth;

            public Solve(int testNumber, InputReader in, OutputWriter out) {
                this.testNumber = testNumber;
                this.in = in;
                this.out = out;
            }

            public void run() {
                solve(testNumber, in, out);
            }

            public void solve(int testNumber, InputReader in, OutputWriter out) {
                n = in.nextInt();
                k = in.nextInt();

                g = new List[n];
                in.readTree(g, n, 1);


                //HeightAndSubtreeSize hss = new HeightAndSubtreeSize();

                depth = new int[n];

                dpmax = new int[n];
                dpreach = new int[n];
                mindep = new int[n];

                //hss.depth = depth;
                //hss.g = g;
                //hss.dfs(0, -1, 0);

                ArrayDeque<Integer> stack = new ArrayDeque<>();
                ArrayDeque<Integer> stack2 = new ArrayDeque<>();

                stack.addFirst(0);
                boolean[] vis = new boolean[n];
                vis[0] = true;
                depth[0] = 0;

                while (stack.size() > 0) {
                    int pop = stack.removeFirst();

                    stack2.addLast(pop);

                    for (int v : (List<Integer>) g[pop]) {
                        if (!vis[v]) {
                            stack.addFirst(v);
                            depth[v] = depth[pop] + 1;
                            vis[v] = true;
                        }
                    }
                }

                dfs(stack2);

                out.println(dpmax[0]);
            }

            void dfs(ArrayDeque<Integer> stack) {
                boolean[] vis = new boolean[n];
                while (stack.size() > 0) {
                    int u = stack.removeLast();
                    vis[u] = true;
                    if (u != 0 && g[u].size() == 1) {
                        dpmax[u] = 1;
                        dpreach[u] = 1;
                        mindep[u] = depth[u] - k;
                        continue;
                    }

                    int curDep = depth[u];

                    mindep[u] = curDep;

                    for (int v : (List<Integer>) g[u]) {
                        if (vis[v]) {
                            if (mindep[v] <= curDep) {
                                dpreach[u] += dpreach[v];

                                mindep[u] = Math.min(mindep[v], mindep[u]);
                            }
                        }
                    }

                    dpmax[u] = dpreach[u];

                    for (int v : (List<Integer>) g[u]) {
                        if (vis[u]) {
                            int total = dpreach[u];
                            if (mindep[v] <= curDep) {
                                total -= dpreach[v];
                            }
                            total += dpmax[v];

                            dpmax[u] = Math.max(dpmax[u], total);
                        }
                    }

                    if (mindep[u] >= curDep) {
                        dpreach[u] = 0;
                    }
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

        public void readTree(List[] g, int numOfVertices, int offset) {
            int numOfEdges = numOfVertices - 1;

            for (int i = 0; i < numOfVertices; i++) {
                g[i] = new ArrayList();
            }

            for (int i = 0; i < numOfEdges; i++) {
                int p = nextInt() - offset;

                g[p].add(i + 1);
                g[i + 1].add(p);
            }
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

