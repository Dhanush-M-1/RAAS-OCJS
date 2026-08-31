import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Likai
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
        int[] a;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            while (testNumber-- > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                a = new int[m + 1];
                for (int i = 0; i < n; ++i) {
                    int x = in.nextInt();
                    for (int j = 0; j < x; ++j) {
                        int p = in.nextInt();
                        a[p] = 1;
                    }
                }
                boolean flag = true;
                for (int i = 1; i <= m; ++i) {
                    if (a[i] != 1) flag = false;
                }
                if (flag) out.println("YES");
                else out.println("NO");
            }
        }

    }
}

