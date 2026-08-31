import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.AbstractCollection;
import java.awt.Point;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.LinkedList;
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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int[] f = in.nextIntArray(2);
            int[] t = in.nextIntArray(2);
            int n = in.nextInt();
            HashSet<Point> set = new HashSet<>();
            HashSet<Point> vis = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int r = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                for (int j = a; j <= b; j++)
                    set.add(new Point(r, j));
            }
            LinkedList<int[]> q = new LinkedList<>();
            q.add(new int[]{f[0], f[1], 0});
            int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
            while (!q.isEmpty()) {
                int[] cur = q.pop();
                if (cur[0] == t[0] && cur[1] == t[1]) {
                    out.println(cur[2]);
                    return;
                }
                vis.add(new Point(cur[0], cur[1]));
                for (int i = 0; i < 8; i++) {
                    if (vis.contains(new Point(cur[0] + dx[i], cur[1] + dy[i])))
                        continue;
                    if (set.contains(new Point(cur[0] + dx[i], cur[1] + dy[i]))) {
                        q.add(new int[]{cur[0] + dx[i], cur[1] + dy[i], cur[2] + 1});
                        vis.add(new Point(cur[0] + dx[i], cur[1] + dy[i]));
                    }
                }
            }
            out.println(-1);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[16384];
        private int curChar;
        private int numChars;

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

        public int nextInt() {
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

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

