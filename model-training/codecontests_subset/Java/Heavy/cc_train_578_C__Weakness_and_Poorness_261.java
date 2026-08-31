import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    int N;
    int[] a;
    void run(FastScanner in, PrintWriter out) {

        N = in.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) a[i] = in.nextInt();

        double lo = -10001;
        double hi = 10001;
        double eps = 1e-12;

        while (hi-lo > eps) {

            double m1 = lo + (hi-lo)/3;
            double m2 = hi - (hi-lo)/3;

            double c1 = f(m1);
            double c2 = f(m2);
            if (Math.abs(c1-c2) < eps) {
                lo = m1;
                hi = m2;
            } else if (c1 < c2) {
                hi = m2;
            } else {
                lo = m1;
            }
        }
        out.println(String.format("%.7f", f(lo)));
    }

    double f(double x) {

        double p1 = 0, p2 = 0;
        double max1 = 0, max2 = 0;
        for (int i = 0; i < N; i++) {
            p1 += a[i]-x;
            if (p1 < 0) p1 = 0;
            max1 = Math.max(max1, p1);

            p2 += -(a[i]-x);
            if (p2 < 0) p2 = 0;
            max2 = Math.max(max2, p2);
        }
        return Math.max(max1, max2);
    }



    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
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
    }
}
