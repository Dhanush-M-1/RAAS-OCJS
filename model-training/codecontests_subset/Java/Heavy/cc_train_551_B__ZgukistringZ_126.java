import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintWriter;
import java.io.OutputStream;

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
            String a = in.readString();
            String b = in.readString();
            String c = in.readString();
            int[] ca = new int[26];
            int nums = 0;
            int nums_b = 0;
            int nums_c = 0;
            for (int i = 0; i < a.length(); i++) {
                ca[a.charAt(i) - 'a']++;
            }
            int[] cb = new int[26];
            for (int i = 0; i < b.length(); i++) {
                cb[b.charAt(i) - 'a']++;
            }
            int[] cc = new int[26];
            for (int i = 0; i < c.length(); i++) {
                cc[c.charAt(i) - 'a']++;
            }
            for (int i = 0; ; i++) {
                boolean flag = true;
                for (int j = 0; j < 26; j++) {
                    if (cb[j] * i > ca[j]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    break;
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < 26; j++) {
                    if (cc[j] == 0)
                        continue;
                    temp = Math.min(temp, (ca[j] - cb[j] * i) / cc[j]);
                }
                if (temp + i > nums) {
                    nums = temp + i;
                    nums_b = i;
                    nums_c = temp;
                }
            }
            for (int i = 0; i < nums_b; i++) {
                out.print(b);
            }
            for (int i = 0; i < nums_c; i++) {
                out.print(c);
            }
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < ca[i] - cb[i] * nums_b - cc[i] * nums_c; j++) {
                    out.print((char) ('a' + i));
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
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void print(char i) {
            writer.print(i);
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
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c))
                    res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
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

