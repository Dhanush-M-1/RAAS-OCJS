import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
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
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.readInt();
            int m = in.readInt();
            int k = in.readInt();

            int[] to = new int[m];
            int[] from = new int[m];
            int[] degree = new int[n];
            boolean[] alive = new boolean[m];
            Arrays.fill(alive, true);

            List<Integer>[] edges = new ArrayList[n];
            for (int i = 0; i < n; ++i) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; ++i) {
                to[i] = in.readInt() - 1;
                from[i] = in.readInt() - 1;
                degree[to[i]]++;
                degree[from[i]]++;
                edges[to[i]].add(i);
                edges[from[i]].add(i);
            }

            int[] q = new int[n];
            int back = 0;
            int front = 0;

            for (int i = 0; i < n; i++) {
                if (degree[i] < k) {
                    q[front++] = i;
                }
            }
            int[] res = new int[m];
            for (int i = m - 1; i >= 0; --i) {
                while (back < front) {
                    int cur = q[back++];
                    for (int edge : edges[cur]) {
                        if (alive[edge]) {
                            int other = to[edge] + from[edge] - cur;
                            alive[edge] = false;
                            if (degree[other] == k) {
                                q[front++] = other;
                            }
                            degree[other]--;
                            degree[cur]--;
                        }
                    }
                }
                res[i] = n - front;
                if (alive[i]) {
                    if (degree[from[i]] == k) {
                        q[front++] = from[i];
                    }
                    if (degree[to[i]] == k) {
                        q[front++] = to[i];
                    }
                    degree[from[i]]--;
                    degree[to[i]]--;
                    alive[i] = false;
                }
            }
            for (int i = 0; i < m; i++) {
                out.println(res[i]);
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            // InputMismatchException -> UnknownError
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
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
            } else if (c == '+') {
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

        public static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

