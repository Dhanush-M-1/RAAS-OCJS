import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author zodiacLeo
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
        /*
            //Greedy approach//
            int last = Integer.MIN_VALUE;
            int n = in.nextInt();
            int pos[] = new int[n];
            int h[] = new int[n];
            for (int i = 0; i < n; i++)
            {
                pos[i] = in.nextInt();
                h[i] = in.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n; i++)
            {
                if (pos[i] - h[i] >= last)
                {
                    count++;
                    last = pos[i] + 1;
                }else
                {
                    last = pos[i] + 1;
                    if ((i == n - 1) || (pos[i] + h[i] < pos[i + 1]))
                    {
                        count++;
                        last = pos[i] + h[i] + 1;
                    }
                }
            }
            out.println(count);
        */


            //DP//
            int n = in.nextInt();
            int pos[] = new int[n];
            int height[] = new int[n];
            for (int i = 0; i < n; i++)
            {
                pos[i] = in.nextInt();
                height[i] = in.nextInt();
            }

        /*
        j == 0 -> left
        j == 1 -> right
         */

            int dp[][] = new int[n][2];
            for (int i = 0; i < n; i++)
            {
                if (i == 0)
                {
                    dp[i][0] = 1;
                    dp[i][1] = (i == n - 1 || pos[i] + height[i] < pos[i + 1]) ? 1 : 0;
                } else
                {
                    int max = Math.max(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][0] = dp[i][1] = max;
                    if (pos[i] - height[i] > pos[i - 1])
                    {
                        dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
                    }
                    if (pos[i] - height[i] > pos[i - 1] + height[i - 1])
                    {
                        dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
                    }

                    if (i == n - 1 || pos[i] + height[i] < pos[i + 1])
                    {
                        dp[i][1]++;
                    }
                }
            }
            out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));

        }

    }
}

