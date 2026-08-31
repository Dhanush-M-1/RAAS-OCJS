import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] q = new int[N];
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            q[i] = scanner.nextInt()-1;
            graph[i] = new ArrayList<>();
        }
        while(M-->0) {
            int u = scanner.nextInt()-1;
            int v = scanner.nextInt()-1;
            graph[v].add(u);
        }
        int[] cnts = new int[N];
        for(int edge: graph[q[N-1]]) {
            cnts[edge]++;
        }
        int ans = 0;
        int rem = 0;
        for(int i = N-2; i >= 0; i--) {
            int tot = N-1-i-rem;
            if (cnts[q[i]] == tot) {
                rem++;
                ans++;
            }
            else {
                for(int edge : graph[q[i]]) cnts[edge]++;
            }
        }
        out.println(ans);
        out.flush();
    }
    
    public static class DSU {
        int[] parent, rank;
        int size, nSets;
        public DSU(int ss) {
            size =ss;
            nSets = ss;
            parent = new int[ss];
            rank = new int[ss];
            for(int i = 0; i < ss; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int t) {
            int prev = t;
            while(parent[t] != t) t =parent[t];
            compress(prev, t);
            return t;
        }
        public void compress(int s, int t) {
            while(parent[s] != t) {
                int temp = parent[s];
                parent[s] = t;
                s = temp;
            }
        }
        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if(pa == pb) return false;
            nSets--;
            if (rank[pa] <= rank[pb]) {
                rank[pb] += rank[pa];
                parent[pa] = pb;
            }
            else {
                rank[pa] += rank[pb];
                parent[pb] = pa;
            }
            return true;
        }
    }
    
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        
        public FastScanner() {
            this(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }
    }
}
