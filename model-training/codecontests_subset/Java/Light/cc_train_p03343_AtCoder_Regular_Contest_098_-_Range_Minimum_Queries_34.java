import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Comparator;
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
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt(), k = in.nextInt(), q = in.nextInt();
            int[] a = in.nextIntArray(n);
            Pair[] p = new Pair[n];
            for (int i = 0; i < n; i++) {
                p[i] = new Pair(a[i], i);
            }
            Arrays.sort(p, Comparator.comparing(x -> x.value));
            int result = Integer.MAX_VALUE;
            for (int left = 0; left < n; left++) {
                int[] color = new int[n];
                int l = left - 1, r = n;
                while (l < r - 1) {
                    int m = (l + r) >>> 1;

                    Arrays.fill(color, 0);
                    for (int i = 0; i < left; i++) {
                        color[p[i].id] = -1;
                    }
                    for (int i = m + 1; i < n; i++) {
                        color[p[i].id] = 1;
                    }
                    int sum = 0;
                    for (int i = 0; i < n; ) {
                        if (color[i] == -1) {
                            i++;
                            continue;
                        }
                        int j = i;
                        while (j < n && color[j] != -1) {
                            j++;
                        }
                        int count0 = 0;
                        for (int t = i; t < j; t++) {
                            if (color[t] == 0) {
                                count0++;
                            }
                        }
                        if (j - i >= k) {
                            sum += Math.min(count0, j - i - k + 1);
                        }
                        i = j;
                    }
                    if (sum >= q) {
                        r = m;
                    } else {
                        l = m;
                    }
                }
                if (r != n) {
                    result = Math.min(result, p[r].value - p[left].value);
                }
            }
            out.println(result);
        }

        class Pair {
            int value;
            int id;

            public Pair(int value, int id) {
                this.value = value;
                this.id = id;
            }

        }

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int[] nextIntArray(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }

    }
}

