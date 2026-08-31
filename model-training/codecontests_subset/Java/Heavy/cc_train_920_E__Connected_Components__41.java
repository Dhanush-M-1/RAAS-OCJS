import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;
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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            Set<Edge> edges = new HashSet<>();
            for (int i = 0; i < m; i++) {
                edges.add(new Edge(in.nextInt() - 1, in.nextInt() - 1));
            }

            for (int i = 0; i < n; i++) set.add(i);
            boolean visited[] = new boolean[n];
            ArrayList<Integer> connectedCom = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    connectedCom.add(count(i, set, edges, visited));
                }
            }
            out.println(connectedCom.size());
            Collections.sort(connectedCom);
            for (int i = 0; i < connectedCom.size(); i++) {
                out.print(connectedCom.get(i) + " ");
            }
            out.println();

        }

        private int count(int st, TreeSet<Integer> visited, Set<Edge> edges, boolean vis[]) {
            visited.remove(st);
            vis[st] = true;
            int count = 1;
            if (visited.isEmpty()) return 1;
            int v = visited.first();
            while (true) {

                if (!edges.contains(new Edge(st, v))) {
                    count += count(v, visited, edges, vis);
                }
                Integer vv = visited.higher(v);
                if (vv == null) break;
                v = vv;

            }
            return count;
        }

        class Edge {
            int[] a;

            Edge(int a, int b) {
                this.a = new int[2];
                this.a[0] = a;
                this.a[1] = b;
                Arrays.sort(this.a);
            }


            public int hashCode() {
                return Arrays.hashCode(a);
            }


            public boolean equals(Object obj) {
                Edge e = (Edge) obj;
                return Arrays.equals(e.a, this.a);
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
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println() {
            writer.println();
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

        public int readInt() {
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

        public int nextInt() {
            return readInt();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

