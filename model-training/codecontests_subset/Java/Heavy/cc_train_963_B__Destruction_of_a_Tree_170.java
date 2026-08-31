import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        static List<Integer>[] g;
        static List<Integer>[] gg;

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            if (n % 2 == 0) {
                out.println("NO");
                return;
            }
            int[] p = in.nextIntArray(n);
            MiscUtils.decreaseByOne(p);
            g = new List[n];
            gg = new List[n];
            for (int i = 0; i < n; ++i) {
                g[i] = new ArrayList<>();
                gg[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; ++i) {
                if (p[i] >= 0) {
                    g[i].add(p[i]);
                    g[p[i]].add(i);
                }
            }
            dfs(0, -1);
            int[] ord = new int[n];
            int[] deg = new int[n];
            for (int i = 0; i < n; ++i)
                for (Integer next : gg[i])
                    ++deg[next];

            int ptr = 0;

            for (int i = 0; i < n; ++i)
                if (deg[i] == 0) ord[ptr++] = i;

            for (int start = 0; start < ptr; ++start)
                for (Integer next : gg[ord[start]])
                    if (--deg[next] == 0) ord[ptr++] = next;

            out.println("YES");
            for (int oo : ord) out.println(oo + 1);
        }

        private static boolean dfs(int cur, int par) {
            boolean oddChild = false;
            for (Integer next : g[cur]) {
                if (next == par) continue;
                boolean t = dfs(next, cur);
                if (t) {
                    oddChild ^= true;
                }
            }
            if (par != -1) {
                if (oddChild) {
                    gg[cur].add(par);
                } else {
                    gg[par].add(cur);
                }
            }
            return !oddChild;
        }

    }

    static class MiscUtils {
        public static void decreaseByOne(int[]... arrays) {
            for (int[] array : arrays) {
                for (int i = 0; i < array.length; i++) {
                    array[i]--;
                }
            }
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

