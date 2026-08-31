import java.util.Scanner;

public class Main {

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 階段の段数
        int M = sc.nextInt(); // 壊れている床番号

        //
        int[] brokenStairs = new int[M];
        for (int i = 0; i < M; i++) {
            brokenStairs[i] = sc.nextInt();
        }

        long[] count = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            count[i] = -1;
        }

        count[0] = 1;
        count[1] = 1;
        for (int i = 0; i < M; i++) {
            count[brokenStairs[i]] = 0;
        }

        for (int stair = 2; stair <= N; stair++) {
            if (count[stair] == -1) {
                count[stair] = count[stair - 1] + count[stair - 2];
                count[stair] %= 1000000007;
            }
        }
        System.out.print(count[N]);
    }

    // Main
    public static void main(String[] args) {
        new Main().solve();
    }

}
