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
 *
 * @author vikas.k
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int n;
        int k;
        int office;
        int[] a;
        int[] b;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            n = in.nextInt();
            k = in.nextInt();

            office = in.nextInt();

            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }

            Arrays.sort(a, 1, n + 1);
            b = new int[k + 1];
            for (int i = 1; i <= k; i++) {
                b[i] = in.nextInt();
            }
            Arrays.sort(b, 1, k + 1);

            long lo = 0;
            long hi = 10000000000L;

            while (hi - lo > 1) {
                long md = lo + (hi - lo) / 2;

                if (check(md)) hi = md;
                else lo = md;
            }

            for (; lo <= hi; lo++) {
                if (check(lo)) {
                    out.print(lo);
                    return;
                }
            }

        }

        private boolean check(long time) {
            boolean[] mrk = new boolean[k + 1];

            for (int i = 1; i <= n; i++) {
                int j;
                for (j = 1; j <= k; j++) {
                    if (mrk[j]) continue;
                    int m = Math.min(a[i], b[j]);
                    m = Math.min(m, office);
                    int s = Math.max(a[i], b[j]);
                    s = Math.max(s, office);

                    long v = 2 * ((long) s - m) - Math.abs(a[i] - office);

                    if (v <= time) {
                        mrk[j] = true;
                        break;
                    }
                }

                if (j == k + 1) return false;
            }
            return true;
        }

    }

    static class FastScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            if (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

