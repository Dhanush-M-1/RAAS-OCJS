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
import java.util.BitSet;
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
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n;
            int m;

            n = in.readInt();
            m = in.readInt();
            int[][] tab = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tab[i][j] = in.readCharacter() - 'a';
                }
            }

            int r;
            int c;
            r = in.readInt();
            c = in.readInt();
            int[][] pat = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int ch = in.readCharacter();
                    if (ch == '?') {
                        ch = -1;
                    } else {
                        ch -= 'a';
                    }
                    pat[i][j] = ch;
                }
            }

            BitSet[][] eq = new BitSet[26][n];
            for (int ch = 0; ch < 26; ch++) {
                for (int i = 0; i < n; i++) {
                    BitSet bitSet = eq[ch][i] = new BitSet(2 * m);
                    for (int j = 0, jmod = 0; j < 800; j++) {
                        if (ch == tab[i][jmod]) {
                            bitSet.set(j);
                        }
                        //
                        ++jmod;
                        if (jmod == m) {
                            jmod = 0;
                        }
                    }
                }
            }

            BitSet[] dp = new BitSet[n];
            for (int i = 0; i < n; i++) {
                dp[i] = new BitSet(800);
                dp[i].set(0, m);
            }

            for (int x = 0; x < r; x++) {
                for (int y = 0; y < c; y++) {
                    int ch = pat[x][y];
                    if (ch == -1) {
                        continue;
                    }
                    BitSet[] bitSets = eq[ch];
                    for (int i = 0, i_plus_x = x % n; i < n; i++) {
                        BitSet s = bitSets[i_plus_x];
                        BitSet a = s.get(y, 800);
                        dp[i].and(a);
                        //
                        ++i_plus_x;
                        if (i_plus_x == n) {
                            i_plus_x = 0;
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder(405 * 405);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(dp[i].get(j) ? "1" : "0");
                }
                sb.append("\n");
            }
            out.print(sb);
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
                if ((c < '0') || (c > '9')) {
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
            return (c == ' ') || (c == '\n') || (c == '\r') || (c == '\t') || (c == -1);
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

