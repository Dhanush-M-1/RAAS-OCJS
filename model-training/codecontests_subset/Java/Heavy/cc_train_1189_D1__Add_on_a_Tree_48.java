import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    void solve() {
       int n=ni();
       g=new ArrayList[n+1];
       for(int i=1;i<=n;i++) g[i]=new ArrayList<>();
       int deg[]=new int[n+1];
       for(int i=1;i<n;i++){
           int u=ni(),v=ni();
           deg[u]++;
           deg[v]++;
           g[u].add(v); g[v].add(u);
       }
       if(n==2){
           pw.println("YES");
           return;
       }
       int root=-1;
       for(int i=1;i<=n;i++) if(deg[i]!=1) root=i;
       dfs(root,-1);
       pw.println(ans==1?"YES":"NO");


    }
    ArrayList<Integer> g[];
    int ans=1;
    void dfs(int v,int pr){

        for(int u : g[v]){
            if(u!=pr){
                dfs(u,v);
                if(g[u].size()!=2 && g[v].size()>2){

                }else {
                    ans=0;
                }
            }
        }
    }

    long M = (long)1e9+7;
    // END
    PrintWriter pw;
    StringTokenizer st;
    BufferedReader br;

    void run() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
    }
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    String ns() {
        while (st == null || !st.hasMoreElements()) {

            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }

    int ni() {
        return Integer.parseInt(ns());
    }

    long nl() {
        return Long.parseLong(ns());
    }

    double nd() {
        return Double.parseDouble(ns());
    }
}