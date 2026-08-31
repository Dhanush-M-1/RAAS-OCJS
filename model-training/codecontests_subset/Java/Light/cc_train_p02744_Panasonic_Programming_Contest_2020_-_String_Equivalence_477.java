import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Mufaddal Naya
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        DStringEquivalence solver = new DStringEquivalence();
        solver.solve(1, in, out);
        out.close();
    }

    static class DStringEquivalence {
        ArrayList<String> aa;
        HashSet<String> hs;
        int n;

        public void solve(int testNumber, InputReader c, OutputWriter w) {
            n = c.readInt();
            aa = new ArrayList<>();
            hs = new HashSet<>();
            solve_(0, "");
            for (String str : aa) {
                w.printLine(str);
            }
        }

        private void solve_(int x, String s) {
            int check[] = new int[s.length()];
            int cr = 1;
            if (x == n) {
                for (int i = 0; i < s.length(); i++) {
                    if (check[i] == 0) {
                        for (int j = 0; j < s.length(); j++) {
                            if (s.charAt(j) == s.charAt(i)) {
                                check[j] = cr;
                            }
                        }
                        cr++;
                    }
                }
                String ss = "";
                for (int i = 0; i < check.length; i++) {
                    ss += check[i];
                    ss += ",";
                }
                if (!hs.contains(ss)) {
                    aa.add(s);
                    hs.add(ss);
                }
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (check[i] == 0) {
                        for (int j = 0; j < s.length(); j++) {
                            if (s.charAt(j) == s.charAt(i)) {
                                check[j] = cr;
                            }
                        }
                        cr++;
                    }
                }
                String ss = "";
                for (int i = 0; i < check.length; i++) {
                    ss += check[i];
                    ss += ",";
                }
                if (hs.contains(ss)) {
                    return;
                } else {
                    hs.add(ss);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        solve_(x + 1, s + "" + ch);
                    }
                }
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

