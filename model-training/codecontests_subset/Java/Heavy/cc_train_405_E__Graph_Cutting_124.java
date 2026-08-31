import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class C {

    static int N, M;
    static ArrayList<Integer> adjList[];
    static boolean[] vis;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(System.out);
        N = sc.nextInt(); M = sc.nextInt();
        if (M % 2 != 0) {
            out.println("No solution"); out.flush(); return;
        }
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) adjList[i] = new ArrayList<>();
        vis = new boolean[N];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(0);
        out.flush();
        out.close();
    }

    static int dfs(int u) {
        vis[u] = true;
        ArrayList<Integer> children = new ArrayList<>();
        for (int v : adjList[u])
            if (!vis[v])
                children.add(v);

        Stack<Integer> wa7edeen = new Stack<>();
        for (int v : children) {
            int wa7eed = dfs(v);
            if (wa7eed != -1)
                out.printf("%d %d %d\n", u + 1, v + 1, wa7eed + 1);
            else
                wa7edeen.push(v);
        }
        while (wa7edeen.size() > 1)
            out.printf("%d %d %d\n", wa7edeen.pop() + 1, u + 1, wa7edeen.pop() + 1);

        return wa7edeen.size() == 1? wa7edeen.pop() : -1;
    }


    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
        public Scanner(String file) throws Exception {br = new BufferedReader(new FileReader(file));}
        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String nextLine()throws IOException{return br.readLine();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public double nextDouble() throws IOException {return Double.parseDouble(next());}
        public char nextChar()throws IOException{return next().charAt(0);}
        public Long nextLong()throws IOException{return Long.parseLong(next());}
        public boolean ready() throws IOException{return br.ready();}
        public void waitForInput() throws InterruptedException {Thread.sleep(3000);}
    }
}
