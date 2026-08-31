import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] type = new int[m];
            int[] l = new int[m];
            int[] r = new int[m];
            int[] val = new int[m];
            int[] a = new int[n];
            Arrays.fill(a, 1000000000);
            int[] dif = new int[n];
            for (int i = 0; i < m; i++) {
                type[i] = in.nextInt();
                l[i] = in.nextInt();
                r[i] = in.nextInt();
                val[i] = in.nextInt();
                if (type[i] == 1) {
                    for (int j = l[i] - 1; j < r[i]; j++) {
                        dif[j] += val[i];
                    }
                } else {
                    for (int j = l[i] - 1; j < r[i]; j++) {
                        a[j] = Math.min(a[j], val[i] - dif[j]);
                    }
                }
            }
            int[] test = Arrays.copyOf(a, n);
            for (int i = 0; i < m; i++) {
                if (type[i] == 1) {
                    for (int j = l[i] - 1; j < r[i]; j++) {
                        test[j] += val[i];
                    }
                } else {
                    int maxV = -1000000000;
                    for (int j = l[i] - 1; j < r[i]; j++) {
                        maxV = Math.max(maxV, test[j]);
                    }
                    if (maxV < val[i]) {
                        out.println("NO");
                        return;
                    }
                }
            }
            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.print(a[i] + " ");
            }
        }

    }

    static class InputReader {
        private StringTokenizer tokenizer;
        private BufferedReader reader;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private void fillTokenizer() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            fillTokenizer();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

