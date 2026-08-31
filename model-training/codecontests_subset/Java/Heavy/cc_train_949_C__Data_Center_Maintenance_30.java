import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScan in = new MyScan(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        static Set<Integer>[] g;
        static Set<Integer>[] gr;
        static boolean[] used;
        static List<Integer> order;
        static List<Integer> component;

        public void solve(int testNumber, MyScan in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int h = in.nextInt();
            int[] da = in.na(n);

            g = new Set[n];
            gr = new Set[n];
            used = new boolean[n];
            order = new ArrayList<>();
            component = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                g[i] = new HashSet<>();
                gr[i] = new HashSet<>();
            }

            for (int s = 0; s < m; s++) {
                int l1 = in.nextInt() - 1;
                int l2 = in.nextInt() - 1;
                if (da[l1] == (da[l2] + 1) % h) {

                    g[l2].add(l1);
                    gr[l1].add(l2);
                }

                if (da[l2] == (da[l1] + 1) % h) {
                    g[l1].add(l2);
                    gr[l2].add(l1);
                }
            }

            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    dfs1(i);
                }
            }
            Arrays.fill(used, false);

            List<Integer> best = null;
            int[] cc = new int[n];
            int ct = 0;
            for (int i = 0; i < n; i++) {
                int v = order.get(n - i - 1);
                if (!used[v]) {
                    component = new ArrayList<>();
                    ct++;
                    dfs2(v);
                    for (int l : component) {
                        cc[l] = ct;
                    }
                    if (best == null || best.size() > component.size()) {
                        boolean r = true;
                        for (int f : component) {
                            for (int s : g[f]) {
                                r &= cc[s] == ct;
                            }
                        }
                        if (r)
                            best = component;
                    }
                }

            }
            out.println(best.size());
            for (int l : best) {
                out.print((l + 1) + " ");
            }

        }

        static void dfs1(int v) {
            used[v] = true;
            for (int l : g[v]) {
                if (!used[l])
                    dfs1(l);

            }

            order.add(v);
        }

        static void dfs2(int v) {
            used[v] = true;
            component.add(v);
            for (int l : gr[v])
                if (!used[l])
                    dfs2(l);
        }

    }

    static class MyScan {
        BufferedReader br;
        StringTokenizer st;

        MyScan(BufferedReader br) {
            this.br = br;
        }

        public MyScan(InputStream in) {
            this(new BufferedReader(new InputStreamReader(in)));
        }

        public void findToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public String next() {
            findToken();
            return st.nextToken();
        }

        public int[] na(int n) {
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = fi();
            }
            return k;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int fi() {
            String t = next();
            int cur = 0;
            boolean n = t.charAt(0) == '-';
            for (int a = n ? 1 : 0; a < t.length(); a++) {
                cur = cur * 10 + t.charAt(a) - '0';
            }
            return n ? -cur : cur;
        }

    }
}