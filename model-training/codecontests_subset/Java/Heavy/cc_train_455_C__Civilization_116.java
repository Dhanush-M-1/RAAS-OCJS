

    import java.io.*;
    import java.util.*;
    /**
     *
     * @author hartha
     */
    public class JavaApplication2 {

        /**
         * @param args the command line arguments
         */
        static ArrayList<Integer> g[] ;
        static Union_find dsu;
        static int v[], id;
        
        public static void main(String[] args) throws IOException {
            Reader.init(System.in);
            PrintWriter writer = new PrintWriter(System.out);
            
            int n = Reader.nextInt();
            int m = Reader.nextInt();
            int q = Reader.nextInt();
            
            Queue<Integer> queue = new LinkedList<>();
            g = new ArrayList[n+1];
            v = new int[n+1];
            
            for (int i = 0; i < n+1; i++) {
                g[i] = new ArrayList();
            }
            
            
            dsu = new Union_find(n+1);
            
            for (int i = 0; i < m; i++) {
                int x = Reader.nextInt();
                int y = Reader.nextInt();
                
                g[x].add(y);
                g[y].add(x);
            }
            
            for (int i = 1; i < n+1; i++) {
                if(v[i] == 0){
                    max = -1;
                    id++;
                    DFS(i, 0, true, i);
                    id++;
                    DFS(node, 0, false, -1);
                    dsu.longestPath[i] = max;
                    dsu.rank[i] = max;
                }
            }
            
            for (int i = 0; i < q; i++) {
                int t = Reader.nextInt();
                
                if(t == 1){
                    int x = Reader.nextInt();
                    writer.println(dsu.getLPath(x));
                } else {
                    int x = Reader.nextInt();
                    int y = Reader.nextInt();
                    
                    dsu.union(x, y);
                }
            }
            
            writer.flush();
        }

        static int node, max;
        static void DFS(int cur, int depth, boolean b, int p){
            
            v[cur] = id;
            
            if(max < depth){
                max = depth;
                node = cur;
            }
            
            
            for (int i = 0; i < g[cur].size(); i++) {
                if(v[g[cur].get(i)] != id){
                     DFS(g[cur].get(i), depth +1, b, p);
                     if(b)
                        dsu.parent[g[cur].get(i)] = p;
                }
            }
            
            
        }
    }

   
class Union_find{
    public int rank[], parent[], longestPath[];

    public Union_find(int n) {
        rank = new int[n+1];
        parent = new int[n+1];
        longestPath = new int[n+1];
        
        for (int i = 0; i < n+1; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }
        
        
    int find(int cur){
        if(parent[cur] == cur)
            return cur;
        
        return parent[cur] = find(parent[cur]);
    }
    
    private void link(int x, int y){
        if(rank[x] > rank[y]){
            int temp = x;
            x = y;
            y = temp;
        }
        
        
        parent[x] = y;
        if(rank[x] != rank[y])
            rank[y]++;
        
        if(longestPath[x] == 0 && longestPath[y] == 0){
            longestPath[y]++;
        } else {
            longestPath[y] = Math.max((longestPath[x] + 1) / 2 + (longestPath[y] + 1) / 2 + 1, Math.max(longestPath[x], longestPath[y]));
        }
    }
    
    boolean  union(int x, int y){
        x = find(x); y = find(y);
        
        
        if(x != y)
            link(x, y);
        
        return x != y;
    }
    
    int getLPath(int x){
        return longestPath[this.find(x)];
    }
}
    class Pair{
        int x, y, dir;

    public Pair(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
               
        
    }

    class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        public static int pars(String x) {
            int num = 0;
            int i = 0;
            if (x.charAt(0) == '-') {
                i = 1;
            }
            for (; i < x.length(); i++) {
                num = num * 10 + (x.charAt(i) - '0');
            }

            if (x.charAt(0) == '-') {
                return -num;
            }

            return num;
        }

        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static void init(FileReader input) {
            reader = new BufferedReader(input);
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return pars(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }