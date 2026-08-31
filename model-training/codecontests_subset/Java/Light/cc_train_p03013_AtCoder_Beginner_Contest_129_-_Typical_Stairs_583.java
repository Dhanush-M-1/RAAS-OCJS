import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

public class Main {

    static final int modnum = 1000000000 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] stair = new boolean[N+5];
        int[] dp = new int[N+5];

        for (int i = 0; i < M; i++) {
            int broken = sc.nextInt();
            stair[broken] = true;
        }
        dp[1] = stair[1] ? 0 : 1;
        dp[2] = stair[2] ? 0 : dp[1]+1;
        for (int i = 3; i <= N; i++) {
            dp[i] = stair[i] ? 0: (dp[i-1]+dp[i-2])%modnum;
        }
        System.out.println(dp[N]);
        // for (int i = 0; i < N; i++) {
        //     System.out.println(stair[i]);
        // }
    }
}