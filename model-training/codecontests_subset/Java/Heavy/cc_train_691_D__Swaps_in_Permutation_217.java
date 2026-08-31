import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    int n, m;
    int ms[];
    ArrayList<Integer> neig[];
    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<Integer> indexes = new ArrayList<>();
    boolean used[];

    void dfs(int v) {
        if (used[v])
            return;
        used[v] = true;
        values.add(ms[v]);
        indexes.add(v);
        for (Integer it : neig[v]) {
            dfs(it);
        }
    }

    public void solve() {
        n = in.nextInt();
        m = in.nextInt();
        ms = new int[n];
        used = new boolean[n];
        neig = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            neig[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            ms[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1, b = in.nextInt() - 1;
            neig[a].add(b);
            neig[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;
            values.clear();
            indexes.clear();
            dfs(i);
            Collections.sort(values, Comparator.reverseOrder());
            Collections.sort(indexes);
            for (int z = 0; z < values.size(); z++) {
                ms[indexes.get(z)] = values.get(z);
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(ms[i] + " ");
        }
    }

    public void run() {
        if (FILE.equals("")) {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new FastScanner(new FileInputStream(FILE +
                        ".in"));
                out = new PrintWriter(new FileOutputStream(FILE +
                        ".out"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        solve();
        out.close();
    }

    public static void main(String[] args) {
        (new Main()).run();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }

    class Pair<A extends Comparable<A>, B extends Comparable<B>>
            implements Comparable<Pair<A, B>> {
        public A a;
        public B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair<A, B> o) {
            if (o == null || o.getClass() != getClass())
                return 1;
            int cmp = a.compareTo(o.a);
            if (cmp == 0)
                return b.compareTo(o.b);
            return cmp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (a != null ? !a.equals(pair.a) : pair.a != null) return
                    false;
            return !(b != null ? !b.equals(pair.b) : pair.b != null);
        }
    }

    class PairInt extends Pair<Integer, Integer> {
        public PairInt(Integer u, Integer v) {
            super(u, v);
        }
    }

    class PairLong extends Pair<Long, Long> {
        public PairLong(Long u, Long v) {
            super(u, v);
        }
    }

}