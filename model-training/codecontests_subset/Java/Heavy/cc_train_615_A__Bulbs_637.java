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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[] bolbs = new boolean[m];
            for (int i = 0; i < n; ++i) {
                int t = in.nextInt();
                for (int j = 0; j < t; ++j) {
                    bolbs[in.nextInt() - 1] = true;
                }
            }
            for (int i = 0; i < m; ++i)
                if (!bolbs[i]) {
                    out.print("NO");
                    return;
                }
            out.print("YES");
        }

    }
}

