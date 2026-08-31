import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    static String INPUT = "";

    public static void main(String[] args) {
        InputStream is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());

        Scanner scanner = new Scanner(is);

        int n = scanner.nextInt();

        boolean[][] isOpen = new boolean[n][];

        for (int i = 0; i < n; i++) {
            isOpen[i] = new boolean[10];
            for (int j = 0; j < 10; j++) {
                isOpen[i][j] = scanner.nextInt() == 1;
            }
        }

        int[][] profit = new int[n][];
        for (int i = 0; i < n; i++) {
            profit[i] = new int[11];
            for (int j = 0; j < 11; j++) {
                profit[i][j] = scanner.nextInt();
            }
        }

        int ret = solve(isOpen, profit);
        System.out.println(ret);
    }

    static int solve(boolean[][] isOpen, int[][] profit) {
        int limit = 1 << 10;
        int max = Integer.MIN_VALUE;
        for (int k = 1; k < limit; k++) {
            int profitSum = 0;
            for (int i = 0; i < isOpen.length; i++) {
                int count = 0;
                for (int j = 0; j < 10; j++) {
                    if (((k >> j) & 1) == 1 && isOpen[i][j]) {
                        count++;
                    }
                }
                profitSum += profit[i][count];
            }
            max = Math.max(max, profitSum);
        }
        return max;
    }

    static boolean[] primeSieve(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        isPrime[1] = false;
        int limit = (int) Math.ceil(Math.sqrt(n));
        for (int i = 2; i < limit; i++) {
            for (int j = 2; j * i < n; j++) {
                isPrime[j * i] = false;
            }
        }
        return isPrime;
    }
}
