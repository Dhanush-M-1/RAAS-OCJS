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
 * @author MottoX
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
        private boolean check(int[] ans, Query[] queries, int n) {
            int[] ret = Arrays.copyOf(ans, n);
            for (Query query : queries) {
                if (query.type == 1) {
                    for (int i = query.l; i <= query.r; i++) {
                        ret[i] += query.d;
                    }
                } else {
                    int val = ret[query.l];
                    for (int i = query.l; i <= query.r; i++) {
                        val = Math.max(val, ret[i]);
                    }
                    if (val != query.d) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            int[] org = new int[n];
            int[] add = new int[n];

            Query[] queries = new Query[m];
            Arrays.fill(org, 1000000000);

            for (int i = 0; i < m; i++) {
                int t = in.nextInt();
                int l = in.nextInt(), r = in.nextInt(), d = in.nextInt();
                l--;
                r--;
                queries[i] = new Query(t, l, r, d);
                if (t == 1) {
                    for (int j = l; j <= r; j++) {
                        add[j] += d;
                    }
                } else {
                    for (int j = l; j <= r; j++) {
                        int now = d - add[j];
                        org[j] = Math.min(now, org[j]);
                    }
                }
            }

            if (!check(org, queries, n)) {
                out.println("NO");
            } else {
                out.println("YES");
                for (int i = 0; i < n; i++) {
                    out.print(org[i] + " ");
                }
            }
        }

        private class Query {
            int type;
            int l;
            int r;
            int d;

            public Query(int type, int l, int r, int d) {
                this.type = type;
                this.l = l;
                this.r = r;
                this.d = d;
            }

        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

