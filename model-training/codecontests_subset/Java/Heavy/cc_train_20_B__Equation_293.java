import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("1"));
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        solve();

        in.close();
        out.close();
    }

    private static void solve() throws Exception {
        double A = nextDouble(), B = nextDouble(), C = nextDouble();
        if (eq(A, 0.0)) {
            if (eq(B, 0.0)) {
                if (eq(C, 0.0)) {
                    out.println("-1");
                } else {
                    out.println("0");
                }
                return;
            } else {
                double x = -C / B;
                out.println("1");
                out.format(Locale.US, "%.10f", x);
                return;
            }
        } else {
            double D = B * B - 4.0 * A * C;
            if (eq(D, 0.0)) {
                out.println("1");
                double x = -B / (2.0 * A);
                out.format(Locale.US, "%.10f", x);
                return;
            } else if (D > 0.0) {
                out.println("2");
                double x1 = (-B + Math.sqrt(D)) / (2.0 * A);
                double x2 = (-B - Math.sqrt(D)) / (2.0 * A);
                out.format(Locale.US, "%.10f\n%.10f", Math.min(x1, x2), Math.max(x1, x2));
                return;
            } else {
                out.println("0");
            }
        }
    }

    private static boolean eq(double a, double d) {
        return Math.abs(a - d) < 1.0E-8;
    }

    static StringTokenizer st;
    static BufferedReader in;
    static PrintWriter out;

    static int nextInt() throws IOException {
        return Integer.parseInt(nextString());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextString());
    }

    static String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
