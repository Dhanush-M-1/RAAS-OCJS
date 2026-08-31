import java.io.*;
import java.util.*;

/**
 * @author def
 * @version 1.0
 */
public class B {

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        if (a == 0 && b == 0) {
            out.println(c == 0 ? -1 : 0);
        } else if (a == 0) {
            double x = -1.0 * c / b;
            out.println(1);
            out.println(new Formatter(Locale.US).format("%.6f", x));
        } else {
            long d = b * b - 4 * a * c;
            if (d > 0) {
                double x1 = (-0.5 * b - 0.5 * Math.sqrt(d)) / a;
                double x2 = (-0.5 * b + 0.5 * Math.sqrt(d)) / a;
                if (x1 > x2) {
                    double t = x1;
                    x1 = x2;
                    x2 = t;
                }
                out.println(2);
                out.println(new Formatter(Locale.US).format("%.6f\n%.6f", x1, x2));
            } else if (d == 0) {
                double x = -0.5 * b / a;
                out.println(1);
                out.println(new Formatter(Locale.US).format("%.6f", x));
            } else {
                out.println(0);
            }
        }

        out.close();
    }

    BufferedReader in;
    PrintWriter out;
}
