import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.io.Writer;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Arthur Gazizov [2oo7] - Kazan FU
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        FastPrinter out = new FastPrinter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, FastScanner in, FastPrinter out) {
            out.print(Collections.max(new ExpressionBuilder(in.nextDoubleArray(3)).build()));
        }

    }

    static class ExpressionBuilder {
        private double[] values;

        public ExpressionBuilder(double[] values) {
            this.values = values;
        }

        public List<Expression> build() {
            List<Expression> expressions = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int type = 0; type < 2; type++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j) continue;
                        expressions.add(new Expression(values[i], values[j], values[3 - i - j], type, count++,
                                new StringBuilder(type == 0 ? "" : "(").append((char) ('x' + i)).
                                        append('^').append((char) ('x' + j)).
                                        append(type == 0 ? "" : ")").
                                        append('^').
                                        append((char) ('x' + 3 - i - j)).toString()));
                    }
                }
            }
            return expressions;
        }

    }

    static class Expression implements Comparable<Expression> {
        private double x;
        private double y;
        private double z;
        private int type;
        private int index;
        private String value;

        public Expression(double x, double y, double z, int type, int index, String value) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.type = type;
            this.index = index;
            this.value = value;
        }

        private double get() {
            return type == 0 ? Math.log(Math.abs(Math.log(x))) + z * Math.log(y) : Math.log(Math.abs(Math.log(x))) + Math.log(y * z);
        }


        public int compareTo(Expression other) {
            int compare = ((x - 1) * (other.x - 1) <= 0) ? Double.compare(x, other.x) : (MathUtils.sign(x - 1)) * Double.compare(get(), other.get());
            return compare == 0 ? -Integer.compare(index, other.index) : compare;
        }


        public String toString() {
            return value;
        }

    }

    static class FastScanner extends BufferedReader {
        boolean isEOF;

        public FastScanner(InputStream is) {
            super(new InputStreamReader(is));
        }

        public FastScanner(InputStreamReader inputStreamReader) {
            super(inputStreamReader);
        }

        public int read() {
            try {
                int ret = super.read();
                if (isEOF && ret < 0) {
                    throw new InputMismatchException();
                }
                isEOF = ret == -1;
                return ret;
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public static boolean isWhiteSpace(int c) {
            return c >= -1 && c <= 32;
        }

        public static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int nextInt() {
            int c = read();
            while (isWhiteSpace(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int ret = 0;
            while (!isWhiteSpace(c)) {
                if (c < '0' || c > '9') {
                    throw new NumberFormatException("digit expected " + (char) c
                            + " found");
                }
                ret = ret * 10 + c - '0';
                c = read();
            }
            return ret * sgn;
        }

        public double nextDouble() {
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
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new NumberFormatException("digit expected " + (char) c
                            + " found");
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new UnknownError();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readLine() {
            try {
                return super.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public double[] nextDoubleArray(int n) {
            double[] ret = new double[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextDouble();
            }
            return ret;
        }

    }

    static class MathUtils<T> {
        public static final double EPS = 1e-9;

        public static final int sign(double value) {
            if (value > EPS) return 1;
            if (value < -EPS) return -1;
            return 0;
        }

    }

    static class FastPrinter extends PrintWriter {
        public FastPrinter(Writer writer) {
            super(writer);
        }

        public FastPrinter(OutputStream out) {
            super(out);
        }

        public void close() {
            super.close();
        }

    }
}
