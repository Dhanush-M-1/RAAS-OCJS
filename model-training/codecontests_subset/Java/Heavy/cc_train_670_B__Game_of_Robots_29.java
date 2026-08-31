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
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long[] sum = new long[100002];

            int n = in.nextInt();
            int k = in.nextInt();
            int[] d = new int[n];
            for (int i = 0; i < n; i++)
                d[i] = in.nextInt();
            sum[1] = 1;
            for (int i = 2; i <= n; i++)
                sum[i] = sum[i - 1] + i;
            int l = 1;
            int r = n;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (sum[mid] > k)
                    r = mid;
                else
                    l = mid;
            }
            long index = (k - sum[l]) == 0 ? l - 1 : (k - sum[l] - 1);
            out.println(d[(int) index]);
        }

    }
}

