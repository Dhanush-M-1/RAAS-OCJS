import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
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
        boolean[] visited;
        HashSet<Integer>[] sets;
        int len;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.readInt();
            int m = in.readInt();

            sets = new HashSet[n + 1];

            visited = new boolean[n + 1];
            for (int i = 0; i < sets.length; i++) sets[i] = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int v = in.readInt();
                int u = in.readInt();
                sets[v].add(u);
                sets[u].add(v);
            }

            int[] nodes = new int[n];
            len = n;
            for (int i = 1; i <= n; i++) nodes[i - 1] = i;
            int ans = 0;
            ArrayList<Integer> com = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    com.add(dfs(i, nodes));
                    ans++;
                }
            }
            Collections.sort(com);
            out.println(ans);
            for (int i : com) out.print(i + " ");

        }

        int dfs(int pos, int[] nodes) {
            visited[pos] = true;
            ArrayList<Integer> target = new ArrayList<>();
            int ans = 1;

            for (int i = 0; i < len; i++) {
                if (sets[pos].contains(nodes[i])) continue;
                target.add(nodes[i]);
                nodes[i] = nodes[len - 1];
                i--;
                len--;
            }
            for (int i : target) {
                if (!visited[i]) ans += dfs(i, nodes);
            }
            return ans;
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
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

