
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by mostafa on 9/24/17.
 */
public class Civil {
    static class Pair {
        int node; int dist;
        Pair(int n, int d) {
            node = n; dist = d;
        }
    }
    static ArrayList<Integer>[] adj;
    static int n, inf = (int) 1e9;
    static boolean[] visited;
    static Pair farthest(int u) {
        HashMap<Integer, Integer> dist = new HashMap<>();
        dist.put(u, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        ArrayList<Pair> explored = new ArrayList<>();
        while(!q.isEmpty()) {
            u = q.remove();
            int curDist = dist.get(u);
            explored.add(new Pair(u, curDist));
            visited[u] = true;
            for(int v: adj[u])
                if(!dist.containsKey(v)) {
                    dist.put(v, 1 + curDist);
                    q.add(v);
                }
        }

        int furthest = -1;
        int dia = -1;
        for(Pair p: explored)
            if(furthest == -1 || p.dist > dia) {
                furthest = p.node;
                dia = p.dist;
            }
        return new Pair(furthest, dia);
    }

    static UnionFind uf;

    static void diameter(int u) {
        int tmp = farthest(u).node;
        int diameter =  farthest(tmp).dist;
        uf.setRegionSize(u, diameter);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        uf = new UnionFind(n);
        visited = new boolean[n];
        while(m-->0) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
            uf.unionSet(u, v);
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                diameter(i);
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        while(q-->0) {
            if(sc.nextInt() == 1)
                out.println(uf.getRegionSize(sc.nextInt() - 1));
            else
                uf.unionSet(sc.nextInt() - 1, sc.nextInt() - 1);
        }

        out.flush();
        out.close();
    }
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    static class UnionFind {
        int[] p, rank, setSize, regionSize;
        int numSets;

        public UnionFind(int N)
        {
            regionSize = new int[N];
            p = new int[numSets = N];
            rank = new int[N];
            setSize = new int[N];
            for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
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
                p[y] = x; setSize[x] += setSize[y];

                regionSize[x] = Math.max(Math.max(regionSize[y], regionSize[x]), (regionSize[x] + 1) / 2 + (regionSize[y] + 1) / 2 + 1);
            }
            else
            {	p[x] = y; setSize[y] += setSize[x];
                regionSize[y] = Math.max(Math.max(regionSize[y], regionSize[x]), (regionSize[x] + 1) / 2 + (regionSize[y] + 1) / 2 + 1);
                if(rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() { return numSets; }

        public int sizeOfSet(int i) { return setSize[findSet(i)]; }

        public void setRegionSize(int i, int size) {
            int x = findSet(i);
            regionSize[x] = Math.max(regionSize[x], size);
        }

        public int getRegionSize(int i) {
            return regionSize[findSet(i)];
        }
    }
}
