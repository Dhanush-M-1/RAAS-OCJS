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
 * @author prakharjain
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        DEhabAndAnotherAnotherXorProblem solver = new DEhabAndAnotherAnotherXorProblem();
        solver.solve(1, in, out);
        out.close();
    }

    static class DEhabAndAnotherAnotherXorProblem {
        public void solve(int testNumber, InputReader in, OutputWriter out) {

            out.println("? 0 0");
            out.flush();

            int ans = in.nextInt();

            int ca = 0;
            int cb = 0;


            for (int i = 29; i >= 0; i--) {
                if (ans == 0) {
                    //1 1 or0 0

                    int na = ca | (1 << i);
                    int nb = cb | (1 << i);
                    int nna = na;
                    int nnb = cb;

                    out.println("? " + nna + " " + nnb);
                    out.flush();

                    int cans2 = in.nextInt();

                    if (cans2 == -1) {
                        ca = na;
                        cb = nb;

                        out.println("? " + ca + " " + cb);
                        out.flush();

                        int cans3 = in.nextInt();

                        ans = cans3;
                        continue;
                    } else if (cans2 == 1) {
                        continue;
                    }
                } else if (ans == 1) {
                    int na = ca | (1 << i);
                    int nb = cb | (1 << i);

                    out.println("? " + na + " " + nb);
                    out.flush();

                    int cans = in.nextInt();

                    if (cans != ans) {
                        ca = na;

                        out.println("? " + ca + " " + cb);
                        out.flush();

                        int cans2 = in.nextInt();

                        ans = cans2;
                        continue;
                    } else {
                        //1 1 or0 0

                        int nna = na;
                        int nnb = cb;

                        out.println("? " + nna + " " + nnb);
                        out.flush();

                        int cans2 = in.nextInt();

                        if (cans2 == -1) {
                            ca = na;
                            cb = nb;
                            ans = cans;
                            continue;
                        } else if (cans2 == 1) {
                            continue;
                        }
                    }
                } else if (ans == -1) {
                    int na = ca | (1 << i);
                    int nb = cb | (1 << i);

                    out.println("? " + na + " " + nb);
                    out.flush();

                    int cans = in.nextInt();

                    if (cans != ans) {
                        cb = nb;

                        out.println("? " + ca + " " + cb);
                        out.flush();

                        int cans2 = in.nextInt();

                        ans = cans2;
                        continue;
                    } else {
                        //1 1 or0 0

                        int nna = ca;
                        int nnb = nb;

                        out.println("? " + nna + " " + nnb);
                        out.flush();

                        int cans2 = in.nextInt();

                        if (cans2 == -1) {
                            continue;
                        } else if (cans2 == 1) {
                            ca = na;
                            cb = nb;
                            ans = cans;
                            continue;
                        }
                    }
                }
            }

            out.println("! " + ca + " " + cb);
            out.flush();

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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public int nextInt() {
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

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }
}

