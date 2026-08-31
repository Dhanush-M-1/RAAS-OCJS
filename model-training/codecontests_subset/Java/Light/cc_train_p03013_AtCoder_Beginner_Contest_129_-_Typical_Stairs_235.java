import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        // abc 129 C
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            queue.add(sc.nextInt());
        }

        long[] dp = new long[n + 2];
        dp[1] = 1;
        for (int i = 2; i <= n + 1; i++) {
            if (!queue.isEmpty() && queue.peek() == i - 1) {
                queue.poll();
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }

        System.out.println(dp[n + 1]);
    }
}