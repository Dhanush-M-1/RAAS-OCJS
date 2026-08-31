/*
[ ( ^ _ ^ ) ]
*/

import java.io.*;
import java.util.*;


public class test {
    int INF = (int)1e9;
    long MOD = 1000000007;

    long mk(long x, long y) {
        return x * 1000_000_0000l + y;
    }

    void solve(InputReader in, PrintWriter out) throws IOException {
        int x0 = in.nextInt();
        int y0 = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int n = in.nextInt();
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1},
                                {1, -1}, {1, 0}, {1, 1}};
        HashMap<Long, Integer> mp = new HashMap<>();
        ArrayList<HashSet<Integer>> g = new ArrayList<>();
        int keyId = 0;
        for(int i=0; i<n; i++) {
            int ri = in.nextInt();
            int ai = in.nextInt();
            int bi = in.nextInt();
            for(int j=ai; j<=bi; j++) {
                long k = mk(ri, j);
                if(!mp.containsKey(k)) {
                    mp.put(k, keyId++);
                    g.add(new HashSet<Integer>());
                }
                int u = mp.get(k);
                for(int[] d: dir) {
                    long x = mk(ri+d[0], j+d[1]);
                    if(mp.containsKey(x)) {
                        int v = mp.get(x);
                        g.get(u).add(v);
                        g.get(v).add(u);
                    }
                }
            }
        }
        // show("-------------");
        // int ct = 0;
        // for(HashSet<Integer> x: g) {
        //     show(ct++, x);
        // }
        // show("");
        // show(mp);
        n = g.size();
        int[] lvl = new int[n];
        Arrays.fill(lvl, -1);
        boolean[] vis = new boolean[n];
        int s = mp.get(mk(x0, y0));
        int f = mp.get(mk(x1, y1));
        Queue<Integer> q = new LinkedList<Integer>();
        vis[s] = true;
        lvl[s] = 0;
        q.add(s);
        bfs: while(q.size()>0) {
            int v = q.remove();
            for(int u: g.get(v)) {
                if(!vis[u]) {
                    lvl[u] = lvl[v]+1;
                    vis[u] = true;
                    q.add(u);
                    if(u==f) break bfs;
                }
            }
        }
        out.println(lvl[f]);
    }
    

    public static void main(String[] args) throws IOException {
        if(args.length>0 && args[0].equalsIgnoreCase("d")) {
            DEBUG_FLAG = true;
        }
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;//in.nextInt();
        long start = System.nanoTime();
        while(t-- >0) {
            new test().solve(in, out);
        }
        long end = System.nanoTime();
        debug("\nTime: " + (end-start)/1e6 + " \n\n");
        out.close();
    }
    
    static boolean DEBUG_FLAG = false;
    static void debug(String s) {
        if(DEBUG_FLAG) System.out.print(s);
    }
    
    public static void show(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    static class InputReader {
        static BufferedReader br;
        static StringTokenizer st;
    
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }
}