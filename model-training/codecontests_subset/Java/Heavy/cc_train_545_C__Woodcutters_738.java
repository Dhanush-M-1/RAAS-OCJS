

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * some cheeky quote
 */

public class Main
{
    FastScanner in;
    PrintWriter out;
    private final static int MIN = Integer.MIN_VALUE;

    public void solve() throws IOException
    {
        int n = in.nextInt();
        int position[] = new int[n];
        int height[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            position[i] = in.nextInt();
            height[i] = in.nextInt();
        }

        //Start of dp//
        int dp[][] = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1 < n && position[0] + height[0] < position[1] ? 1 : MIN;
        for (int i = 1; i < dp.length; i++)
        {
            dp[i][0] = dp[i][1] = MIN;
            if (position[i - 1] < position[i] - height[i])
            {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + 1);
            }
            if (position[i - 1] + height[i - 1] < position[i] - height[i])
            {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            }

            dp[i][0] = Math.max(dp[i][0], Math.max(dp[i - 1][0], dp[i - 1][1]));
            if (i == n - 1 || (i + 1 < n && position[i] + height[i] < position[i + 1]))
            {
                dp[i][1] = Math.max(dp[i][1], Math.max(dp[i - 1][1] + 1, dp[i - 1][0] + 1));
            }
        }
        //End of dp//
        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));


    }

    public void run()
    {
        try
        {
            in = new FastScanner();
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    class FastScanner
    {
        BufferedReader br;
        StringTokenizer st;

        FastScanner()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreTokens())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg)
    {
        new Main().run();
    }
}

