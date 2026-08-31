import java.io.*;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    long mod = 1000000000+7;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int t = 1;
        while(t-->0){
            out.println(main.solve());
        }
//        main.solve();
//        out.println(main.solve());
        out.flush();
    }
    long solve() throws IOException {
        String[] buf = reader.readLine().split(" ");
        int n = paIn(buf[0]), m = paIn(buf[1]), k = paIn(buf[2]);
        boolean[] block = new boolean[n];
        buf = reader.readLine().split(" ");
        for(int i=0; i<m; i++){
            int s = paIn(buf[i]);
            block[s] = true;
        }
        if(block[0]) return -1;
        long[] cost = new long[k+1];
        buf = reader.readLine().split(" ");
        for(int i=1; i<=k; i++){
            cost[i] = paIn(buf[i-1]);
        }
        // dp[i] = j: the largest index i0 s.t. block[i0] = false && i0 <= i is j
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            if(!block[i]) dp[i] = i;
            else{
                dp[i] = dp[i-1];
            }
        }
        long inf = Long.MAX_VALUE>>2;
        long ans = inf, minCost = inf;
        for(int i=k; i>0; i--){
            long c = cost[i];
            if(c>minCost) continue;
            long res = cost[i];
            int idx = 0; // the position idx is always reachable
            while(idx<n){
                int next = idx+i;
                if(next>=n) break;
                int pos = dp[next];
                if(pos<=idx){
                    res = -1;
                    break;
                } else{
                    idx = pos;
                    res += c;
                }
            }
            if(res>=0){
                ans = Math.min(ans,res);
                minCost = Math.min(minCost, c);
            }
        }
        if(ans>=inf) return -1;
        else return ans;
    }
    int paIn(String s){return Integer.parseInt(s);}
}