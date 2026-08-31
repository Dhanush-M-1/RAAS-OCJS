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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String[] parts = ("+ " + in.readLine()).split(" ");
            int res = Integer.parseInt(parts[parts.length - 1]);
            int[] signs = new int[parts.length / 2 - 1];
            for (int i = 0; i < parts.length - 2; i += 2) {
                signs[i / 2] = parts[i].equals("+") ? 1 : -1;
            }

            int left = res;
            int[] ans = new int[signs.length];
            for (int i = 0; i < signs.length; i++) {
                ans[i] = 1;
                if (signs[i] < 0) {
                    left++;
                } else {
                    left--;
                }
            }
            for (int i = 0; i < signs.length; i++) {
                if (signs[i] < 0) {
                    continue;
                }
                while (ans[i] < res && left > 0) {
                    ans[i]++;
                    left--;
                }
            }
            if (left < 0) {
                for (int i = 0; i < signs.length; i++) {
                    if (signs[i] > 0) {
                        continue;
                    }
                    while (ans[i] < res && left < 0) {
                        ans[i]++;
                        left++;
                    }
                }
            }
            if (left != 0) {
                out.print("Impossible");
            } else {
                out.printLine("Possible");
                for (int i = 0; i < ans.length; i++) {
                    if (i != 0) {
                        out.printFormat("%s ", signs[i] > 0 ? "+" : "-");
                    }
                    out.print(ans[i] + " ");
                }
                out.print("= " + res);
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

        public void printFormat(String format, Object... objects) {
            writer.printf(format, objects);
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

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

    }
}

