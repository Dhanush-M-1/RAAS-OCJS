import java.util.Scanner;

public class Main {
    public void main(Scanner sc) {
        int n = sc.nextInt();
        int f[] = new int[n];
        int p[][] = new int[n][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                int fb = sc.nextInt();
                f[i] *= 2;
                f[i] += fb;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10; j++) {
                p[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num = 1; num < 1024; num++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int c = countBit(num & f[i]);
                sum += p[i][c];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    private int countBit(int n) {
        n = ((n & 0xAAAAAAAA) >> 1) + (n & 0x55555555);
        n = ((n & 0xCCCCCCCC) >> 2) + (n & 0x33333333);
        n = ((n & 0xF0F0F0F0) >> 4) + (n & 0x0F0F0F0F);
        n = ((n & 0xFF00FF00) >> 8) + (n & 0x00FF00FF);
        n = ((n & 0xFFFF0000) >> 16) + (n & 0x0000FFFF);

        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Main().main(sc);
        sc.close();
    }
}
