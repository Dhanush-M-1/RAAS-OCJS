import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        _868a solver = new _868a();
        solver.solve(1, in, out);
        out.close();
    }

    static class _868a {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.next();
            int n = in.nextInt();
            String[] ar = new String[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.next();
            }
            for (String s1 : ar) {
                for (String s2 : ar) {
                    if ((s1 + s2).contains(s)) {
                        out.println("YES");
                        return;
                    }
                }
            }
            out.println("NO");
        }

    }
}

