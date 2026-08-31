import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A {

    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        int m = nextInt();
        int[]delta = new int[n+1], a = new int[n+1];
        Arrays.fill(a, (int) 1e8);
        int[]t = new int[m+1], L = new int[m+1], R = new int[m+1], x = new int[m+1];
        for (int i = 1; i <= m; i++) {
            t[i] = nextInt();
            L[i] = nextInt();
            R[i] = nextInt();
            x[i] = nextInt();
            if (t[i]==1) {
                for (int j = L[i]; j <= R[i]; j++) {
                    delta[j] += x[i];
                }
            }
            else {
                for (int j = L[i]; j <= R[i]; j++) {
                    a[j] = Math.min(a[j], x[i]-delta[j]);
                }
            }
        }
        Arrays.fill(delta, 0);
        for (int i = 1; i <= m; i++) {
            if (t[i]==1) {
                for (int j = L[i]; j <= R[i]; j++) {
                    delta[j] += x[i];
                }
            }
            else {
                int max = (int) -1e9;
                for (int j = L[i]; j <= R[i]; j++) {
                    max = Math.max(max, a[j]+delta[j]);
                }
                if (max != x[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        pw.println("YES");
        for (int i = 1; i <= n; i++) {
            pw.print(a[i]+" ");
        }
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
