import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int g = 0;
            int[] cur = new int[2];
            if (query(0, 0, out, in) >= 0) {
                g = 0;
            } else {
                g = 1;
            }
            for (int i = 29; i >= 0; i--) {
                int[] q = new int[]{query(cur[0] + (1 << i), cur[1], out, in), query(cur[0], cur[1] + (1 << i), out, in)};
                if (q[0] != q[1]) {
                    if (q[1] == 1) {
                        cur[0] += (1 << i);
                        cur[1] += (1 << i);
                    }
                } else {
                    cur[g] += (1 << i);
                    if (q[0] == 1) {
                        g = 0;
                    } else {
                        g = 1;
                    }
                }
            }
            out.println("! " + cur[0] + " " + cur[1]);
        }

        int query(int c, int d, PrintWriter out, InputReader in) {
            out.println("? " + c + " " + d);
            out.flush();
            return (in.nextInt());
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

