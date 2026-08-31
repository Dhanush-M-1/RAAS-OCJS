import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ShekharN
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            List[] graph = IntStream.rangeClosed(0, n)
                    .mapToObj(i -> new ArrayList<PairIntInt>())
                    .toArray(List[]::new);

            for (int i = 0; i < m; i++) {
                int l = in.nextInt(), r = in.nextInt(), d = in.nextInt();
                graph[l].add(new PairIntInt(r, d));
                graph[r].add(new PairIntInt(l, -d));
            }

            if (check(graph, n)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }

        private boolean check(List[] graph, int n) {
            int[] values = IntStream.range(0, n + 1).map(i -> Integer.MIN_VALUE).toArray();
            for (int i = 1; i <= n; i++) {
                if (values[i] == Integer.MIN_VALUE && !dfs(graph, values, i, 0, 0, 0))
                    return false;
            }
            return true;
        }

        private boolean dfs(List[] graph, int[] values, int cur, int curVal, int mx, int mn) {
            if ((values[cur] != Integer.MIN_VALUE && values[cur] != curVal) || mx - mn > 1000000000)
                return false;
            if (values[cur] == Integer.MIN_VALUE) {
                values[cur] = curVal;
                for (int i = 0; i < graph[cur].size(); i++) {
                    PairIntInt child = (PairIntInt) graph[cur].get(i);
                    int val = curVal + child.getSecond();
                    mx = Math.max(mx, val);
                    mn = Math.min(mn, val);
                    if (!dfs(graph, values, child.getFirst(), val, mx, mn))
                        return false;
                }
            }
            return true;
        }

    }

    static class PairIntInt {
        private int first;
        private int second;

        PairIntInt() {
        }

        public PairIntInt(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PairIntInt that = (PairIntInt) o;

            if (first != that.first) return false;
            return second == that.second;
        }


        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }

    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        public String nextString() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

    }
}

