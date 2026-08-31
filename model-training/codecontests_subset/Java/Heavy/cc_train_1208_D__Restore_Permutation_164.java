import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author null
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Input in = new Input(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        final int T = 1 << 18;
        long[] t = new long[2 * T];

        public void solve(int testNumber, Input in, PrintWriter out) {
            try {
                int n = in.readInt();
                long[] f = new long[n];
                for (int i = 0; i < n; i++) {
                    f[i] = in.readLong();
                }

                for (int i = T; i < t.length; i++) {
                    t[i] = i - T;
                }
                for (int i = T - 1; i >= 1; i--) {
                    t[i] = t[2 * i] + t[2 * i + 1];
                }

                int[] p = new int[n];
                for (int i = n - 1; i >= 0; i--) {
                    p[i] = find(f[i]);
                    remove(p[i]);
                }

                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    ans.append(p[i]).append(' ');
                }
                out.println(ans.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        int find(long s) {
            int v = 1;
            while (v < T) {
                if (t[2 * v] > s) {
                    v = 2 * v;
                } else {
                    s -= t[2 * v];
                    v = 2 * v + 1;
                }
            }
            return v - T;
        }

        void remove(int p) {
            p = T + p;
            t[p] = 0;
            while (p > 1) {
                p /= 2;
                t[p] = t[2 * p] + t[2 * p + 1];
            }
        }

    }

    static class Input {
        public final BufferedReader reader;
        private String line = "";
        private int pos = 0;

        public Input(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private boolean isSpace(char ch) {
            return ch <= 32;
        }

        public String readWord() throws IOException {
            skip();
            int start = pos;
            while (pos < line.length() && !isSpace(line.charAt(pos))) {
                pos++;
            }
            return line.substring(start, pos);
        }

        public int readInt() throws IOException {
            return Integer.parseInt(readWord());
        }

        public long readLong() throws IOException {
            return Long.parseLong(readWord());
        }

        private void skip() throws IOException {
            while (true) {
                if (pos >= line.length()) {
                    line = reader.readLine();
                    pos = 0;
                }
                while (pos < line.length() && isSpace(line.charAt(pos))) {
                    pos++;
                }
                if (pos < line.length()) {
                    return;
                }
            }
        }

    }
}

