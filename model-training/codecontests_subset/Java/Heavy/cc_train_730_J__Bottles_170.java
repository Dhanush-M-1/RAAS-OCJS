import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solveaproblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer sToken = new StringTokenizer(reader.readLine());
        int[] a = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(sToken.nextToken());
            sum+=a[i];
        }
        sToken = new StringTokenizer(reader.readLine());
        int[] c = new int[n];
        for (int i=0; i<n; i++) c[i] = Integer.parseInt(sToken.nextToken()) - a[i];
        int[][] dp = new int[n+1][sum+1];
        int min = -10000000;
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=sum; j++) {
                dp[i][j] = min;
            }
        }
        dp[0][0] = 0;
        for (int i=0; i<n; i++) {
            int[][] newdp = new int[n+1][sum+1];
            for (int k=0; k<=sum; k++) {
                if (k>=a[i]) newdp[0][k] = dp[0][k-a[i]];
                else newdp[0][k] = min;
            }
            for (int j=1; j<=n; j++) {
                for (int k=0; k<a[i]; k++) {
                    if (dp[j-1][k]!=min) newdp[j][k] = dp[j-1][k] + c[i];
                    else newdp[j][k] = min;
                }
                for (int k=a[i]; k<=sum; k++) {
                    if (dp[j-1][k]==min) newdp[j][k] = dp[j][k-a[i]];
                    else newdp[j][k] = Math.max(dp[j-1][k] + c[i], dp[j][k-a[i]]);
                }
            }
            for (int j=0; j<=n; j++) {
                for (int k=0; k<=sum; k++) {
                    dp[j][k] = newdp[j][k];
                }
            }
        }
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=sum; j++) {
                if (dp[i][j]>=j) {
                    PrintWriter writer = new PrintWriter(System.out);
                    writer.print(i+" "+j);
                    writer.close();
                    System.exit(0);
                }
            }
        }
    }
}