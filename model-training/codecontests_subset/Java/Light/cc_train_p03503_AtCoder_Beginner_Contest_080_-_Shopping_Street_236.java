import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] F = new int[N][10 + 1];
        int[][] P = new int[N][10 + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= 10; j++) {
                F[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= 10; j++) {
                P[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < (1 << 10); i++) {
            int a = 0;
            for (int j = 0; j < N; j++) {
                int c = 0;
                for (int k = 0; k < 10; k++) {
                    if ((i & (1 << k)) != 0 && F[j][10 - k] == 1) {
                        c++;
                    }
                }
                if (j == 0) {
                    a = P[j][c];
                } else {
                    a += P[j][c];
                }
            }
            max = Math.max(max, a);
        }
        System.out.println(max);
    }
}
