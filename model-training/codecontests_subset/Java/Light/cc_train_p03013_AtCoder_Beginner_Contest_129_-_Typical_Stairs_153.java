import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    static long[] dp;
    static int N,M;
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new long[N+1];
        Arrays.fill(dp,-1);
        dp[0] = 1; dp[1] = 1;
        for(int i=0;i<M;++i)
        {
            dp[Integer.parseInt(br.readLine())] = 0;
        }
        for(int i=0;i<=N;++i)
        {
            if(dp[i]!=-1) continue;
            dp[i] = (dp[i-1]+dp[i-2])%MOD;
        }
        bw.write(dp[N]+"");
        bw.close();
    }

}
