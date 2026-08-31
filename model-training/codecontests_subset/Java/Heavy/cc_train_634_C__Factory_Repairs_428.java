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
 *
 * @author P Marecki
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n, k, a, b, q;
            n = in.nextInt();
            k = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();
            q = in.nextInt();
            int[] orders = new int[n + 10];
            SegTreeSum lessB = new SegTreeSum(n + 10);
            SegTreeSum lessA = new SegTreeSum(n + 10);
            for (int i = 0; i < q; i++) {
                int t = in.nextInt();
                if (t == 1) {
                    int d = in.nextInt();
                    int o = in.nextInt();
                    int old = orders[d];
                    orders[d] = Math.min(orders[d] + o, a);
                    int da = orders[d] - old;
                    int db = Math.min(orders[d], b) - Math.min(old, b);
                    lessA.add(d, da);
                    lessB.add(d, db);
                } else if (t == 2) {
                    int p = in.nextInt();
                    int sum = lessB.query(0, p - 1) + lessA.query(p + k, n + 1);
                    out.println(sum);
                }
            }
        }

        class SegTreeSum {
            int[] t;

            public SegTreeSum(int n) {
                t = new int[n * 2];
            }

            int query(int left, int right) {
                int n = t.length / 2;
                left += n;
                right += n;
                int res = 0;
                for (int lx = left, rx = right; lx <= rx; lx = (lx + 1) / 2, rx = (rx - 1) / 2) {
                    if ((lx & 1) != 0) {
                        res += t[lx];
                    }
                    if ((rx & 1) == 0) {
                        res += t[rx];
                    }
                }
                return res;
            }

            void add(int at, int value) {
                int n = t.length / 2;
                at += n;
                t[at] += value;
                for (int tx = at; tx > 0; tx /= 2)
                    if (tx > 1) {
                        t[tx / 2] = t[tx] + t[tx ^ 1];
                    }
            }

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

