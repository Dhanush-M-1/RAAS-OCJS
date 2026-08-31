import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.AbstractCollection;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author New User
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ECamelTrain solver = new ECamelTrain();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ECamelTrain {
        ArrayList<Integer>[] adj1;
        ArrayList<Integer>[] adj2;

        public void solve(int testNumber, InputReader c, OutputWriter w) {
            int n = c.readInt();
            adj1 = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adj1[i] = new ArrayList<>();
            }
            adj2 = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                adj2[i] = new ArrayList<>();
            }

            long ans = 0;
            int start1 = 0, start2 = 0;
            for (int i = 0; i < n; i++) {
                int k = c.readInt(), l = c.readInt(), r = c.readInt();
                if (l > r) {
                    adj1[k].add(l - r);
                    start1 = Math.max(start1, k);
                    ans += r;
                } else if (r > l) {
                    adj2[n - k].add(r - l);
                    start2 = Math.max(start2, n - k);
                    ans += l;
                } else {
                    ans += l;
                }
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = start1; i >= 1; i--) {
                for (int kk : adj1[i]) {
                    pq.add(kk);
                }
                if (pq.isEmpty()) {
                    continue;
                }
                ans += pq.poll();
            }
            pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = start2; i >= 1; i--) {
                for (int kk : adj2[i]) {
                    pq.add(kk);
                }
                if (pq.isEmpty()) {
                    continue;
                }
                ans += pq.poll();
            }

            w.printLine(ans);
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

        public void close() {
            writer.close();
        }

        public void printLine(long i) {
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

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

