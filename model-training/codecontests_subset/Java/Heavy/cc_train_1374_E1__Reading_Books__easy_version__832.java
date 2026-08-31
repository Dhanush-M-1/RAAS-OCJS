import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
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
        TaskE1 solver = new TaskE1();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE1 {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt(), k = in.nextInt();
            long sum = 0;
            ArrayList<Integer>[] a = new ArrayList[4];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < 4; ++i) a[i] = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int time = in.nextInt(), alice = in.nextInt(), bob = in.nextInt();
                a[alice * 2 + bob].add(time);
                if (alice * 2 + bob == 3) pq.add(time);
            }
            Collections.sort(a[1]);
            Collections.sort(a[2]);
            for (int i = 0; i < a[1].size() && i < a[2].size(); ++i) pq.add(a[1].get(i) + a[2].get(i));
            if (k > pq.size()) {
                out.println(-1);
                return;
            }
            for (int i = 0; i < k; ++i) sum += pq.poll();
            out.println(sum);
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

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

