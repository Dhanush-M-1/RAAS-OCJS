//package Contest572;
//package ... ctrl+alt+l //выравнять код


import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class mainD1 {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);

    public static void main(String[] args) throws IOException {
        int n=enter.nextInt();
        Graph g=new Graph(n);
        int[] mass1=new int[n];
        int[] mass2=new int[n];
        for (int i = 0; i <n-1 ; i++) {
            mass1[i]=enter.nextInt();
            mass2[i]=enter.nextInt();
            g.addEdge(mass1[i],mass2[i]);
            g.addEdge(mass2[i],mass1[i]);
        }
        if(n==2){
            out.println("YES");
            out.close();
            return;
        }
        for (int i = 0; i <n-1 ; i++) {
            int a=g.adj[mass1[i]].size();
            int b=g.adj[mass2[i]].size();
            if(a==2 || b==2){
                out.println("NO");
                out.close();
                return;
            }
        }
        out.println("YES");
        out.close();



    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }


    static class Graph{

        private int n;   // No. of vertices
        private int m;
        private LinkedList<Integer> adj[]; //Adjacency Lists
        boolean visited[];
        int[] color;

        // Constructor
        Graph(int v)
        {
            n = v;
            adj = new LinkedList[v+1];
            for (int i=1; i<v+1; ++i) adj[i] = new LinkedList();
            visited= new boolean[n+1];
            color= new int[n+1];
        }

        public Graph(int n, int m) {
            this.n = n;
            this.m = m;
            adj = new LinkedList[n+1];
            for (int i=1; i<n+1; ++i) adj[i] = new LinkedList();
            visited= new boolean[n+1];
            color= new int[n+1];
        }

        void addEdge(int v, int w)
        {
            adj[v].add(w);
        }

        void sout_tree(){
            for (int i = 1; i <=n ; i++) {
                System.out.print(i +" ");
                System.out.println(adj[i]);
            }
        }

    }

}

