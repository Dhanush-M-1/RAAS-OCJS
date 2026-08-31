import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int f[][] = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                f[i][j] = in.nextInt();
            }
        }
        int p[][] = new int[n][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                p[i][j] = in.nextInt();
            }
        }


        long maxp = Long.MIN_VALUE;
        for (int comb = 1; comb <= 1023; comb++) {
            long profit = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < 10; j++) {
                    if (((comb >> j) & f[i][j]) == 1) {
                        count++;
                    }
                }
                profit += p[i][count];
            }
            maxp = Math.max(maxp, profit);
        }

        System.out.println(maxp);
    }
}