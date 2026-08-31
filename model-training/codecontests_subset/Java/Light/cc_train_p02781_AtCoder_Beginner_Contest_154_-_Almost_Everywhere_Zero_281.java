import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        char[] c = S.toCharArray();
        int K = sc.nextInt();

        int[][][] dp = new int[105][4][2];
        dp[0][0][0] = 1;
        for (int i=0;i<c.length;i++) {
            for (int j=0;j<4;j++) {
                for (int k=0;k<2;k++) {
                    int nd = (int)c[i]-(int)'0';
                    for (int d=0;d<10;d++) {
                        int ni = i+1;
                        int nj = j;
                        int nk = k;
                        if (d!=0) nj++;
                        if (nj>K) continue;
                        if (k==0) {
                            if (d>nd) continue;
                            if (d<nd) nk = 1;
                        }

                        dp[ni][nj][nk] += dp[i][j][k];
                    }
                }
            }
        }
        System.out.println(dp[c.length][K][0]+dp[c.length][K][1]);
    }
}
