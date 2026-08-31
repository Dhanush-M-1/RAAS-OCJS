import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
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
        public void solve(int testNumber, MyScan in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int h = in.nextInt();
            int[] data = in.na(n);
            DirectedGraph dg = new DirectedGraph(n);
            for (int s = 0; s < m; s++) {
                int f = in.nextInt() - 1;
                int t = in.nextInt() - 1;
                if (data[t] == (data[f] + 1) % h) {
                    dg.add(f, t);
                }
                if (data[f] == (data[t] + 1) % h) {
                    dg.add(t, f);
                }
            }
            DirectedGraph condensate = dg.condensate();

            AList best = null;
            for (int k : condensate.leaves()) {
                AList t = condensate.stat(k);
                if (best == null || best.size() > t.size()) {
                    best = t;
                }
            }
            out.println(best.size());
            out.println(best.p1());
        }

    }

    static class DirectedGraph {
        private int n;
        AList[] direct;
        AList[] reverse;
        public Object[] vstat;

        public DirectedGraph(int n) {
            this.n = n;
            direct = new AList[n];
            reverse = new AList[n];
            for (int i = 0; i < n; i++) {
                direct[i] = new AList();
                reverse[i] = new AList();
            }
        }

        public void add(int from, int to) {
            direct[from].add(to);
            reverse[to].add(from);
        }

        private List<AList> components() {
            boolean[] used = new boolean[n];
            int[] order = new int[n];
            int d = 0;
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    d = dfs1(i, used, order, d);
                }
            }
            Arrays.fill(used, false);
            List<AList> ret = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int v = order[n - i - 1];
                if (!used[v]) {
                    AList component = new AList();
                    dfs2(v, used, component);
                    ret.add(component);
                }
            }
            return ret;
        }

        public DirectedGraph condensate() {
            List<AList> com = components();
            DirectedGraph dg = new DirectedGraph(com.size());
            int[] cl = new int[n];
            int curcp = 0;
            dg.vstat = new Object[com.size()];
            for (AList c : com) {
                for (int p : c) {
                    cl[p] = curcp;
                }
                dg.vstat[curcp] = c;
                curcp++;
            }
            for (AList c : com) {
                for (int p : c) {
                    for (int dest : direct[p]) {
                        if (cl[p] != cl[dest])
                            dg.add(cl[p], cl[dest]);
                    }
                }
            }
            dg.removeExtra();
            return dg;
        }

        private void removeExtra() {
            for (AList a : direct) {
                a.sort();
                a.removeDup();
            }
            for (AList a : reverse) {
                a.sort();
                a.removeDup();
            }
        }

        public <T> T stat(int i) {
            return (T) vstat[i];
        }

        public AList leaves() {
            AList a = new AList();
            for (int i = 0; i < direct.length; i++) {
                if (direct[i].c == 0) {
                    a.add(i);
                }
            }
            return a;
        }

        private int dfs1(int v, boolean[] used, int[] order, int index) {
            used[v] = true;
            for (int l : direct[v]) {
                if (!used[l])
                    index = dfs1(l, used, order, index);
            }
            order[index++] = v;
            return index;
        }

        private void dfs2(int v, boolean[] used, AList component) {
            used[v] = true;
            component.add(v);
            for (int l : reverse[v])
                if (!used[l])
                    dfs2(l, used, component);
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

    static class AList implements Iterable<Integer> {
        int[] data;
        int c = 0;

        public AList(int n) {
            this.data = new int[Math.max(Integer.highestOneBit(n - 1) << 1, 4)];
        }

        public AList() {
            this(4);
        }

        public AList(int[] data) {
            this(data.length);
            System.arraycopy(data, 0, this.data, 0, data.length);
        }

        public void sort() {
            Arrays.sort(data, 0, c);
        }

        public void add(int k) {
            if (c == data.length) {
                data = Arrays.copyOf(data, data.length << 1);
            }
            data[c++] = k;
        }


        public Iterator<Integer> iterator() {
            int[] m = new int[1];
            return new Iterator<Integer>() {

                public boolean hasNext() {
                    return m[0] < AList.this.c;
                }


                public Integer next() {
                    return AList.this.data[m[0]++];
                }
            };
        }

        public String p1() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c; i++) {
                sb.append(data[i] + 1).append(' ');
            }
            return sb.toString();
        }


        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c; i++) {
                sb.append(data[i]).append(' ');
            }
            return sb.toString();
        }

        public void removeDup() {
            int sh = 0;
            for (int i = 1; i < c; i++) {
                if (data[i] == data[i - 1 - sh]) {
                    sh++;
                } else {
                    data[i - sh] = data[i];
                }
            }
            c -= sh;
        }

        public int size() {
            return c;
        }

    }
}

