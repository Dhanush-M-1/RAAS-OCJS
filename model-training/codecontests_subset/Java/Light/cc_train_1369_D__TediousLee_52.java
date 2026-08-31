import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        final int MAX = (int) Math.pow(10, 6) * 2 + 1;
        final int MOD = (int) Math.pow(10, 9) + 7;
        long[] inf = new long[MAX];
        long[] edg = new long[MAX];
        long[] clw = new long[MAX];
        long[] res = new long[MAX];
        inf[1] = 1;
        edg[1] = clw[1] = 0;
        for (int i = 2; i < MAX; i++) {
            inf[i] = (inf[i - 1] + 2L * edg[i - 1] % MOD) % MOD;
            edg[i] = inf[i - 1];
            clw[i] = edg[i - 1];
            if (i > 3) {
                res[i] = (clw[i] + res[i - 3]) % MOD;
            } else {
                res[i] = clw[i];
            }
        }

        for (int z = 0; z < t; z++) {
            int n = in.nextInt();
            System.out.println(res[n] * 4L % MOD);
        }

        in.close();
    }

}