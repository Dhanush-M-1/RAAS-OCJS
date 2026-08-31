import java.io.*;
import java.util.*;
import static java.lang.System.in;

public class Main {
    static long mod = 1000000000+7;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String[] buf = reader.readLine().split(" ");
        int n = sc.nextInt(), m = sc.nextInt();
        long[] dp = new long[n+1];
        boolean[] bad = new boolean[n+1];
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            bad[a] = true;
        }
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(bad[i]) continue;
            dp[i] = dp[i-1];
            if(i>1) dp[i] += dp[i-2];
            dp[i] %= mod;
        }
        System.out.println(dp[n]);
    }
}

