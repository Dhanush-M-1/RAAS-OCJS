import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] f = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                f[i][j] = sc.nextInt();
            }
        }
        int[][] p = new int[n][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                p[i][j] = sc.nextInt();
            }
        }

        long ans = Long.MIN_VALUE;
        for (int bit = 1; bit < (1 << 10); bit++) {
            boolean[] open = new boolean[10];
            for (int i = 0; i < open.length; i++) {
                if ((1 & (bit >> i)) == 1) {
                    open[i] = true;
                }
            }
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < 10; j++) {
                    if (open[j] && f[i][j] == 1) {
                        cnt++;
                    }
                }
                sum += p[i][cnt];
            }
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }

}
