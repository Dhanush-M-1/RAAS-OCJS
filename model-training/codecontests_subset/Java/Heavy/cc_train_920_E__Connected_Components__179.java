import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.AbstractCollection;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author John Martin
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        EConnectedComponents solver = new EConnectedComponents();
        solver.solve(1, in, out);
        out.close();
    }

    static class EConnectedComponents {
        public void solve(int testNumber, InputReader c, OutputWriter w) {

            int n = c.readInt(), m = c.readInt();
            HashSet<Integer> adj[] = new HashSet[n];
            TreeSet<Integer> unvis = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                adj[i] = new HashSet<>();
                unvis.add(i);
            }
            for (int i = 0; i < m; i++) {
                int u = c.readInt() - 1, v = c.readInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
            }

            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!unvis.contains(i)) {
                    continue;
                }
                unvis.remove(i);
                LinkedList<Integer> q = new LinkedList<>();
                q.add(i);
                int cnt = 1;
                while (!q.isEmpty() && !unvis.isEmpty()) {
                    int x = q.poll();
                    ArrayList<Integer> rem = new ArrayList<>();
                    for (int kl : unvis) {
                        if (!adj[x].contains(kl)) {
                            q.add(kl);
                            cnt++;
                            rem.add(kl);
                        }
                    }
                    for (int kl : rem) {
                        unvis.remove(kl);
                    }
                }
                res.add(cnt);
            }

            Collections.sort(res);
            w.printLine(res.size());
            for (int k : res) {
                w.print(k + " ");
            }
            w.printLine();


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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine() {
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }
}

