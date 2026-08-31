import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC
    {
        public void solve(int testNumber, Scanner in, PrintWriter out)
        {
            int n = in.nextInt();
            int max = 0;
            long sum = 0, ans;

            for (int i = 0; i < n; i++) {
                int minMatch = in.nextInt();
                max = Math.max(max, minMatch);
                sum += minMatch;
            }

            ans = Math.max(max, (sum - 1) / (n - 1) + 1); // (long) Math.ceil(sum / (double) (n - 1))
            out.println(ans);
        }

    }
}

