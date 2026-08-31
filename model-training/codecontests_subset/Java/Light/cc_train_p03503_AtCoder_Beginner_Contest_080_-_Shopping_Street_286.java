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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        static int n;
        static boolean[][] f;
        static int[][] p;

        static long dfs(boolean[] b, int cn, long max, boolean tf) {
            b[cn] = tf;
            long cMax = max;
            if (cn + 1 < b.length) {
                cMax = dfs(b, cn + 1, cMax, false);
            }
            if (cn + 1 < b.length) {
                cMax = dfs(b, cn + 1, cMax, true);
            }

            boolean opened = false;
            for (int i = 0; i < b.length; i++) {
                if (b[i]) {
                    opened = true;
                    break;
                }
            }
            if (!opened) return max;

            if (cn == b.length - 1) {
                int cProfit = 0;
                for (int i = 0; i < n; i++) {
                    int iCount = 0;
                    for (int j = 0; j < 10; j++) {
                        if (b[j] && f[i][j]) iCount++;
                    }
                    cProfit += p[i][iCount];
                }
                if (cProfit > cMax) cMax = cProfit;
            }

            return cMax;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            n = in.nextInt();
            f = new boolean[n][10];
            p = new int[n][11];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    int c = in.nextInt();
                    f[i][j] = (c == 1);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 11; j++) {
                    int c = in.nextInt();
                    p[i][j] = c;
                }
            }

            boolean[] open = new boolean[10];
            long max = Long.MIN_VALUE;
            max = dfs(open, 0, max, false);
            max = dfs(open, 0, max, true);

            out.println(max);
        }

    }
}

