import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        boolean[] on = new boolean[m + 1];
        for (int i = 1; i <= n; ++i) {
            int x = input.nextInt();
            for (int j = 1; j <= x; ++j) {
                int y = input.nextInt();
                on[y] = true;
            }
        }
        for (int i = 1; i <= m; ++i) {
            if (!on[i]) {
                System.out.printf("NO\n");
                return;
            }
        }
        System.out.printf("YES\n");
    }
}