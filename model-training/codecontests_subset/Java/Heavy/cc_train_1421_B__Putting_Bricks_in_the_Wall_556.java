import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pranay2516
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BPuttingBricksInTheWall solver = new BPuttingBricksInTheWall();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class BPuttingBricksInTheWall {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            char c[][] = new char[n][n];
            ArrayList<Pair> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) c[i] = in.next().toCharArray();
            if (c[1][0] == '0' && c[0][1] == '0') {
                if (c[n - 2][n - 1] == '0') ans.add(new Pair(n - 2, n - 1));
                if (c[n - 1][n - 2] == '0') ans.add(new Pair(n - 1, n - 2));
            } else if (c[1][0] == '1' && c[0][1] == '1') {
                if (c[n - 2][n - 1] == '1') ans.add(new Pair(n - 2, n - 1));
                if (c[n - 1][n - 2] == '1') ans.add(new Pair(n - 1, n - 2));
            } else if (c[1][0] == '0' && c[0][1] == '1') {
                if (c[n - 2][n - 1] == '1' && c[n - 1][n - 2] == '1') ans.add(new Pair(0, 1));
                else if (c[n - 2][n - 1] == '0' && c[n - 1][n - 2] == '1') {
                    ans.add(new Pair(0, 1));
                    ans.add(new Pair(n - 2, n - 1));
                } else if (c[n - 2][n - 1] == '1' && c[n - 1][n - 2] == '0') {
                    ans.add(new Pair(0, 1));
                    ans.add(new Pair(n - 1, n - 2));
                } else ans.add(new Pair(1, 0));
            } else {
                if (c[n - 2][n - 1] == '1' && c[n - 1][n - 2] == '1') ans.add(new Pair(1, 0));
                else if (c[n - 2][n - 1] == '0' && c[n - 1][n - 2] == '1') {
                    ans.add(new Pair(1, 0));
                    ans.add(new Pair(n - 2, n - 1));
                } else if (c[n - 2][n - 1] == '1' && c[n - 1][n - 2] == '0') {
                    ans.add(new Pair(1, 0));
                    ans.add(new Pair(n - 1, n - 2));
                } else ans.add(new Pair(0, 1));
            }
            out.println(ans.size());
            for (Pair p : ans) out.println((p.x + 1) + " " + (p.y + 1));
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

