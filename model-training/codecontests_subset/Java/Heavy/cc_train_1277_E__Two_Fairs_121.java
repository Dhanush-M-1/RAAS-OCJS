import java.util.*;
import java.io.*;
public class Main {
    static int INF = 1001001009;
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long mod = 1000000000+7;
    Set<Integer>[] graph;
    public static void main(String[] args) throws Exception {
        // Your code here!
        Main main = new Main();
        int t = main.paIn(reader.readLine());
        while(t-->0){
            main.solve();
        }
//        main.solve();
//        long ans = main.solve();
//        out.println(ans);
        out.flush();
    }
    void solve() throws Exception{
        String[] buf = reader.readLine().split(" ");
        int n =paIn(buf[0]), m = paIn(buf[1]), a = paIn(buf[2])-1, b = paIn(buf[3])-1;
        graph = new Set[n];
        for(int i=0; i<n; i++) graph[i] = new HashSet<>();
        for(int i=0; i<m; i++){
            buf = reader.readLine().split(" ");
            int u = paIn(buf[0])-1, v = paIn(buf[1])-1;
            graph[u].add(v); graph[v].add(u);
        }
        boolean[] vis = new boolean[n];
        vis[a] = true;
        long k1 = 0, k2 = 0;
        for(int to:graph[a]){
            if(vis[to]) continue;
            int temp = dfs(to, a, b, vis);
            if(temp>0) k1 += temp;
        }
        Arrays.fill(vis, false);
        vis[b] = true;
        for(int to:graph[b]){
            if(vis[to]) continue;
            int temp = dfs(to, b, a, vis);
            if(temp>0) k2 += temp;
        }
        long ans = k1*k2;
        out.println(ans);
    }
    int dfs(int cur, int from, int target, boolean[] vis){
        if(cur==target) return -1;
        if(vis[cur]) return 0;
        vis[cur] = true;
        int ans = 1;
        for(int to:graph[cur]){
            if(cur==from) continue;
            int temp = dfs(to, cur, target, vis);
            if(temp<0||ans<0) ans = -1;
            else ans += temp;
        }
        return ans;
    }


    int paIn(String s){return Integer.parseInt(s);}
}