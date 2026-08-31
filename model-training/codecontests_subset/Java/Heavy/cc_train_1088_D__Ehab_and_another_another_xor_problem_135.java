import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
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
 * @author Rustam Musin (t.me/musin_acm)
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        DEhabIEsheOdnaOcherednayaZadachaNaXor solver = new DEhabIEsheOdnaOcherednayaZadachaNaXor();
        solver.solve(1, in, out);
        out.close();
    }

    static class DEhabIEsheOdnaOcherednayaZadachaNaXor {
        InputReader in;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            Interactor interactor = new Interactor(1, 3);
            this.in = in;
            interactor.real = true;
            int a = 0;
            int b = 0;
            int cmp = interactor.ask(0, 0);
            for (int i = 29; i >= 0; i--) {
                int res = interactor.ask(a ^ (1 << i), b ^ (1 << i));
                if (res == 0) {
                    break;
                }
                if (res == cmp) {
                    continue;
                }
                if (cmp > 0) {
                    a ^= 1 << i;
                } else {
                    b ^= 1 << i;
                }
                cmp = interactor.ask(a, b);
            }
            for (int i = 29; i >= 0; i--) {
                if (get(a, i) != get(b, i)) {
                    continue;
                }
                int res = interactor.ask(a ^ (1 << i), b);
                if (res < 0) {
                    a ^= 1 << i;
                    b ^= 1 << i;
                }
            }
            boolean ok = interactor.say(a, b);
//        if (ok) {
//            System.err.println("OK");
//        } else {
//            System.err.println("FUCK");
//        }
        }

        int get(int m, int b) {
            return (m >> b) & 1;
        }

        class Interactor {
            int a;
            int b;
            boolean real;

            Interactor(int a, int b) {
                this.a = a;
                this.b = b;
            }

            int ask(int c, int d) {
                if (real) {
                    System.out.printf("? %d %d\n", c, d);
                    System.out.flush();
                    return in.readInt();
                }
                if ((a ^ c) > (b ^ d)) {
                    return +1;
                }
                if ((a ^ c) < (b ^ d)) {
                    return -1;
                }
                return 0;
            }

            boolean say(int a, int b) {
                if (real) {
                    System.out.printf("! %d %d\n", a, b);
                    return true;
                }
                return this.a == a && this.b == b;
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
}

