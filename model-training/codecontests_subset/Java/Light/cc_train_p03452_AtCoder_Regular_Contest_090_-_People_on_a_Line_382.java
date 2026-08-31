import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Mirio
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FReader in = new FReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        ArrayList<Pair<Integer, Integer>>[] a;
        int                                 n;
        int                                 m;
        int[]                               val;
        boolean[]                           vis;

        public void solve(int tc, FReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            a = (ArrayList<Pair<Integer, Integer>>[]) new ArrayList[n + 1];
            for(int i = 1; i <= n; ++i)
                a[i] = new ArrayList<Pair<Integer, Integer>>();

            for(int i = 0; i < m; ++i) {
                int L = in.nextInt();
                int R = in.nextInt();
                int D = in.nextInt();

                a[L].add(new Pair<>(R, D));
                a[R].add(new Pair<>(L, -D));
            }

            vis = new boolean[n + 1];
            val = new int[n + 1];

            boolean holds = true;
            for(int i = 1; i <= n; ++i)
                if(!vis[i]) {
                    val[i] = 1;
                    holds &= dfs(i);
                }

            out.println(holds ? "Yes" : "No");
        }

        private boolean dfs(int u) {
            vis[u] = true;
            for(Pair<Integer, Integer> other : a[u]) {
                if(vis[other.first]) {
                    if(val[other.first] != val[u] + other.second)
                        return false;
                } else {
                    val[other.first] = val[u] + other.second;
                    if(!dfs(other.first))
                        return false;
                }
            }

            return true;
        }

    }

    static class FReader {
        private BufferedReader  r;
        private String          line;
        private StringTokenizer st;
        private String          token;

        public FReader() {
            this(System.in);
        }

        public FReader(InputStream i) {
            r = new BufferedReader(new InputStreamReader(i));
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        private String peekToken() {
            if(token == null)
                try {
                    while(st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if(line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch(IOException e) { }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }

    }

    static class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F, S>> {
        public F first;
        public S second;

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }


        public int compareTo(Pair<F, S> fsPair) {
            int cmp = first.compareTo(fsPair.first);
            if(cmp == 0)
                return second.compareTo(fsPair.second);
            return cmp;
        }


        public boolean equals(Object o) {
            if(o == null || o.getClass() != this.getClass())
                return false;
            return compareTo((Pair<F, S>) o) == 0;
        }


        public String toString() {
            return "First: " + first + ", Second: " + second;
        }

    }
}

