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
 *
 * @author MaxHeap
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int[] keys;
        Integer[] arr;
        int n;
        int k;
        int p;

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            n = in.nextInt();
            k = in.nextInt();
            p = in.nextInt();
            arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            keys = in.nextIntArray(k);
            Arrays.sort(arr);
            Arrays.sort(keys);
            long cur = (long) 1e18;
            for (int i = 0; i + n - 1 < k; i++) {
                long ans = 0;
                for (int j = 0, kk = i; j < n; j++, kk++) {
                    ans = Math.max(ans, Math.abs(arr[j] - keys[kk]) + Math.abs(keys[kk] - p));
                }
                cur = Math.min(cur, ans);
            }
            out.println(cur);
        }

    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            int i = 0;
            while (i < n) {
                arr[i++] = nextInt();
            }
            return arr;
        }

    }
}

