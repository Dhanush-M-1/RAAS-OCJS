import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
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
        DSwapsInPermutation solver = new DSwapsInPermutation();
        solver.solve(1, in, out);
        out.close();
    }

    static class DSwapsInPermutation {
        private int n;
        private int m;
        private boolean[] vis;
        private int[] arr;
        private ArrayList<Integer> num;
        private ArrayList<Integer> ind;
        private ArrayList<Integer>[] graph;

        private void dfs(int start) {
            vis[start] = true;
            num.add(arr[start]);
            ind.add(start);
            for (int X : graph[start]) {
                if (!vis[X]) dfs(X);
            }
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = in.nextInt();
            }
            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int a = in.nextInt(), b = in.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }
            vis = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!vis[i]) {
                    num = new ArrayList<>();
                    ind = new ArrayList<>();
                    dfs(i);
                    Collections.sort(num, Comparator.reverseOrder());
                    Collections.sort(ind);
                    for (int j = 0; j < num.size(); j++) {
                        arr[ind.get(j)] = num.get(j);
                    }
                }
            }
            for (int i = 1; i <= n; i++) out.printsc(arr[i]);
            out.println();
            out.flush();
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

        public void printsc(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                sb.append(objects[i]).append(' ');
            }
        }

        public void close() {
//        writer.flush();
            writer.close();
        }

        public void flush() {
            for (String str : res) writer.printf("%s\n", str);
            res.clear();
            sb = new StringBuilder("");
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
}

