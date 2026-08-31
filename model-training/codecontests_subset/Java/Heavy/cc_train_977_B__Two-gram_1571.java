import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pradyumn
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
            in.nextInt();
            String s = in.nextString();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i + 2 <= s.length(); ++i) {
                String ss = s.substring(i, i + 2);
                map.put(ss, map.getOrDefault(ss, 0) + 1);
            }
            String ans = null;
            for (String ss : map.keySet()) {
                if (ans == null || map.get(ans) < map.get(ss)) ans = ss;
            }
            out.println(ans);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public InputReader(InputStream var1) {
            this.stream = var1;
        }

        private int pread() {
            if (this.pnumChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.pnumChars) {
                    this.curChar = 0;

                    try {
                        this.pnumChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.pnumChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int var1;
            for (var1 = this.pread(); this.isSpaceChar(var1); var1 = this.pread()) {
                ;
            }

            byte var2 = 1;
            if (var1 == 45) {
                var2 = -1;
                var1 = this.pread();
            }

            int var3 = 0;

            do {
                if (var1 == 44) {
                    var1 = this.pread();
                }

                if (var1 < 48 || var1 > 57) {
                    throw new InputMismatchException();
                }

                var3 *= 10;
                var3 += var1 - 48;
                var1 = this.pread();
            } while (!this.isSpaceChar(var1));

            return var3 * var2;
        }

        public String nextString() {
            int var1;
            for (var1 = this.pread(); this.isSpaceChar(var1); var1 = this.pread()) {
                ;
            }

            StringBuilder var2 = new StringBuilder();

            do {
                var2.appendCodePoint(var1);
                var1 = this.pread();
            } while (!this.isSpaceChar(var1));

            return var2.toString();
        }

        private boolean isSpaceChar(int var1) {
            return var1 == 32 || var1 == 10 || var1 == 13 || var1 == 9 || var1 == -1;
        }

    }
}

