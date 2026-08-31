import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
public class Q7_OldFloppyDrive {
    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        int test = Integer.parseInt(in.next());
        for (int p1 = 0; p1 < test; p1++) {
            int n = Integer.parseInt(in.next());
            int m = Integer.parseInt(in.next());
            long a[] = new long[n];
            long b[] = new long[m];
            for (int i = 0; i < n; i++) {
                a[i] = in.readLong();
            }
            for (int i = 0; i < m; i++) {
                b[i] = in.readLong();
            }
            ArrayList<Long> pref = new ArrayList<>();
            TreeMap<Long, Integer> map = new TreeMap<>();
            long sum = 0, max = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + a[i];
                int size = pref.size();
                if (size == 0 || sum > pref.get(size - 1)) {
                    pref.add(sum);
                    map.put(sum, i + 1);
                    max = sum;
                }
            }
            //System.out.println(map);
            //System.out.println(pref);
            //System.out.println(max);
            //System.out.println(sum);
            for (int i = 0; i < m; i++) {
                long val = b[i];
                if (max < val && sum <= 0) {
                    out.print("-1 ");
                    continue;
                }
                long times = 0;
                if (max < val) {
                    times = (val - max + sum - 1) / sum;
                }
                val = val - times * sum;
                long key = map.ceilingKey(val);
                long ans = times * n + map.get(key) - 1;
                out.print(ans + " ");
            }
            out.printLine();
        }
        out.close();
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

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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
}