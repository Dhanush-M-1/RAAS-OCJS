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
 * @author rizhiy
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
            int maxn = 1000000;
            int[] a = new int[maxn + 1];
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                a[x]++;
            }
            int[] to = new int[maxn + 1];
            to[1] = a[1];
            for (int i = 2; i <= maxn; i++) {
                to[i] = to[i - 1];
                to[i] += a[i];
            }
            int[] ot = new int[maxn + 1];
            ot[maxn] = a[maxn];
            for (int i = maxn - 1; i >= 1; i--) {
                ot[i] = ot[i + 1];
                ot[i] += a[i];
            }
            int answ = Integer.MAX_VALUE;
            for (int i = 1; i <= maxn; i++) {
                if (ot[maxn - i + 1] + to[i] == n)
                    answ = Math.min(answ, i - 1);
            }
            out.println(answ);
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

