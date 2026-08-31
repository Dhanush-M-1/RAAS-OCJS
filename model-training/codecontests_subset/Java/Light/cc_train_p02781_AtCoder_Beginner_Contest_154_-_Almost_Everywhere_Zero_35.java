import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int helper(int pos, int cnt, int tight, int k, int[][][] dp, List<BigInteger> nums) {
        if (pos == nums.size()) {
            if (cnt == k) {
                return 1;
            } else {
                return 0;
            }
        } else if (dp[pos][cnt][tight] != -1) {
            return dp[pos][cnt][tight];
        }

        int res = 0;
        BigInteger limit = (tight != 0 ? BigInteger.valueOf(9) : nums.get(pos));

        for (int dig = 0; limit.compareTo(BigInteger.valueOf(dig)) >= 0; dig++) {
            int currCnt = cnt;
            if (dig != 0)
                currCnt++;
            int currTight = tight;
            if (nums.get(pos).compareTo(BigInteger.valueOf(dig)) > 0)
                currTight = 1;
            res += helper(pos + 1, currCnt, currTight, k, dp, nums);
        }
        dp[pos][cnt][tight] = res;
        return res;
    }

    private static int countUntil(BigInteger n, int k) {
        final int M = 100;
        int dp[][][] = new int[M][M][2];

        List<BigInteger> nums = new ArrayList<>();
        while (n.intValue() != 0) {
            nums.add(n.mod(BigInteger.TEN));
            n = n.divide(BigInteger.TEN);
        }
        Collections.reverse(nums);

        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++)
                for (int h = 0; h < 2; h++)
                    dp[i][j][h] = -1;
        return helper(0, 0, 0, k, dp, nums);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.nextLine());
        int k = sc.nextInt();

        System.out.println(countUntil(n, k));
    }
}