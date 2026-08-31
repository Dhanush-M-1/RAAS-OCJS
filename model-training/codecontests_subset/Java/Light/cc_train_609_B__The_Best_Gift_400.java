import java.util.Scanner;

public class BestGift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[] freqs = new int[m];

            for (int i = 0; i < n; ++i) {
                freqs[scanner.nextInt() - 1]++;
            }

            int ans = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = i + 1; j < m; ++j) {
                    ans += freqs[i] * freqs[j];
                }
            }
            System.out.println(ans);
        }
    }
}
