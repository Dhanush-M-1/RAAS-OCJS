import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();
        final long mod = 1000000007;
        boolean []broken = new boolean[n+1];
        Arrays.fill(broken,false);
        for (int i = 0;i<m;++i)
        {
            int a = sc.nextInt();
            broken[a] = true;
        }

        long [] dp = new long[n+2];
        dp[n] = 1;
        for (int now = n-1;now >= 0;--now)
        {
            if (broken[now])
            {
                dp[now] = 0;
                continue;
            }
            dp[now] = (dp[now+1]+dp[now+2]) % mod;
            //debug
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0;i<dp.length;++i) sb.append(dp[i]+",");
//            System.out.println(sb.toString());
//            System.out.println("--------------------");
            //end debug
        }
        System.out.println(dp[0]);
        sc.close();
    }
}