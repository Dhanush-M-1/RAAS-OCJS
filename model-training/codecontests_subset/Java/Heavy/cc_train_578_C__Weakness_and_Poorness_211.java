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
        double[]a = new double[n+1];
        double left = -1e6, right = 1e6;
        for (int i = 1; i <= n; i++) {
            a[i] = nextInt();
        }
        for (int it = 1; it <= 100; it++) {
            double m1 = left+(right-left) / 3;
            double m2 = right-(right-left) / 3;
            double f1 = calc(a, n, m1), f2 = calc(a, n, m2);
            if (f1 > f2)
                left = m1;
            else
                right = m2;
        }
        System.out.println(calc(a, n, left));
        pw.close();
    }

    private static double calc(double[] a, int n, double x) {
         double max = 0, min = 0, sum = 0, ans = -1e18;
         for (int i = 1; i <= n; i++) {
            sum += a[i] - x;
            ans = Math.max(ans, Math.abs(sum-min));
            ans = Math.max(ans, Math.abs(sum-max));
            min = Math.min(min, sum);
            max = Math.max(max, sum);
         }
         return ans;
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