//package contests.CF1012;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {

    static ArrayList<Integer>[] adj;
    static int n, R, C;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        R = sc.nextInt();
        C = sc.nextInt();

        n = R+C;
        int[] cnt = new int[n];

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1+R;
            cnt[r]++;
            cnt[c]++;
            adj[r].add(c);
            adj[c].add(r);
        }

        vis = new boolean[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if(!vis[i])
            {
                dfs(i);
                ans++;
            }
        }

        System.out.println(ans);

        pw.flush();
        pw.close();
    }

    static boolean vis[];
    static int dfs(int u){
        vis[u] = true;
        int ans = 1;
        for (int v: adj[u]) {
            if(!vis[v])
                ans += dfs(v);
        }
        return ans;
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
