import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by timur on 28.03.15.
 */

public class TaskF {
    boolean eof;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new TaskF().run();
    }

    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "-1";
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }


    void run() throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        try {
            File f = new File("a.in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new PrintStream("a.out");
            }
        } catch (Throwable e) {
        }
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }

    int[] p;
    int[] ans1;
    int[] d;

    int[] ans2;
    ArrayList<Integer>[] s;


    void relax(int u) {
        if (s[u].size() == 0) {
            ans1[u] = 1;
            ans2[u] = 1;
            d[u] = 0;
            return;
        }
        int v;
        int mh = k, ca = 0;
        for (int i = 0; i < s[u].size(); i++) {
            v = s[u].get(i);
            if (d[v] < k) {
                ca += ans1[v];
            }
            mh = Math.min(mh, d[v]);
        }
        if (mh < k - 1) {
            ans1[u] = ca;
        }
        d[u] = mh + 1;
        for (int i = 0; i < s[u].size(); i++) {
            v = s[u].get(i);
            if (d[v] < k) {
                ans2[u] = Math.max(ans2[u], ca - ans1[v] + ans2[v]);
            } else {
                ans2[u] = Math.max(ans2[u], ca + ans2[v]);
            }
        }

        ans2[u] = Math.max(ans2[u], ans1[u]);
    }

    void dfs(int u) {
        if (s[u].size() == 0) {
            ans1[u] = 1;
            ans2[u] = 1;
            d[u] = 0;
            return;
        }
        for (int i = 0; i < s[u].size(); i++) {
            dfs(s[u].get(i));
        }
        relax(u);
    }

    int n, k;

    void solve() {
        n = nextInt();
        k = nextInt();
        p = new int[n];
        ans1 = new int[n];
        ans2 = new int[n];
        d = new int[n];
        s = new ArrayList[n];
        int v;
        int[] sc = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            v = nextInt() - 1;
            //v = i - 1;
            p[i] = v;
            s[v].add(i);
            sc[v]++;
        }
//        dfs(0);

        Queue<Integer> leafs = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (sc[i] == 0) {
                leafs.add(i);
            }
        }
        while (!leafs.isEmpty()) {
            int u = leafs.poll();
            relax(u);
            u = p[u];
            sc[u]--;
            if (sc[u] == 0) {
                leafs.add(u);
            }
        }
        int ans = 0;
        for (int i = 0; i < 1; i++) {
            ans = Math.max(ans, ans1[i]);
            ans = Math.max(ans, ans2[i]);
        }
        out.print(ans);
    }
}