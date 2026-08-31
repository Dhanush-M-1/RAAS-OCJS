import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
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
        DCreditCard solver = new DCreditCard();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCreditCard {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), d = in.nextInt();
            int[] arr = new int[n + 1];
            int[] prefSum = new int[n + 1];
            int[] max = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = in.nextInt();
                prefSum[i] = prefSum[i - 1] + arr[i];
                if (prefSum[i] > d) {
                    out.println(-1);
                    out.flush();
                    return;
                }
            }
            int currMax = prefSum[n];
            for (int i = n; i >= 1; i--) {
                max[i] = currMax;
                currMax = Math.max(currMax, prefSum[i - 1]);
            }
            long balance = 0L;
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 0) {
                    if (balance < 0) {
                        long max1 = balance - prefSum[i] + max[i];
                        if (d >= max1) {
                            ans++;
                            balance += d - max1;
                        } else {
                            out.println(-1);
                            out.flush();
                            return;
                        }
                        if (balance < 0) {
                            out.println(-1);
                            out.flush();
                            return;
                        }
                    }
                } else {
                    balance += arr[i];
                }
            }
            out.println(ans);
            out.flush();
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;
        private ArrayList<String> res = new ArrayList<>();
        private StringBuilder sb = new StringBuilder("");

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void println(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                sb.append(objects[i]);
            }
            res.add(sb.toString());
            sb = new StringBuilder("");
        }

        public void close() {
//        writer.flush();
            writer.close();
        }

        public void flush() {
            for (String str : res) writer.printf("%s\n", str);
            res.clear();
            sb = new StringBuilder("");
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public InputReader(FileInputStream file) {
            this.stream = file;
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
                res = (res << 3) + (res << 1) + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

