import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bottles {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Bottles task = new Bottles();
        task.open();
        task.solve();
        task.close();
    }

    private void close() {
        out.flush();
        out.close();
    }

    private void solve() throws IOException {
        int n = nextInt();
        int[]a = new int[n+1], b = new int[n+1];
        int s1 = 0, s2 = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
            s1 += a[i];
        }
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            b[i] = nextInt();
            s2 += b[i];
            L.add(b[i]);
        }
        Collections.sort(L);
        int sum = 0, k = 0;
        for (int i = L.size()-1; i >= 0; i--) {
            sum += L.get(i);
            k++;
            if (sum >= s1) {
                break;
            }
        }
        int s = s2-s1+1;
        k = n - k;
        int[][]dp = new int[s+1][k+1];
        int INF = (int) 1e9;
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = s; j >= 0; j--) {
                for (int j2 = 0; j2 <= k; j2++) {
                    if (j >= b[i] && j2 > 0) {
                        dp[j][j2] = Math.min(dp[j][j2], dp[j-b[i]][j2-1] + a[i]);
                    }
                }
            }
        }
        int t = INF;
        for (int i = 0; i <= s2-s1; i++) {
            t = Math.min(t, dp[i][k]);
        }
        k = n-k;
       out.println(k+" "+t);


    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
}
