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
            int T = 1;
            while (T-- > 0)
            {
                solveOne(in, out);
            }
        }

        private void solveOne(Scanner in, PrintWriter out)
        {
            int MOD = 1_000_000_000 + 7;
            int dp[][] = new int[200000 + 10][10];
            for (int i = 0; i < 10; i++) dp[0][i] = 1;
            for (int i = 1; i <= 200000 + 5; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    dp[i][j] = dp[i - 1][j + 1];
                }
                dp[i][9] = (dp[i - 1][1] + dp[i - 1][0]) % MOD;
            }
            int testCases = in.nextInt();
            while (testCases-- > 0)
            {
                int N = in.nextInt();
                int M = in.nextInt();
                String s = "" + N;
                int ans = 0;
                for (char c : s.toCharArray())
                {
                    ans = (ans + dp[M][c - '0']) % MOD;
                }
                out.println(ans);
            }
        }

    }
}

