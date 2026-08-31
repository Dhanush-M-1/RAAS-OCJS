import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Alex
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskD {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int days = in.readInt(); // n [1, 200_000]
            int repairtime = in.readInt(); // k [1, 200_000]
            int a = in.readInt(), b = in.readInt(); // b < a [1, 10_000]
            int queries = in.readInt();
            int[] ordersattime = new int[days];
            FenwickTree low = new FenwickTree(days), high = new FenwickTree(days);
            for(int query = 0; query < queries; query++) {
                int type = in.readInt();
                if(type == 1) {
                    int day = in.readInt() - 1, added = in.readInt();
                    int oldval = ordersattime[day];
                    ordersattime[day] += added;
                    ordersattime[day] = Math.min(ordersattime[day], a);
                    int newval = ordersattime[day];
                    int aadded = newval - oldval;
                    high.add(day, aadded);
                    int bcan = Math.min(b, newval);
                    int badded = bcan - oldval;
                    if(badded >= 0) low.add(day, badded);
                } else {
                    int day = in.readInt() - 1;
                    out.printLine(low.get(0, day - 1) + high.get(day + repairtime, days + 1));
                }
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if(numChars == -1)
                throw new InputMismatchException();
            if(curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch(IOException e) {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while(!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if(filter != null)
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

    static class FenwickTree {
        private final long[] value;

        public FenwickTree(int size) {
            value = new long[size];
        }

        public long get(int from, int to) {
            return get(to) - get(from - 1);
        }

        private long get(int to) {
            to = Math.min(to, value.length - 1);
            long result = 0;
            while(to >= 0) {
                result += value[to];
                to = (to & (to + 1)) - 1;
            }
            return result;
        }

        public void add(int at, long value) {
            while(at < this.value.length) {
                this.value[at] += value;
                at = at | (at + 1);
            }
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
}

