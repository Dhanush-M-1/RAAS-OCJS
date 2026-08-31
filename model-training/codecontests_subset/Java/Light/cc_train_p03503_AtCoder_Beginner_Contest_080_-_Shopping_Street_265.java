import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mikit
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CShoppingStreet solver = new CShoppingStreet();
        solver.solve(1, in, out);
        out.close();
    }

    static class CShoppingStreet {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            boolean[][] f = new boolean[10][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < 10; i++) {
                    f[i][j] = in.nextInt() == 1;
                }
            }
            int[][] p = new int[11][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i <= 10; i++) {
                    p[i][j] = in.nextInt();
                }
            }

            int ans = Integer.MIN_VALUE;
            for (int i = 1; i < 0b1_00000_00000; i++) {
                int a = 0;
                for (int j = 0; j < n; j++) {
                    int d = 0;
                    for (int k = 0; k < 10; k++) {
                        if ((i & (1 << k)) > 0 && f[k][j]) {
                            d++;
                        }
                    }
                    a += p[d][j];
                }
                ans = Math.max(ans, a);
            }
            out.println(ans);
        }

    }
}

