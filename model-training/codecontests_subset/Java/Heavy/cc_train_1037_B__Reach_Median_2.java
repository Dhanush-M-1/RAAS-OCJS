import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Random;
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
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.readInt();
            int s = in.readInt();
            int[] a = IOUtils.readIntArray(in, n);
            ArrayUtils.sort(a);
            int mid = n / 2;

            long res = 0;
            if (a[mid] > s) {
                for (int i = 0; i <= mid; ++i) {
                    if (a[i] > s) {
                        res += a[i] - s;
                    }
                }
            } else if (a[mid] < s) {
                for (int i = mid; i < n; ++i) {
                    if (a[i] < s) {
                        res += s - a[i];
                    }
                }
            }
            out.println(res);
        }

    }

    static class ArrayUtils {
        public static void sort(int[] a) {
            ArrayShuffler.shuffle(a);
            Arrays.sort(a);
        }

    }

    static class ArrayShuffler {
        static Random random = new Random(7428429L);

        public static void shuffle(int[] p) {
            for (int i = 0; i < p.length; ++i) {
                int j = i + random.nextInt(p.length - i);
                int temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            // InputMismatchException -> UnknownError
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
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
            } else if (c == '+') {
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

        public static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class IOUtils {
        public static int[] readIntArray(InputReader in, int size) {
            int[] res = new int[size];
            for (int i = 0; i < size; ++i) {
                res[i] = in.readInt();
            }
            return res;
        }

    }
}

