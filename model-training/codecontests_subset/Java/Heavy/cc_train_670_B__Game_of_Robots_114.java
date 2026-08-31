import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author toshif
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] ids = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = in.nextInt();
            }

            for (int i = 0; i <= n; i++) {
                if (k <= n && k <= i) {
                    out.print(ids[k - 1]);
                    return;
                }
                k -= i;
                if (k <= n && k <= i) {
                    out.print(ids[k - 1]);
                    return;
                }
            }
        }

    }
}

