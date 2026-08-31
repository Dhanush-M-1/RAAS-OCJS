import java.util.*;

public class Main {

    static int N;
    static boolean[][] F;
    static int[][] P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = new boolean[N+1][10];
        for (int n = 1; n <= N; n++) {
            for (int wm = 0; wm < 10 ; wm++) {
                F[n][wm] = sc.nextInt() == 1;
            }
        }

        P = new int[N+1][11];
        for (int n = 1; n <= N; n++) {
            for (int i = 0; i <= 10 ; i++) {
                P[n][i] = sc.nextInt();
            }
        }

        System.out.println( solve() );
    }

    private static int solve() {
        int ans = Integer.MIN_VALUE;
        for (int b = 1; b <= 1023; b++) {
            int profit = 0;
            for (int n = 1; n <= N; n++) {
                int cn = 0;
                for (int wm = 0; wm < 10; wm++) {
                    if( isOn(b, wm) && F[n][wm] ) {
                        cn++;
                    }
                }
                profit += P[n][cn];
            }

            ans = Math.max(profit, ans);
        }
        return ans;
    }

    private static boolean isOn(int b, int wm) {
        return (b & (1 << wm)) != 0;
    }
}
