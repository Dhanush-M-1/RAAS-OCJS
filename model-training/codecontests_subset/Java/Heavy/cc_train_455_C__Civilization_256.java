import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        new Main().solve();

    }

    int mod = 1000000007;

    PrintWriter out;

    int n;
    int m;

    ArrayList<Integer>[] g;

    void solve() throws IOException {

        //Reader in = new Reader("in.txt");
        //out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        Reader in = new Reader();
        out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );

        //BufferedReader br = new BufferedReader( new FileReader("in.txt") );
        //BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        DSU dsu = new DSU(n);

        g = new ArrayList[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int x = in.nextInt()-1;
            int y = in.nextInt()-1;

            g[x].add(y);
            g[y].add(x);

            dsu.union(x, y);
        }

        for (int i = 0; i < n; i++) {

            if (!used[i]) {

                max = 0;
                dfs(i, -1);
                int v = dsu.get(i);
                dsu.sz[v] = max;

                //System.err.println(max);
            }
        }

        for (int i = 0; i < k; i++) {

            int t = in.nextInt();

            if (t == 1) {

                int v = in.nextInt()-1;
                int res = dsu.get_size(v);
                out.println(res);
            }
            else {

                int x = in.nextInt()-1;
                int y = in.nextInt()-1;

                dsu.union(x, y);
            }

        }

        out.flush();
        out.close();
    }

    int max = 0;
    boolean[] used = new boolean[1000000];

    int dfs(int v, int p) {

        used[v] = true;

        int cnt = 0;

        for (int u : g[v])
            if (u != p) {

                int res = dfs(u, v);
                max = Math.max(max, res+cnt);
                cnt = Math.max(cnt, res);

                //System.err.println(v+" "+res);
            }

        return cnt+1;
    }

    class DSU {

        int[] set;
        int[] sz;

        DSU(int n) {

            set = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++)
                set[i] = i;
        }

        int get(int v) {

            if (set[v] == v)
                return v;

            return set[v] = get(set[v]);
        }


        void union(int a, int b) {

            a = get(a);
            b = get(b);

            int sz1 = sz[a];
            int sz2 = sz[b];

            if (a != b) {

                if ((int) Math.random() == 1) {
                    set[a] = b;
                    sz[b] = Math.max(Math.max(sz[a], sz[b]), (sz1+1)/2+(sz2+1)/2+1);
                }
                else {
                    set[b] = a;
                    sz[a] = Math.max(Math.max(sz[a], sz[b]), (sz1+1)/2+(sz2+1)/2+1);
                }
            }
        }

        int get_size(int v) {

            v = get(v);
            return sz[v];
        }



    }

    class Pair implements Comparable<Pair>{

        int a;
        int b;


        Pair(int a, int b) {

            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {

            if (a > p.a)
                return 1;

            if (a < p.a)
                return -1;

            if (b > p.b)
                return 1;

            if (b < p.b)
                return -1;

            return 0;
        }
    }

    class Reader {

        BufferedReader  br;
        StringTokenizer tok;

        Reader(String file) throws IOException {
            br = new BufferedReader( new FileReader(file) );
        }

        Reader() throws IOException {
            br = new BufferedReader( new InputStreamReader(System.in) );
        }

        String next() throws IOException {

            while (tok == null || !tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.valueOf(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.valueOf(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.valueOf(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

    }

}