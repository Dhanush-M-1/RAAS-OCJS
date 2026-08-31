import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) throws IOException {
        new B().solve();
    }

    StringTokenizer st = new StringTokenizer("");
    BufferedReader br;

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        long a = nextInt();
        long b = nextInt();
        long c = nextInt();
        br.close();

        final int cnt;
        List<Double> roots = new ArrayList<Double>();
        long d = b * b - 4 * a * c;
        if (d >= 0) {
            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        cnt = -1;
                    } else {
                        cnt = 0;
                    }
                } else {
                    cnt = 1;
                    roots.add((-1.0 * c) / b);
                }
            } else {
                if (d == 0) {
                    cnt = 1;
                    double root = (-b) / (2.0 * a);
                    roots.add(root);
                } else {
                    cnt = 2;
                    double root1 = (-b + Math.sqrt(d)) / (2.0 * a);
                    double root2 = (-b - Math.sqrt(d)) / (2.0 * a);
                    roots.add(Math.min(root1, root2));
                    roots.add(Math.max(root1, root2));
                }
            }
        } else {
            cnt = 0;
        }

        PrintWriter pw = new PrintWriter(System.out);
        pw.println(cnt);
        for (double root : roots) {
            pw.printf("%.10f", root);
            pw.println();
        }
        pw.close();
    }

    String nextToken() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}
