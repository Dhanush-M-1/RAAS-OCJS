
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SetNumbers {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char a[] = sc.next().trim().toCharArray();

        int b[][] = new int[26][n + 1];

        for (int i = 0; i < n; i++) {
            int x = a[i] - 'a';
            b[x][i + 1] = 1;
        }

        for (int y[] : b) {
            for (int i = 1; i <= n; i++) {
                y[i] += y[i - 1];
            }
        }

        int ans[][] = new int[26][n + 1];

        for (int y[] : ans) {
            Arrays.fill(y, Integer.MAX_VALUE);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = j; k <= n; k++) {
                    int x = b[i][k] - b[i][k - j];

                    ans[i][j] = Math.min(ans[i][j], j - x);
                }

            }

        }
        int q = sc.nextInt();
        // String str[];
        m:
        while (q-- > 0) {
            //str = sc.next().trim().split(" ");

            int y = sc.nextInt();
            int x = sc.next().charAt(0) - 'a';

            for (int i = n; i > 0; i--) {
                if (ans[x][i] <= y) {
                    System.out.println(i);
                    continue m;
                }
            }
        }

        sc.close();
    }
}
