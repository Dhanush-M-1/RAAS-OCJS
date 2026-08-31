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
        int n;
        int limit;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            limit = in.nextInt();
            long max = 0, balanse = 0, res = 0;
            for (int i = 0; i < n; ++i) {
                int x = in.nextInt();
                if (x == 0) {
                    if (!check(balanse)) {
                        if (0 - balanse <= max) {
                            max -= (0 - balanse);
                            balanse = 0;
                        } else {
                            ++res;
                            max = limit;
                            balanse = 0;
                        }
                    }
                } else if (x > 0) {
                    if (balanse + x > limit) {
                        if (max - x < 0) {
                            out.println(-1);
                            return;
                        }
                        max -= x;
                        balanse = max;
                    } else {
                        balanse += x;
                        max = Math.min(max, limit - Math.max(0, balanse));
                    }
                } else {
                    balanse += x;
                }
            }
            out.println(res);
        }

        private boolean check(long balanse) {
            return balanse >= 0;
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

