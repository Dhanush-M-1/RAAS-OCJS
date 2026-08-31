import java.util.*;
import java.io.*;

public class C {
    FastScanner in;
    PrintWriter out;

    double weakness(double[] a, double x) {
        double max = a[0] - x, min = a[0] - x, maxR = a[0] - x,  minR = a[0] - x;
        for (int i = 1; i < a.length; i++) {
            double cur = a[i] - x;
            max = Math.max(Math.max(max, maxR + cur), cur);
            min = Math.min(Math.min(min, minR + cur), cur);
            maxR = Math.max(maxR + cur, cur);
            minR = Math.min(minR + cur, cur);
        }
        min = Math.abs(min);
        max = Math.abs(max);
        return Math.max(min, max);
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        double[] a = new double[n];
        Arrays.setAll(a, i -> in.nextInt());
        double l = -1_000_000;
        double r = 1_000_000;
        for (int i = 0; i < 100; i++) {
            double m1 = l + (r - l) / 3;
            double m2 = l + (r - l) / 3 * 2;
            if (weakness(a, m1) < weakness(a, m2)) {
                r = m2;
            } else {
                l = m1;
            }
        }
        out.println(/*(l + r) / 2+ " " + */weakness(a, (l + r) / 2));
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            Locale.setDefault(Locale.US);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }

    public static void main(String[] arg) {
        new C().run();
    }
}