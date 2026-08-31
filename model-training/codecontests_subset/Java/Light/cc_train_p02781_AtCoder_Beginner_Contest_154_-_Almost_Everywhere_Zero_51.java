
import java.util.Scanner;

public class Main {
    // TODO solve
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String n = scanner.next();
        final int k = scanner.nextInt();

        int justCount = 1;
        final long[][] less = new long[n.length()][k + 1];
        less[0][1] = n.charAt(0) - '1';
        less[0][0] = 1;
        for (int i = 1; i < n.length(); i++) {
            final int digit = n.charAt(i) - '0';
            if (digit != 0) {
                if (justCount < k) {
                    less[i][justCount + 1] += digit - 1;
                    less[i][justCount]++;
                } else if (justCount == k) {
                    less[i][justCount]++;
                }
                justCount++;
            }

            // less
            for (int j = 0; j <= k; j++) {
                // その桁が0
                less[i][j] += less[i - 1][j];
                if (j != 0) {
                    // その桁が1 ~ 9
                    less[i][j] += less[i - 1][j - 1] * 9;
                }
            }
        }

        System.out.println(less[n.length() - 1][k]+(justCount==k?1:0));
    }
}
