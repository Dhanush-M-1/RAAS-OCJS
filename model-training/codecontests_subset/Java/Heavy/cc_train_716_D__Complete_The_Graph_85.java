import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.AbstractCollection;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author amalev
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
        long INF = 2_000_000_000_000L;
        int n;
        int m;
        long L;
        int s;
        int t;
        ArrayList<TaskD.Item>[] g;

        public long dist() {
            PriorityQueue<TaskD.Item> q = new PriorityQueue<>();
            int[] p = new int[n];
            long[] d = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = -1;
                d[i] = INF;
            }
            p[s] = -1;
            d[s] = 0;
            q.add(new TaskD.Item(s, 0, false));
            HashSet<Integer>[] q_u = new HashSet[n];
            for (int i = 0; i < n; i++) {
                q_u[i] = new HashSet<>();
            }
            boolean vars = false;
            while (!q.isEmpty()) {
                TaskD.Item e = q.poll();
                int v = e.v;
                long dist = e.d;

                if (dist > d[v])
                    continue;

                if (e.q) {
                    vars = true;
                    q_u[v].add(p[v]);
                    q_u[p[v]].add(v);
                }

                if (v == t) break;

                for (TaskD.Item it : g[v]) {
                    int u = it.v;
                    long w = it.d;
                    long n_d = d[v] + w;
                    if (n_d < d[u]) {
                        d[u] = n_d;
                        p[u] = v;
                        q.add(new TaskD.Item(u, n_d, it.q));
                    }
                }
            }

            if (d[t] < L && !vars) {
                return -1;
            }

            if (vars && d[t] < L) {
                boolean first = true;
                int first_u = -1;
                int first_v = -1;
                for (int u = 0; u < n; u++) {
                    for (TaskD.Item it : g[u]) {
                        if (it.q) {
                            if (q_u[u].contains(it.v)) {
                                if (first || (u == first_v && it.v == first_u)) {
                                    it.q = false;
                                    it.d += L - d[t];
                                    first = false;
                                    first_u = u;
                                    first_v = it.v;
                                }
                            } else {
                                it.q = false;
                                it.d = INF;
                            }
                        }
                    }
                }
            }


            return d[t];
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            L = in.nextLong();
            s = in.nextInt();
            t = in.nextInt();

            g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                long w = in.nextLong();
                boolean q = false;
                if (w == 0) {
                    w = 1;
                    q = true;
                }

                g[u].add(new TaskD.Item(v, w, q));
                g[v].add(new TaskD.Item(u, w, q));
            }


            long d = 0;
            while (d >= 0 && d < L) {
                d = dist();
            }
            if (d != L) {
                out.println("NO");
            } else {
                out.println("YES");
                for (int u = 0; u < n; u++) {
                    for (TaskD.Item it : g[u]) {
                        if (u < it.v) {
                            out.printf("%d %d %d\n", u, it.v, it.d);
                        }
                    }
                }
            }
        }

        static class Item implements Comparable<TaskD.Item> {
            int v;
            long d;
            boolean q;

            public Item(int v, long d, boolean q) {
                this.v = v;
                this.d = d;
                this.q = q;
            }


            public int compareTo(TaskD.Item o) {
                return Long.compare(this.d, o.d);
            }

        }

    }

    static class FastScanner {
        final BufferedReader input;
        String[] buffer;
        int pos;
        final static Pattern SEPARATOR = Pattern.compile("\\s+");

        public FastScanner(InputStream inputStream) {
            input = new BufferedReader(new InputStreamReader(inputStream));
        }

        private String read() {
            try {
                if (buffer == null || pos >= buffer.length) {
                    buffer = SEPARATOR.split(input.readLine());
                    pos = 0;
                }
                return buffer[pos++];
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        public long nextLong() {
            return Long.parseLong(read());
        }

        public int nextInt() {
            return Integer.parseInt(read());
        }

    }
}

