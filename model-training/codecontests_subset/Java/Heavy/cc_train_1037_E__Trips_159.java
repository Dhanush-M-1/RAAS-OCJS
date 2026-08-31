import java.util.*;
import java.io.*;
import java.math.*;
 
public class G {
    public static void main(String[] args) throws IOException {
        //PrintWriter out = new PrintWriter(new File("out.txt"));
        PrintWriter out = new PrintWriter(System.out);
        //Reader in = new Reader(new FileInputStream("in.txt"));
        Reader in = new Reader();
        G solver = new G();
        solver.solve(out, in);
        out.flush();
        out.close();
 
    }
 
 
 
    static int maxn = (int)1e4+5;
    static long mod=(int)1e9+7;
    static int n, m, t, k;

    static ArrayList<Edge> adj[];
    static boolean[] vis;
    static int[] lvl;

    void solve(PrintWriter out, Reader in) throws IOException{
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        
        lvl = new int[n+1];
        vis = new boolean[n+1];
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<Edge>();
        
        int[][] edge = new int[m][2];
        int u,v;
        for (int i = 0; i < m; i++) {
            u = in.nextInt();
            v = in.nextInt();
            
            edge[i][0] = u;
            edge[i][1] = v;
            lvl[u]++; lvl[v]++;
            adj[u].add(new Edge(v, i));
            adj[v].add(new Edge(u, i));
        }
        TreeSet<Node> pq = new TreeSet<>();
        
        for (int i = 1; i <= n; i++)
            pq.add(new Node(lvl[i], i));
        
        Node elm;
        int[] ans = new int[m];
        for (int i = m-1; i >= 0; i--) {
            while (pq.size()!= 0 && pq.first().lvl < k) {
                elm = pq.pollFirst();
                vis[elm.id] = true;
                for (Edge e:adj[elm.id]) {
                    if (!vis[e.to] && e.id <= i) {
                        pq.remove(new Node(lvl[e.to], e.to));
                        lvl[e.to]--;
                        pq.add(   new Node(lvl[e.to], e.to));
                    }
                }
            }
            
            u = edge[i][0]; v = edge[i][1];
            if (!vis[u] && !vis[v]) {
                pq.remove(new Node(lvl[u], u));
                lvl[u]--;
                pq.add(new Node(lvl[u], u));
                
                pq.remove(new Node(lvl[v], v));
                lvl[v]--;
                pq.add(new Node(lvl[v], v));
            }
            ans[i] = pq.size();
        }
        
        for (int i = 0; i < m; i++) {
            out.println(ans[i]);
        }
        
        
    }
 
    //<>
    
    static class Node implements Comparable<Node> {
        int lvl, id;
        
        Node (int lvl, int id) {
            this.lvl = lvl;
            this.id  = id;
        }
        
        public int compareTo(Node o) {
            if (this.lvl != o.lvl) return this.lvl - o.lvl;
            return this.id - o.id;
        }
    }
    
    static class Edge {
        int to, id;
        
        Edge(int to, int id) {
            this.to = to;
            this.id = id;
        }
    }
    
    static class Reader {
 
        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
    
        public Reader() {
            this(System.in);
        }
    
        public Reader(InputStream is) {
            mIs = is;
        }
    
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
    
        }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
    
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
    
        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
    
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
    
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
    
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
    
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    
        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
    }
}