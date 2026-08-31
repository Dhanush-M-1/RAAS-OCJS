import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Solution {
    boolean eof;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new Solution().run();
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
        String name = "a";
        try {
            File f = new File(name + ".in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new PrintStream(name + ".out");
            }
        } catch (Throwable e) {
        }
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }


    void solve() {
        int n = nextInt(), m = nextInt(), k = nextInt();
        ArrayList<Integer>[] ed = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            ed[i] = new ArrayList<>();
        }
        int[] edU = new int[m], edV = new int[m];
        int[] frc = new int[n];
        int[] eds = new int[n];
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            edU[i] = nextInt() - 1;
            edV[i] = nextInt() - 1;
            frc[edU[i]]++;
            frc[edV[i]]++;
            ed[edU[i]].add(edV[i]);
            ed[edV[i]].add(edU[i]);
            eds[edU[i]]++;
            eds[edV[i]]++;
        }
        int cur = n;
        Queue<Integer> low = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (frc[i] < k) {
                low.add(i);
                frc[i] = 0;
            }
        }
        int u, v;
        for (int i = 0; i < m; i++) {
            while (!low.isEmpty()) {
                u= low.poll();
                cur--;
                for (int j = 0; j < eds[u]; j++) {
                    v = ed[u].get(j);
                    frc[v]--;
                    if (frc[v] == k - 1) {
                        low.add(v);
                    }
                }
            }
            ans[m - i - 1] = cur;
            u = edU[m - i - 1];
            v = edV[m - i - 1];
            eds[u]--;
            eds[v]--;
            boolean nu1 = frc[u] >= k;
            if (frc[v] >= k) {
                frc[u]--;
                if (frc[u] == k - 1)
                    low.add(u);
            }
            if (nu1) {
                frc[v]--;
                if (frc[v] == k - 1)
                    low.add(v);
            }
        }
        for (int i = 0; i < m; i++) {
            out.println(ans[i]);
        }
    }

}

















