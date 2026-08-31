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
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
//        Random rnd = new Random(322);
//        for (int it = 0; it < 100000; it++) {
//            int a = 1 + rnd.nextInt(500);
//            int b = 1 + rnd.nextInt(500);
//            int c = 1 + rnd.nextInt(500);
//            int d = 1 + rnd.nextInt(500);
//            boolean ansSmart = smart(a, b, c, d);
//            boolean ansStupid = stupid(a, b, c, d);
//            if (ansSmart != ansStupid) {
//                System.err.println(a + " " + b + " " + c + " " + d + ": smart = " + ansSmart + ", stupid = " + ansStupid);
//                throw new AssertionError();
//            }
//        }
//        System.err.println("STRESS OK");

            int T = in.readInt();
            for (int i = 0; i < T; i++) {
                long a = in.readLong();
                long b = in.readLong();
                long c = in.readLong();
                long d = in.readLong();
                boolean ansSmart = smart(a, b, c, d);
//            boolean ansStupid = stupid(a, b, c, d);
                out.printLine(ansSmart ? "Yes" : "No");
            }
        }

        private boolean smart(long a, long b, long c, long d) {
            if (a < b) {
                return false;
            }
            if (d < b) {
                return false;
            }
            if (c >= b) {
                return true;
            }
            a %= b;
            if (c < a) {
                return false;
            }
            if (d == b) {
                return true;
            }
            long g = IntegerUtils.gcd(b, d);
////        if (g <= width) {
////            return false;
////        }
//        return true;
            long k1 = (c - a) / g - 2;
            long k2 = (b - a) / g + 2;
            for (long k = k1; k <= k2; k++) {
                long t = a + k * g;
                if (c < t && t < b) {
                    return false;
                }
            }
            return true;
        }

    }

    static class IntegerUtils {
        public static long gcd(long a, long b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                long temp = a % b;
                a = b;
                b = temp;
            }
            return a;
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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

