import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Artem Gilmudinov
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskAcmpFast solver = new TaskAcmpFast();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskAcmpFast {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            double x, y, z;
            String[] ans = {"x^y^z", "x^z^y", "(x^y)^z", "(x^z)^y", "y^x^z", "y^z^x", "(y^x)^z", "(y^z)^x", "z^x^y", "z^y^x",
                    "(z^x)^y", "(z^y)^x"};
            x = in.readDouble();
            y = in.readDouble();
            z = in.readDouble();
            double[] vals = new double[12];
            Arrays.fill(vals, -1e9);
            if (x > 1 || y > 1 || z > 1) {
                if (x > 1) {
                    vals[0] = z * Math.log(y) + Math.log(Math.log(x));
                    vals[1] = y * Math.log(z) + Math.log(Math.log(x));
                    vals[2] = Math.log(y * z) + Math.log(Math.log(x));
                    vals[3] = Math.log(y * z) + Math.log(Math.log(x));
                }
                if (y > 1) {
                    vals[4] = z * Math.log(x) + Math.log(Math.log(y));
                    vals[5] = x * Math.log(z) + Math.log(Math.log(y));
                    vals[6] = Math.log(x * z) + Math.log(Math.log(y));
                    vals[7] = Math.log(x * z) + Math.log(Math.log(y));
                }
                if (z > 1) {
                    vals[8] = y * Math.log(x) + Math.log(Math.log(z));
                    vals[9] = x * Math.log(y) + Math.log(Math.log(z));
                    vals[10] = Math.log(y * x) + Math.log(Math.log(z));
                    vals[11] = Math.log(y * x) + Math.log(Math.log(z));
                }
            } else {
                vals[0] = Math.pow(x, Math.pow(y, z));
                vals[1] = Math.pow(x, Math.pow(z, y));
                vals[2] = Math.pow(x, y * z);
                vals[3] = Math.pow(x, z * y);
                vals[4] = Math.pow(y, Math.pow(x, z));
                vals[5] = Math.pow(y, Math.pow(z, x));
                vals[6] = Math.pow(y, x * z);
                vals[7] = Math.pow(y, z * x);
                vals[8] = Math.pow(z, Math.pow(x, y));
                vals[9] = Math.pow(z, Math.pow(y, x));
                vals[10] = Math.pow(z, x * y);
                vals[11] = Math.pow(z, y * x);
            }
            double max = -1e9;
            int ind = 0;
            for (int i = 0; i < 12; i++) {
                if (max < vals[i]) {
                    ind = i;
                    max = vals[i];
                }
            }
            out.println(ans[ind]);
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

        public int readInt() {
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

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

