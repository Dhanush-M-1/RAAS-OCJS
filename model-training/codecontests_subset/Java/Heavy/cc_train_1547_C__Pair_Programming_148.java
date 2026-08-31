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
        CPairProgramming solver = new CPairProgramming();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class CPairProgramming {
        int k;
        int n;
        int m;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            k = in.nextInt();
            n = in.nextInt();
            m = in.nextInt();
            int i = 0, j = 0;
            int[] a = in.nextIntArray(n);
            int[] b = in.nextIntArray(m);
            int[] res = new int[n + m];
            int idx = 0;
            while (i < n && j < m) {
                if (a[i] == 0) {
                    k++;
                    res[idx++] = a[i];
                    i++;
                } else if (b[j] == 0) {
                    k++;
                    res[idx++] = b[j];
                    j++;
                } else if (a[i] > k && b[j] > k) {
                    out.println(-1);
                    return;
                } else if (a[i] <= k) {
                    res[idx++] = a[i];
                    i++;
                } else if (b[j] <= k) {
                    res[idx++] = b[j];
                    j++;
                }
            }
            while (i < n) {
                if (a[i] == 0) {
                    res[idx++] = a[i];
                    k++;
                    i++;
                } else if (a[i] <= k) {
                    res[idx++] = a[i];
                    i++;

                } else if (a[i] > k) {
                    out.println(-1);
                    return;
                }
            }
            while (j < m) {
                if (b[j] == 0) {
                    res[idx++] = b[j];
                    k++;
                    j++;
                } else if (b[j] <= k) {
                    res[idx++] = b[j];
                    j++;

                } else if (b[j] > k) {
                    out.println(-1);
                    return;
                }
            }
            for (int l : res) {
                out.print(l + " ");
            }
            out.println();
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

        public String nextString() {
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
            return nextString();
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) array[i] = nextInt();
            return array;
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

        public void println() {
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }
}

