import java.util.*;

public class Main {
    private static long[] dp = new long[100100];
    private static final long INF = 1L << 60;
    private static final long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        Arrays.fill(dp,0);
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int W = Integer.parseInt(sc.next());
        boolean brokenSteps[] = new boolean[100100];
        Arrays.fill(brokenSteps,false);
        for(int i=0;i<W;i++){
            brokenSteps[Integer.parseInt(sc.next())] = true;
        }
        dp[0] = 1;
        long res = 1;
        for(int i=0;i<=N;i++){
            for(int j=i+1;j<=Math.min(N,i+2);j++){
                if(!brokenSteps[j]){
                    dp[j] += dp[i];
                    dp[j] %= MOD;
                }
            }
        }
        System.out.println(dp[N]);
    }
}