import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
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
        GOldFloppyDrive solver = new GOldFloppyDrive();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class GOldFloppyDrive {
        int findPosition(List<GOldFloppyDrive.Entry> times, long val) {
            int n = times.size();
            int low = -1, hih = n - 1;
            while (hih - low > 1) {
                int mid = (hih + low) >> 1;
                if (times.get(mid).e >= val) {
                    hih = mid;
                } else {
                    low = mid;
                }
            }
            return times.get(hih).idx;

        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt(), m = in.readInt();
            int[] seq = in.readIntArray(n);

            int[] q = in.readIntArray(m);

            List<GOldFloppyDrive.Entry> times = new ArrayList<>();

            long sum = 0;

            long prev = 0;

            for (int i = 0; i < n; ++i) {
                sum += seq[i];
                if (sum > prev) {
                    times.add(new GOldFloppyDrive.Entry(sum, i));
                    prev = sum;
                }
            }

            int nn = times.size();

            List<Long> ans = new ArrayList<>();
            for (long e : q) {
                if (times.isEmpty()) ans.add(-1L);
                else {

                    if (times.get(nn - 1).e >= e) {
                        ans.add(findPosition(times, e) + 0L);
                    } else if (sum <= 0) {
                        ans.add(-1L);
                    } else {

                        long prefixSumAmount = e - times.get(nn - 1).e;
                        long cycles = (prefixSumAmount + sum - 1) / sum;
                        long total = cycles * n + findPosition(times, e - sum * cycles);
                        ans.add(total);
                    }
                }
            }
            out.printLine(ans.toArray());

        }

        static class Entry {
            long e;
            int idx;

            public Entry(long x, int idx) {
                this.e = x;
                this.idx = idx;
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
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

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
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

