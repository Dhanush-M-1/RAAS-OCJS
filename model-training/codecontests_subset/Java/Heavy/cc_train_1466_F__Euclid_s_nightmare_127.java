import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FEuclidsNightmare solver = new FEuclidsNightmare();
        solver.solve(1, in, out);
        out.close();
    }

    static class FEuclidsNightmare {
        public void solve(int testNumber, Scanner sc, PrintWriter out) {
            int n = sc.nextInt(), m = sc.nextInt();
            FEuclidsNightmare.UnionFind uf = new FEuclidsNightmare.UnionFind(m + 1);
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int u, v;
                if (sc.nextInt() == 1) {
                    u = sc.nextInt() - 1;
                    v = m;
                } else {
                    u = sc.nextInt() - 1;
                    v = sc.nextInt() - 1;
                }
                if (!uf.isSameSet(u, v)) {
                    uf.unionSet(u, v);
                    ans.add(i);
                }
            }
            out.println(modPow(2, ans.size(), (int) 1e9 + 7) + " " + ans.size());
            for (int x : ans)
                out.print(x + " ");
            out.println();
        }

        static int modPow(long a, long e, int mod) {
            a %= mod;
            long res = 1;
            while (e > 0) {
                if ((e & 1) == 1)
                    res = (res * a) % mod;
                a = (a * a) % mod;
                e >>= 1;
            }
            return (int) res;
        }

        static class UnionFind {
            int[] p;
            int[] rank;
            int[] setSize;
            int numSets;

            public UnionFind(int N) {
                p = new int[numSets = N];
                rank = new int[N];
                setSize = new int[N];
                for (int i = 0; i < N; i++) {
                    p[i] = i;
                    setSize[i] = 1;
                }
            }

            public int findSet(int i) {
                return p[i] == i ? i : (p[i] = findSet(p[i]));
            }

            public boolean isSameSet(int i, int j) {
                return findSet(i) == findSet(j);
            }

            public void unionSet(int i, int j) {
                if (isSameSet(i, j))
                    return;
                numSets--;
                int x = findSet(i), y = findSet(j);
                if (rank[x] > rank[y]) {
                    p[y] = x;
                    setSize[x] += setSize[y];
                } else {
                    p[x] = y;
                    setSize[y] += setSize[x];
                    if (rank[x] == rank[y]) rank[y]++;
                }
            }

        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

