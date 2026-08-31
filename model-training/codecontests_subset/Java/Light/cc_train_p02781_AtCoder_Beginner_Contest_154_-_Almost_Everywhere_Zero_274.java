import java.util.*;
public class Main {
    public static void main(final String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int K = sc.nextInt();
        sc.close();

        int L = N.length();
        int[][] dp0 = new int[L + 1][K + 1];
        int[][] dp1 = new int[L + 1][K + 1];
        dp1[0][0] = 1;

        for (int i = 0; i < L; i++) {
            int d = N.charAt(i) - '0';
            for (int j = 0; j < K + 1; j++) {
                if (d == 0) {
                    dp1[i + 1][j] += dp1[i][j];
                } else {
                    if (j < K) {
                        dp1[i + 1][j + 1] += dp1[i][j];
                        dp0[i + 1][j + 1] += dp1[i][j] * (d - 1);
                    }
                    dp0[i + 1][j] += dp1[i][j];
                }

                if (j < K) {
                    dp0[i + 1][j + 1] += dp0[i][j] * 9;
                }
                dp0[i + 1][j] += dp0[i][j];
            }
        }

        long ans = dp0[L][K] + dp1[L][K];
        System.out.println(ans);
    }
}