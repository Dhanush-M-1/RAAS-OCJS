import java.util.Scanner;

public class Main {

    public static long sum = Long.MIN_VALUE;

    public static void dfs(int n, int [][] F, int [][] P, int period, int [] same) {
        if (period == 10) {
            int openCount = 0;
            for (int i = 0; i < n; ++i) {
                if (same[i] > 0) {
                    openCount++;
                    break;
                }
            }
            if (openCount == 0) {
                return;
            }
            long currentSum = 0;
            for (int i = 0; i < n; ++i) {
                currentSum += P[i][same[i]];
            }
            sum = Math.max(sum, currentSum);
            return;
        }

        //not choose this period
        dfs(n, F, P, period + 1, same);

        //choose this period
        for (int i = 0; i < n; ++i) {
            if (F[i][period] == 1) {
                ++same[i];
            }
        }

        dfs(n, F, P, period + 1, same);
        for (int i = 0; i < n; ++i) {
            if (F[i][period] == 1) {
                --same[i];
            }
        }
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] F = new int [n][10];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 10; ++j) {
                F[i][j] = sc.nextInt();
            }
        }
        int [][] P = new int[n][11];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= 10; ++j) {
                P[i][j] = sc.nextInt();
            }
        }
        int [] same = new int [n];
        dfs(n, F, P, 0, same);
        System.out.println(sum);

    }
}