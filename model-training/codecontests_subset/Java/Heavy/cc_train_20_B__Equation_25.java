import java.io.*;
import java.util.StringTokenizer;

/**
 * 20B
 * θ(1) time
 * θ(1) space
 *
 * @author artyom
 */
public class _20B implements Runnable {
    private BufferedReader in;
    private StringTokenizer tok;

    private Object solve() throws IOException {
        double a = nextInt(), b = nextInt(), c = nextInt();
        if (a == 0 && b == 0 && c == 0) {
            return -1;
        }
        if (a == 0 && b == 0) {
            return 0;
        }
        if (c == 0 && (a == 0 || b == 0)) {
            return "1\n0.00000";
        }
        if (a == 0) {
            return "1\n" + format(-c / b);
        }
        if (b == 0) {
            return -c / a < 0 ? 0 : "2\n" + format(-Math.sqrt(-c / a)) + "\n" + format(Math.sqrt(-c / a));
        }
        double d = b * b - 4 * a * c;
        if (d < 0) {
            return 0;
        }
        if (d == 0) {
            return "1\n" + format(-b / (2 * a));
        }
        double u = (-b - Math.sqrt(d)) / (2 * a), v = (-b + Math.sqrt(d)) / (2 * a);
        return "2\n" + format(Math.min(u, v)) + "\n" + format(Math.max(u, v));
    }

    private static String format(double x) {
        return String.format("%.5f", x);
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new _20B().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tok = null;
            System.out.print(solve());
            in.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}