import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ZYCSwing
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        int n;
        int[] mask;
        int[][] p;

        private int cnt(int x) {
            int res = 0;
            while (x != 0) {
                x = x & (x - 1);
                ++res;
            }
            return res;
        }

        private int gao(int x) {
            int res = 0;
            for (int i = 0; i < n; ++i) {
                res += p[i][cnt(mask[i] & x)];
            }
            return res;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            n = in.nextInt();
            mask = new int[n];
            p = new int[n][11];

            int f;
            for (int i = 0; i < n; ++i) {
                mask[i] = 0;
                for (int j = 0; j < 10; ++j) {
                    f = in.nextInt();
                    mask[i] = (mask[i] << 1) | f;
                }
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j <= 10; ++j) {
                    p[i][j] = in.nextInt();
                }
            }

            int res = Integer.MIN_VALUE;

            for (int i = 1; i < 1024; ++i) {
                res = Math.max(res, gao(i));
            }

            out.println(res);
        }

    }
}

