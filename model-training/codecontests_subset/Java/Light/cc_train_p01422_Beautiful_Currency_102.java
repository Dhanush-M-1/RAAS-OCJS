
import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {
 
        Scanner sc = new Scanner(System.in);
 
        final double MAX = Double.MAX_VALUE / 4;
        final double EPS = 1e-8;
        double[] in;
 
        void run() {
                int n = sc.nextInt();
                in = new double[n];
                for (int i = 0; i < n; i++) {
                        in[i] = sc.nextInt();
                }
                n++;
                double dp[][] = new double[123456][n];
 
                for (int i = 0; i < 123455; i++) {
                        Arrays.fill(dp[i], -MAX);
                }
 
                dp[1][0] = 0;
                
                for (int i = 1; i < n; i++) {
                        for (int j = 0; j < 123400; j++) {
                                if (dp[j][i-1] >= 0) {
                                        for (int jj = j; jj < 123400; jj += j) {
                                                double temp = Math.max(dp[j][i-1], Math.abs(jj- in[i-1])/in[i-1]);
                                                if(dp[jj][i] < 0){
                                                        dp[jj][i] = temp;
                                                }
                                                dp[jj][i] = Math.min(dp[jj][i], temp);
                                        }
                                }
                        }
                }
                
                double ans=MAX;
                for(int i = 0; i < 123450; i++){
                        if(dp[i][n-1] >= 0){
                        ans = Math.min(dp[i][n-1], ans);
                        }
                }
                System.out.printf("%.9f\n",ans);
        }
 
        public static void main(String[] args) {
                Main m = new Main();
                m.run();
        }
 
}
 