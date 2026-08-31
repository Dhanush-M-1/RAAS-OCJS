import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            int[] a = new int[n];
            int[] val = new int[n];
            boolean[] was = new boolean[n];
            Arrays.fill(a, 0);
            Arrays.fill(was, false);
            int[] left = new int[m];
            int[] right = new int[m];
            int[] type = new int[m];
            int[] value = new int[m];
            for (int i = 0; i < m; i++) {
                int t = in.nextInt();
                if (t == 1) {
                    int le = in.nextInt() - 1, ri = in.nextInt() - 1, d = in.nextInt();
                    type[i] = t;
                    left[i] = le;
                    right[i] = ri;
                    value[i] = d;
                    for (int j = le; j <= ri; j++) {
                        a[j] += d;
                    }
                } else {
                    int le = in.nextInt() - 1, ri = in.nextInt() - 1, max = in.nextInt();
                    type[i] = t;
                    left[i] = le;
                    right[i] = ri;
                    value[i] = max;
                    for (int j = le; j <= ri; j++) {
                        if (!was[j]) {
                            was[j] = true;
                            val[j] = max - a[j];
                        }
                        int cur = max - a[j];
                        val[j] = Math.min(val[j], cur);
                    }
                }
            }
            boolean fail = false;
            for (int i = 0; i < n; i++) {
                a[i] = val[i];
            }
            for (int i = 0; i < m; i++) {
                if (type[i] == 1) {
                    for (int j = left[i]; j <= right[i]; j++) {
                        a[j] += value[i];
                    }
                } else {
                    int need = -(int) 1e9;
                    for (int j = left[i]; j <= right[i]; j++) {
                        need = Math.max(need, a[j]);
                    }
                    if (need != value[i]) {
                        fail = true;
                        break;
                    }
                }
            }
            if (fail) {
                out.println("NO");
                return;
            }
            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.print(val[i] + " ");
            }
            out.println("");
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

