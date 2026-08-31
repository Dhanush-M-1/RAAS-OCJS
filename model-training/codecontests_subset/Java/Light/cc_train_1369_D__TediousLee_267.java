import java.util.*;
import java.io.*;

public class D {
    public static long MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(f.readLine());
        long[] dp = new long[2000001];
        dp[3] = 1;
        dp[4] = 1;
        for(int i = 5; i < 2000001; i++){
            dp[i] = (2*dp[i-2])%MOD;
            dp[i] += (dp[i-1]);
            dp[i]%=MOD;
            if(i % 3 == 0) dp[i]++;
            dp[i] %= MOD;
        }
        while(t-->0){
            int n = Integer.parseInt(f.readLine());

            out.println((4*dp[n]) % MOD);

        }




        out.close();
    }

    static long power(long x, long y, long p)
    {
        // Initialize result
        long res = 1;

        // Update x if it is more
        // than or equal to p
        x = x % p;

        if (x == 0) return 0; // In case x is divisible by p;

        while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;

            // y must be even now
            // y = y / 2
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}
