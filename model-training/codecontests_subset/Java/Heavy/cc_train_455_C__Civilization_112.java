//package practice.E;

import java.io.*;
import java.util.*;

public class CF455C {

    static ArrayList<Integer>[] adj;
    static int[] vis;
    static int vid;
    static int[] qu, dist;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        adj = new ArrayList[n];
        qu = new int[n]; dist = new int[n]; vis = new int[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        UnionFind set = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            adj[u].add(v); adj[v].add(u);
            set.unionSet(u, v);
        }

        vid = 1;
        Arrays.fill(set.length, 0);
        for (int i = 0; i < n; i++)
            if(vis[i] == 0)
                findDiameter(i, set);


        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if(type == 1){
                pw.println(set.length[set.findSet(sc.nextInt()-1)]);
            }else{
                set.unionSet(sc.nextInt()-1, sc.nextInt()-1);
//                System.err.println(Arrays.toString(set.length));
            }
        }

        pw.flush();
        pw.close();
    }

    static void findDiameter(int root, UnionFind set){
        vis[root] = vid;
        int qs = 0, qen = 1;
        qu[0] = root;
        int last = root;
        while(qs < qen){
            int u = qu[qs++];
            last = u;
            for (int v: adj[u]) {
                if(vis[v] !=  vid)
                {
                    vis[v] = vid;
                    dist[v] = dist[u] + 1;
                    qu[qen++] = v;
                }
            }
        }


        vid++;
        qs = 0;
        qen = 1;
        dist[last] = 0;
        qu[0] = last;
        vis[last] = vid;
        while(qs < qen){
            int u = qu[qs++];
            last = u;
            for (int v: adj[u]) {
                if(vis[v] !=  vid)
                {
                    vis[v] = vid;
                    dist[v] = dist[u] + 1;
                    qu[qen++] = v;
                }
            }
        }

        set.length[set.findSet(last)] = dist[last];
    }

    static class UnionFind {
        int[] p, rank;
        int[] length;
        int numSets;

        public UnionFind(int N)
        {
            p = new int[numSets = N];
            rank = new int[N];
            length = new int[N];
            for (int i = 0; i < N; i++) {  p[i] = i; }
        }

        public int findSet(int i) { return p[i] == i ? i : (p[i] = findSet(p[i])); }

        public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j)
        {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            if(rank[x] > rank[y]) {
                p[y] = x;
                length[x] = Math.max(length[x], Math.max(length[y], (length[x]+1)/2 + (length[y]+1)/2 + 1));
            }
            else
            {
                p[x] = y;
                length[y] = Math.max(length[x], Math.max(length[y], (length[x]+1)/2 + (length[y]+1)/2 + 1));
                if(rank[x] == rank[y]) rank[y]++;
            }
        }
    }

    static class Scanner
    {
        StringTokenizer st; BufferedReader br;
        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
        public Scanner(String s) throws FileNotFoundException {	br = new BufferedReader(new FileReader(new File(s)));}
        public String next() throws IOException {while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public long nextLong() throws IOException {return Long.parseLong(next());}
        public String nextLine() throws IOException {return br.readLine();}
        public boolean ready() throws IOException {return br.ready();}
    }
}
