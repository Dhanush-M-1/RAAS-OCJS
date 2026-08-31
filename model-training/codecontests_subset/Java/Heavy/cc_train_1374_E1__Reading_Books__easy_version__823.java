import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author out_of_the_box
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        E1ReadingBooksEasyVersion solver = new E1ReadingBooksEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class E1ReadingBooksEasyVersion {
        MiscUtility ut = new MiscUtility(false);

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] t = new int[n];
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = in.nextInt();
                a[i] = in.nextInt();
                b[i] = in.nextInt();
            }
            int ans = 0;
            List<Integer> alike = new ArrayList<>();
            List<Integer> blike = new ArrayList<>();
            List<Integer> like = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (a[i] == 1 && b[i] == 1) {
                    like.add(i);
                } else if (a[i] == 1) {
                    alike.add(i);
                } else if (b[i] == 1) {
                    blike.add(i);
                }
            }
            alike.sort(Comparator.comparing(i -> t[i]));
            blike.sort(Comparator.comparing(i -> t[i]));
            like.sort(Comparator.comparing(i -> t[i]));
            int ai = 0;
            int bi = 0;
            int ind = 0;
            int an = alike.size();
            int bn = blike.size();
            int cn = like.size();
            ut.printDebug(an, "an", bn, "bn", cn, "cn");
            int arem = k;
            int brem = k;
            while (ai < an && bi < bn && ind < cn && arem > 0 && brem > 0) {
                int at = t[alike.get(ai)];
                int bt = t[blike.get(bi)];
                int ct = t[like.get(ind)];
                if (at + bt < ct) {
                    ans += at + bt;
                    ai++;
                    bi++;
                } else {
                    ans += ct;
                    ind++;
                }
                arem--;
                brem--;
            }
            if (arem == 0) {
                while (brem > 0 && ind < cn && bi < bn) {
                    int bt = t[blike.get(bi)];
                    int ct = t[like.get(ind)];
                    if (bt < ct) {
                        ans += bt;
                        bi++;
                        brem--;
                    } else {
                        ans += ct;
                        ind++;
                        brem--;
                    }
                }
                while (brem > 0 && ind < cn) {
                    ans += t[like.get(ind)];
                    ind++;
                    brem--;
                }
                while (brem > 0 && bi < bn) {
                    ans += t[blike.get(bi)];
                    bi++;
                    brem--;
                }
                if (brem != 0) {
                    out.println(-1);
                    return;
                } else {
                    out.println(ans);
                    return;
                }
            } else if (brem == 0) {
                while (arem > 0 && ind < cn && ai < an) {
                    int at = t[alike.get(ai)];
                    int ct = t[like.get(ind)];
                    if (at < ct) {
                        ans += at;
                        ai++;
                        arem--;
                    } else {
                        ans += ct;
                        ind++;
                        arem--;
                    }
                }
                while (arem > 0 && ind < cn) {
                    int ct = t[like.get(ind)];
                    ans += ct;
                    arem--;
                    ind++;
                }

                while (arem > 0 && ai < an) {
                    int at = t[alike.get(ai)];
                    ans += at;
                    arem--;
                    ai++;
                }

                if (arem != 0) {
                    out.println(-1);
                    return;
                } else {
                    out.println(ans);
                    return;
                }
            } else {
                if (ai == an) {
                    while (arem > 0 && ind < cn) {
                        int ct = t[like.get(ind)];
                        ans += ct;
                        arem--;
                        brem--;
                        ind++;
                    }
                    if (arem != 0) {
                        out.println(-1);
                        return;
                    }

                    while (brem > 0 && ind < cn && bi < bn) {
                        int bt = t[blike.get(bi)];
                        int ct = t[like.get(ind)];
                        if (bt < ct) {
                            ans += bt;
                            bi++;
                            brem--;
                        } else {
                            ans += ct;
                            ind++;
                            brem--;
                        }
                    }
                    while (brem > 0 && ind < cn) {
                        ans += t[like.get(ind)];
                        ind++;
                        brem--;
                    }
                    while (brem > 0 && bi < bn) {
                        ans += t[blike.get(bi)];
                        bi++;
                        brem--;
                    }
                    if (brem != 0) {
                        out.println(-1);
                        return;
                    } else {
                        out.println(ans);
                        return;
                    }
                } else if (bi == bn) {
                    while (brem > 0 && ind < cn) {
                        int ct = t[like.get(ind)];
                        ans += ct;
                        brem--;
                        arem--;
                        ind++;
                    }
                    if (brem != 0) {
                        out.println(-1);
                        return;
                    }

                    while (arem > 0 && ind < cn && ai < an) {
                        int at = t[alike.get(ai)];
                        int ct = t[like.get(ind)];
                        if (at < ct) {
                            ans += at;
                            ai++;
                            arem--;
                        } else {
                            ans += ct;
                            ind++;
                            arem--;
                        }
                    }
                    while (arem > 0 && ind < cn) {
                        int ct = t[like.get(ind)];
                        ans += ct;
                        arem--;
                        ind++;
                    }

                    while (arem > 0 && ai < an) {
                        int at = t[alike.get(ai)];
                        ans += at;
                        arem--;
                        ai++;
                    }

                    if (arem != 0) {
                        out.println(-1);
                        return;
                    } else {
                        out.println(ans);
                        return;
                    }
                } else {
                    MiscUtility.assertion(ind == cn, String.format("ind [%d] is not cn [%d]", ind, cn));
                    while (arem > 0 && ai < an) {
                        int at = t[alike.get(ai)];
                        ans += at;
                        arem--;
                        ai++;
                    }
                    if (arem != 0) {
                        out.println(-1);
                        return;
                    }
                    while (brem > 0 && bi < bn) {
                        int bt = t[blike.get(bi)];
                        ans += bt;
                        brem--;
                        bi++;
                    }
                    if (brem != 0) {
                        out.println(-1);
                        return;
                    }
                    out.println(ans);
                }
            }
        }

    }

    static class MiscUtility {
        private boolean debug;

        public MiscUtility() {
            debug = System.getProperty("ONLINE_JUDGE") == null;
        }

        public MiscUtility(boolean debug) {
            this.debug = debug;
        }

        public static void assertion(boolean condition, String message) {
            if (!condition) {
                throw new RuntimeException("Assertion failed. " + message);
            }
        }

        public void printDebug(Object... objects) {
            if (debug) {
                boolean isName = false;
                Object prev = null;
                for (Object object : objects) {
                    if (isName) {
                        System.out.print(String.format("[%s: %s] ", object, prev.toString()));
                    } else {
                        prev = object;
                    }
                    isName = !isName;
                }
                System.out.println();
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

        public void println(int i) {
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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

