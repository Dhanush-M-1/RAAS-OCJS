import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class CF1037_E {
    public static void main(String[] args) throws Throwable {
        MyScanner sc = new MyScanner();
        PrintWriter pw = new PrintWriter(System.out);

        n = sc.nextInt();
        adj = new HashSet[n];
        for (int i = 0; i < n; i++)
            adj[i] = new HashSet<>();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] deg = new int[n];
        int[] ans = new int[m];
        int[] x = new int[m];
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt() - 1;
            y[i] = sc.nextInt() - 1;
            adj[x[i]].add(y[i]);
            adj[y[i]].add(x[i]);
            deg[x[i]]++;
            deg[y[i]]++;
        }
        int cnt = n;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (deg[i] < k)
                q.add(i);
        while (!q.isEmpty()) {
            cnt--;
            int u = q.poll();
            for (int v : adj[u]) {
                deg[v]--;
                if (deg[v] == k - 1)
                    q.add(v);
                adj[v].remove(u);
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            ans[i] = cnt;
            if (deg[x[i]] < k || deg[y[i]] < k)
                continue;
            adj[y[i]].remove(x[i]);
            adj[x[i]].remove(y[i]);
            deg[x[i]]--;
            deg[y[i]]--;
            q.clear();
            if (deg[x[i]] == k - 1)
                q.add(x[i]);
            if (deg[y[i]] == k - 1)
                q.add(y[i]);
            while (!q.isEmpty()) {
                cnt--;
                int u = q.poll();
                for (int v : adj[u]) {
                    deg[v]--;
                    if (deg[v] == k - 1)
                        q.add(v);
                    adj[v].remove(u);
                }
            }
        }

        for (int i = 0; i < m; i++)
            pw.println(ans[i]);

        pw.flush();
        pw.close();
    }

    static int n;
    static HashSet<Integer>[] adj;

    static class MyScanner {
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
