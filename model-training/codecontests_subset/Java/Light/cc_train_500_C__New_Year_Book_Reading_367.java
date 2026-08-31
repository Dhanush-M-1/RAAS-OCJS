import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int n = io.nextInt(), m = io.nextInt();
        int[] w = new int[n + 1], b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = io.nextInt();
            b[i] = -1;
        }
        int ans = 0;
        for (int i = 0, a; i < m; i++) {
            a = io.nextInt();
            for (int j = 1; j <= n; j++) if (b[j] > b[a]) ans += w[j];
            b[a] = i;
        }
        System.out.println(ans);
    }

}
