import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class C {

    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int m = nextInt();
        int[]w = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = nextInt();
        }
        long ans = 0;
        int[]p = new int[n+1];
        int last = 1;
        for (int i = 1; i <= m; i++) {
            int k = nextInt();
            int ind = 0;
            for (int j = 1; j < last; j++) {
                if (p[j]==k) {
                    ind = j;
                    break;
                }
            }
            if (ind==0) {
                for (int j = 1; j < last; j++) {
                    ans += w[p[j]];
                }
                for (int j = last; j >= 2; j--) {
                    p[j] = p[j-1];
                }
                p[1] = k;
                last++;
            }
            else {
                for (int j = 1; j < ind; j++) {
                    ans += w[p[j]];
                }
                for (int j = ind; j >= 2; j--) {
                    p[j] = p[j-1];
                }
                p[1] = k;
            }
        }
        System.out.println(ans);
        pw.close();
    }
    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    private static String next() throws IOException {
        while (st==null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}
