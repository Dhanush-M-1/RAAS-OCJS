import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {

    static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        adjList = new ArrayList[n];
        for(int i = 0; i < n; ++i)
            adjList[i] = new ArrayList<>();
        DSU dsu = new DSU(n);
        while(m-->0) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            adjList[a].add(b);
            adjList[b].add(a);
            dsu.union(a, b);
        }
        int[] d = new int[n];
        for(int i = 0; i < n; ++i)
            if(dsu.find(i) == i)
                d[i] = getDiameter(i);
        while(q-->0)
            if(sc.nextInt() == 1) {
                out.println(d[dsu.find(sc.nextInt() - 1)]);
            } else {
                int x = dsu.find(sc.nextInt() - 1), y = dsu.find(sc.nextInt() - 1);
                if(dsu.union(x, y))
                    d[dsu.find(x)] = Math.max((d[x] + 1) / 2 + (d[y] + 1) / 2 + 1, Math.max(d[x], d[y]));
            }

        out.close();
    }

    static int maxDepth, maxNode;
    static int getDiameter(int u) {
        maxDepth = -1;
        dfs(u, 0, -1);
        maxDepth = -1;
        dfs(maxNode, 0, -1);
        return maxDepth;
    }

    static void dfs(int u, int d, int p) {
        if(d > maxDepth) {
            maxDepth = d;
            maxNode = u;
        }
        for(int v: adjList[u]) if(v != p)
            dfs(v, d + 1, u);
    }

    static class DSU {
        int[] p, r;

        DSU(int N) {
            p = new int[N];
            r = new int[N];
            for(int i = 0; i < N; ++i)
                p[i] = i;
        }

        int find(int x) { return x == p[x] ? x : find(p[x]); }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);

            if(x == y) return false;

            if(r[x] > r[y]) {
                p[y] = x;
            } else {
                p[x] = y;
                if(r[x] == r[y])
                    ++r[y];
            }
            return true;
        }
    }



    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public boolean ready() throws IOException {return br.ready();}


    }
}