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
 * @author and_so_on
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int p = in.nextInt();
            int arrn[] = new int[n];
            int arrk[] = new int[k];
            for (int i = 0; i < n; i++) {
                arrn[i] = in.nextInt();
            }
            for (int i = 0; i < k; i++) {
                arrk[i] = in.nextInt();
            }
            Arrays.sort(arrk);
            Arrays.sort(arrn);
            int ans = Integer.MAX_VALUE;
            int s, e;
            for (s = 0; s <= k - n; s++) {
                e = s + n - 1;
                int max = Integer.MIN_VALUE;
                int max2 = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    max = Math.max(max, Math.abs(arrn[i] - arrk[s + i]) + Math.abs(arrk[s + i] - p));
                    max2 = Math.max(max2, Math.abs(arrn[n - i - 1] - arrk[s + i]) + Math.abs(arrk[s + i] - p));
                }
                int min = Math.min(max, max2);
                ans = Math.min(min, ans);
            }
            out.println(ans);
        }

    }
}

