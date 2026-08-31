import java.io.*;
import java.util.*;
import java.math.*;
 
 
public class Main {
    static final long MOD = 1000000007L;
    //static final long MOD2 = 1000000009L;
    //static final long MOD = 998244353L;
    //static final long INF = 500000000000L;
    static final int INF = 10000000;
    static final int NINF = -100000;
    
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        
        int N = sc.ni();
        int M = sc.ni();
        int[][] input = new int[N][];
        for (int i = 0; i < N; i++) {
            int K = sc.ni();
            input[i] = new int[K];
            for (int j = 0; j < K; j++)
                input[i][j] = sc.ni()-1;
        }
        int[] state = new int[M]; //0 is unvisited, 1 is in dsu, 2 is fixed
        ArrayList<Integer> inc = new ArrayList<Integer>();
        DisjointSetUnion dsu = new DisjointSetUnion(M);
        for (int i = 0; i < N; i++) {
            if (input[i].length == 1) {
                int a = input[i][0];
                if (state[a]==1) {
                    for (int v: dsu.set[dsu.root(a)]) {
                        state[v] = 2;
                    }
                    inc.add(i);
                } else if (state[a]==0) {
                    state[a] = 2;
                    inc.add(i);
                }
            } else {
                int a = input[i][0];
                int b = input[i][1];
                if (state[a]+state[b]==4) {
                    continue;
                } else if (state[a]+state[b]==3) {
                    ArrayList<Integer> arr = dsu.set[dsu.root(a)];
                    if (state[b]==1)
                        arr = dsu.set[dsu.root(b)];
                    for (int v: arr) {
                        state[v] = 2;
                    }
                    inc.add(i);
                } else if (state[a]==state[b] || state[a]+state[b]==1) {
                    if (dsu.root(a) != dsu.root(b)) {
                        state[a] = 1;
                        state[b] = 1;
                        dsu.connect(a,b);
                        inc.add(i);
                    }
                } else {
                    state[a] = 2;
                    state[b] = 2;
                    inc.add(i);
                }
            }
        }
        long T = 1L;
        for (int i = 0; i < inc.size(); i++) {
            T = (2*T)%MOD;
        }
        pw.println(T + " " + inc.size());
        for (int a: inc) {
            pw.print((a+1) + " ");
        }
        pw.close();
    }
    
    static class DisjointSetUnion {
        public int[] parent;
        public ArrayList<Integer>[] set;
        public int count;
        
        public DisjointSetUnion(int N) {
            count = N;
            parent = new int[N];
            for (int i = 0; i < N; i++)
                parent[i] = i;
            set = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                set[i] = new ArrayList<Integer>();
                set[i].add(i);
            }
        }
        
        //"find"
        public int root(int p) {
            if (p == parent[p])
                return p;
            return parent[p] = root(parent[p]);
        }
        
        //"union"
        public void connect(int p, int q) {
            p = root(p);
            q = root(q);
            if (p==q)
                return;
            if (set[p].size() < set[q].size()) {
                parent[p] = q;
                set[q].addAll(set[p]);
                set[p].clear();
            } else {
                parent[q] = p;
                set[p].addAll(set[q]);
                set[q].clear();
            }
            count--;
        }
        
        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }
    }
    
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner() {
          br = new BufferedReader(new InputStreamReader(System.in));
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
        
        int ni() {
            return Integer.parseInt(next());
        }
        
        long nl() {
            return Long.parseLong(next());
        }
        
        double nd() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}