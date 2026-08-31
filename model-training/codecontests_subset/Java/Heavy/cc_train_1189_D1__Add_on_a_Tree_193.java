import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aman Kumar Singh
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D1AddOnATree solver = new D1AddOnATree();
        solver.solve(1, in, out);
        out.close();
    }

    static class D1AddOnATree {
        PrintWriter out;
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int n = ni();
            int[] deg = new int[n];
            int i = 0;
            for (i = 0; i < n - 1; i++) {
                deg[ni() - 1]++;
                deg[ni() - 1]++;
            }
            int cnt = 0;
            for (i = 0; i < n; i++) {
                if (deg[i] == 1)
                    cnt++;
            }
            if (n == 2) {
                pn("YES");
                return;
            }
            boolean ok = true;
            for (i = 0; i < n; i++) {
                if (deg[i] == 2)
                    ok = false;
            }
            if (ok && cnt > 2)
                pn("YES");
            else
                pn("NO");
        }

        int ni() {
            return in.nextInt();
        }

        void pn(Object o) {
            out.println(o);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

