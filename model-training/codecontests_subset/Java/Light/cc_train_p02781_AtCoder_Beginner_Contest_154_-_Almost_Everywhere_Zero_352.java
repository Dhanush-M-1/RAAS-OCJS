import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int N = S.length();
        int K = sc.nextInt();

        /**
         * i桁目まで決めて
         * j個の非0をつかって
         * 0: 底までの桁はNと一致
         * 1: そこまでの桁ですでにN(与えられた値)以下であることが確定
         */

        /**
         * 最初のとき
         * i=0桁目は1桁も決めてない状態のこと
         * 数字がないのでj=0
         * この時k=0
         */

        /**
         * 配るDP: 遷移もとから次を考える
         * もらうDP: 遷移先に注目して考える。
         * 今回は次の状態を考えやすいので配るDP
         * 背反な場合の数を足し合わせるイメージ
         */


        int[][][] dp = new int[105][4][2];

        dp[0][0][0] = 1; //初期状態

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    int nd = Integer.parseInt(String.valueOf(S.charAt(i)));
                    for (int d = 0; d < 10; d++) {
                        int ni = i + 1, nj = j, nk = k;
                        if (d != 0) nj++;
                        if(nj > K) continue;
                        if(k == 0) {
                            if (d > nd) continue;
                            if (d < nd) nk = 1;
                        }
                        dp[ni][nj][nk] += dp[i][j][k];
                    }
                }
            }
        }
//
//        for (int i = 0; i < N + 1; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(dp[i][j][0]+ " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int i = 0; i < N + 1 ; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(dp[i][j][1]+ " ");
//            }
//            System.out.println();
//        }

        int ans = dp[N][K][0] + dp[N][K][1];
        System.out.println(ans);
    }
}
