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
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Akshay Mishra
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        CPairProgramming solver = new CPairProgramming();
        solver.solve(1, in, out);
        out.close();
    }

    static class CPairProgramming {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int test = in.nextInt();
            for (int tt = 0; tt < test; tt++) {
                int k = in.nextInt(), n = in.nextInt(), m = in.nextInt();
                int temp = k;
                int arr1[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr1[i] = in.nextInt();
                }
                int arr2[] = new int[m];
                for (int i = 0; i < m; i++) {
                    arr2[i] = in.nextInt();
                }
                int i = 0, j = 0;
                boolean is = false;
                ArrayList<Integer> res = new ArrayList<>();
                while (i < n && j < m) {
                    int x = Math.min(arr1[i], arr2[j]);
                    if (x == 0) {
                        k++;
                    }
                    if (k < x) {
                        is = true;
                        break;
                    }
                    res.add(x);
                    if (arr1[i] == x) {
                        i++;
                    } else {
                        j++;
                    }
                }
                while (i < n) {
                    if (arr1[i] == 0) {
                        k++;
                    }
                    if (k < arr1[i]) {
                        is = true;
                        break;
                    }
                    res.add(arr1[i]);
                    i++;
                }
                while (j < m) {
                    if (arr2[j] == 0) {
                        k++;
                    }
                    if (k < arr2[j]) {
                        is = true;
                        break;
                    }
                    res.add(arr2[j]);
                    j++;
                }
                if (is) {
                    out.println(-1);
                } else {
                    for (int idx = 0; idx < res.size(); idx++) {
                        out.print(res.get(idx) + " ");
                    }
                    out.println();
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

