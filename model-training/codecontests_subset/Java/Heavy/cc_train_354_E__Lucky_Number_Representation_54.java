import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();       
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");

    private void run() throws IOException {
        if (new File("input.txt").exists())
            in = new BufferedReader(new FileReader("input.txt"));
        else
            in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }
    
    final int MAX = 30;

    private void solve() throws IOException {
        
        long ten[] = new long[19];
        ten[0] = 1;
        for (int i = 1; i < 19; i++)
            ten[i] = ten[i - 1] * 10;
        int cnt = 0;
        int sev[] = new int[MAX];
        int fou[] = new int[MAX];
        int sum[] = new int[MAX];
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 7 - i; j++) {
                sev[cnt] = i;
                fou[cnt] = j;
                sum[cnt++] = i * 7 + j * 4;
            }
        int c[] = new int[20];
        long ans[] = {0, 0, 0, 0, 0, 0};
        int prev[][] = new int[20][8];
        int s[][] = new int[20][MAX];
        int T = nextInt();
        for (int t = 0; t < T; t++) {
            long n = nextLong();
            long m = n;
            int l = 0;
            while (m > 0) {
                c[l++] = (int)(m % 10);
                m /= 10;
            }
            c[l] = 0;
            for (int i = 0; i < 20; i++)
                fill(prev[i], -1);
            for (int i = 0; i < 20; i++)
                fill(s[i], -1);
            s[0][0] = 0;
            prev[0][0] = 0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < 8; j++)
                    if (prev[i][j] > -1) {
                        for (int k = 0; k < cnt; k++) {
                            if ((j + sum[k]) % 10 == c[i]) {
                                prev[i + 1][(j + sum[k]) / 10] = k;
                                s[i + 1][k] = j;
                            }
                        }
                    }
            }
            if (prev[l][0] == -1) {
                out.println(-1);
            }
            else {
                fill(ans, 0);
                int cur = 0;
                int cn = 0;
                for (int i = l; i > 0; i--) {
                    int ms = prev[i][cur];
                    cur = s[i][ms];
                    cn = 0;
                    for (int j = 0; j < sev[ms]; j++)
                        ans[cn++] += ten[i - 1] * 7;
                    for (int j = 0; j < fou[ms]; j++)
                        ans[cn++] += ten[i - 1] * 4;
                }
                for (int i = 0; i < 6; i++)
                    out.print(ans[i] + " ");
                out.println();
            }
        }
        
        
    }
    
    void chk(boolean b) {
        if (b)
            return;
        System.out.println(new Error().getStackTrace()[1]);
        exit(999);
    }
    void deb(String fmt, Object... args) {
        System.out.printf(Locale.US, fmt + "%n", args);
    }
    String nextToken() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    String nextLine() throws IOException {
        st = new StringTokenizer("");
        return in.readLine();
    }
    boolean EOF() throws IOException {
        while (!st.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null)
                return true;
            st = new StringTokenizer(s);
        }
        return false;
    }
}
