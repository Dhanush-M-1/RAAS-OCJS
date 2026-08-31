import java.util.*;
import java.io.*;

public class B475 {
    static ArrayList<Integer> [] adj;
    static boolean [][] dp;
    static boolean ok;
    static ArrayList<Integer> ans;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            if (a != 0) {
                adj[a].add(i);
                adj[i].add(a);
            }
        }
        // 0 means not connected to parent, 1 means connected to parent
        dp = new boolean[n + 1][2];
        ok = true;
        ans = new ArrayList<>();
        dfs(1, -1);
        if (!ok || !dp[1][0]) {
            out.println("NO");
        } else {
            dfs2(1, -1, 0);
            out.println("YES");
            for (Integer i: ans) out.println(i);
        }
        out.close();
    }

    static void dfs(int cur, int par) {
        ArrayList<Integer> before = new ArrayList<>();
        ArrayList<Integer> after = new ArrayList<>();
        ArrayList<Integer> both = new ArrayList<>();
        for (Integer next: adj[cur]) {
            if (next != par) {
                dfs(next, cur);
                if (dp[next][0] && dp[next][1]) both.add(next);
                else if (dp[next][0]) after.add(next);
                else if (dp[next][1]) before.add(next);
                else {
                    ok = false;
                    break;
                }
            }
        }
        if (!ok) return;
        for (int i = 0; i < 2; i++) {
            int deg = adj[cur].size();
            if (i == 0 && cur != 1) --deg;
            int parityBefore = deg % 2;
            int curBefore = before.size();
            if (both.size() > 0) dp[cur][i] = true;
            else {
                dp[cur][i] = parityBefore == curBefore % 2;
            }
        }
    }

    static void dfs2(int cur, int par, int state) {
        ArrayList<Integer> before = new ArrayList<>();
        ArrayList<Integer> after = new ArrayList<>();
        ArrayList<Integer> both = new ArrayList<>();
        for (Integer next: adj[cur]) {
            if (next != par) {
                if (dp[next][0] && dp[next][1]) both.add(next);
                else if (dp[next][0]) after.add(next);
                else if (dp[next][1]) before.add(next);
            }
        }
        int curDeg = adj[cur].size();
        if (state == 0 && cur != 1) curDeg--;
        int parityBefore = curDeg % 2;
        for (Integer i: before) {
            dfs2(i, cur, 1);
        }
        boolean firstTaken = false;
        if (parityBefore != before.size() % 2) {
            dfs2(both.get(0), cur, 1);
            firstTaken = true;
        }
        ans.add(cur);
        for (int i = 0; i < both.size(); i++) {
            if (i == 0 && firstTaken) continue;
            dfs2(both.get(i), cur, 0);
        }
        for (Integer i: after) {
            dfs2(i, cur, 0);
        }
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
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