import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;
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
        int n;
        int m;
        int[][] arr;
        int mod = (int) 1e9 + 7;
        boolean[] flag;

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n][];
            UnionFind dsu = new UnionFind(m);
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                arr[i] = new int[k];
                if (k == 2) {
                    int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
                    arr[i][0] = u;
                    arr[i][1] = v;
                    dsu.unionSet(u, v);
                } else {
                    int u = sc.nextInt() - 1;
                    arr[i][0] = u;
                }
            }
            HashSet<Integer> set = new HashSet<>();
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i].length == 1) {
                    set.add(dsu.findSet(arr[i][0]));
                }
            }
            for (int x : set) {
                c += dsu.sizeOfSet(x);
            }
            long ans = 1;
            for (int i = 0; i < c; i++) {
                ans *= 2;
                ans %= mod;
            }
            long[] pows = new long[m + 1];
            pows[0] = 1;
            for (int i = 1; i <= m; i++)
                pows[i] = (pows[i - 1] * 2) % mod;
            HashSet<Integer> set2 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (arr[i].length == 2) {
                    int rep = dsu.findSet(arr[i][0]);
                    if (set.contains(rep) || set2.contains(rep))
                        continue;
                    int size = dsu.sizeOfSet(rep) - 1;
                    ans *= pows[size];
                    ans %= mod;
                    set2.add(rep);
                }
            }
            pw.print(ans + " ");
            ArrayList<Integer> idx = new ArrayList<>();
            UnionFind dsu2 = new UnionFind(m);
            for (int i = 0; i < n; i++) {
                if (arr[i].length == 2) {
                    if (!dsu2.isSameSet(arr[i][0], arr[i][1]) && (!dsu2.getFlag(arr[i][0]) || !dsu2.getFlag(arr[i][1]))) {
                        dsu2.unionSet(arr[i][0], arr[i][1]);
                        idx.add(i + 1);
                    }
                } else {
                    if (!dsu2.getFlag(arr[i][0])) {
                        dsu2.setFlag(arr[i][0]);
                        idx.add(i + 1);
                    }
                }
            }
            Collections.sort(idx);
            pw.println(idx.size());
            for (int i = 0; i < idx.size(); i++)
                pw.print(idx.get(i) + " ");
        }

        public class UnionFind {
            int[] p;
            int[] rank;
            int[] setSize;
            int numSets;

            public UnionFind(int N) {
                p = new int[numSets = N];
                rank = new int[N];
                setSize = new int[N];
                flag = new boolean[N];
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
                flag[x] |= flag[y];
                flag[y] |= flag[x];
            }

            public int sizeOfSet(int i) {
                return setSize[findSet(i)];
            }

            public void setFlag(int i) {
                flag[findSet(i)] = true;
            }

            public boolean getFlag(int i) {
                return flag[findSet(i)];
            }

        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

