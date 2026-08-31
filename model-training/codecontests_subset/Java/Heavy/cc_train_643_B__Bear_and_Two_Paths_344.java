import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Arthur Gazizov  [2oo7] - Kazan FU
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
            int n = in.nextInt();
            int k = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            if (n <= 4 || k < (n + 1)) {
                out.print(-1);
                return;
            }
            out.prints(a);
            out.prints(c);
            for (int i = 1; i <= n; i++) {
                if (i != a && i != b && i != c && i != d) {
                    out.prints(i);
                }
            }
            out.prints(d);
            out.println(b);
            out.prints(c);
            out.prints(a);
            for (int i = 1; i <= n; i++) {
                if (i != a && i != b && i != c && i != d) {
                    out.prints(i);
                }
            }
            out.prints(b);
            out.println(d);
        }

    }

    static class FastPrinter extends PrintWriter {
        public FastPrinter(Writer writer) {
            super(writer);
        }

        public FastPrinter(OutputStream out) {
            super(out);
        }

        public FastPrinter prints(int value) {
            print(value);
            print(' ');
            return this;
        }

        public void close() {
            super.close();
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

        public String readLine() {
            try {
                return super.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}

