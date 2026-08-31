import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author xwchen
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
            int s = in.nextInt();

            long m = 0;
            int[] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);

            int k = n / 2;
            if (a[k] < s) {
                m = s - a[k];

                while (k + 1 <= n - 1 && a[k + 1] < s) {
                    ++k;
                    m += s - a[k];
                }
            } else {
                m = a[k] - s;
                while (k - 1 >= 0 && a[k - 1] > s) {
                    --k;
                    m += a[k] - s;
                }
            }
            out.println(m);

        }

    }
}

