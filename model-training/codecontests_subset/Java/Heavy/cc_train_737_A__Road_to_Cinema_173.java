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
            int k = in.nextInt();
            int s = in.nextInt();
            int t = in.nextInt();
            int[] c = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
                v[i] = in.nextInt();
            }
            Integer[] g = new Integer[k];
            for (int i = 0; i < k; i++) {
                g[i] = in.nextInt();
            }
            Arrays.sort(g);
            int r = (int) 2e9;
            int l = 0;
            while (r - l > 1) {
                int mid = (l + r) / 2;
                if (check(mid, g, s, t)) r = mid;
                else l = mid;
            }
            int minC = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (v[i] >= r) {
                    minC = Math.min(minC, c[i]);
                }
            }
            if (minC == Integer.MAX_VALUE)
                out.println(-1);
            else out.println(minC);
        }

        boolean check(int v, Integer[] g, int s, int t) {
            int prevPos = 0;
            double time = 0;
            for (int i = 0; i < g.length; i++) {
                time += getTime(g[i] - prevPos, v);
                prevPos = g[i];
            }
            time += getTime(s - prevPos, v);
            if (time <= t)
                return true;
            return false;
        }

        double getTime(double len, int v) {
            double fullLen = Math.min(v - len, len);
            if (fullLen < 0) return Double.POSITIVE_INFINITY;
            double stdLen = len - fullLen;
            return fullLen + 2 * stdLen;
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

