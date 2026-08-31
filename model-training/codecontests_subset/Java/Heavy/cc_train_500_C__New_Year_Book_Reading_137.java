import java.util.Arrays;
import java.util.Scanner;


public class CF500C {

    public static void main(String[] args) throws Exception {
        new CF500C().solve();
    }

    private void solve() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt() - 1;
        }

        boolean[] used = new boolean[n];
        int ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            Arrays.fill(used, false);
            int x = b[i];
            for (int j = i - 1; j >= 0; j--) {
                int x2 = b[j];
                if (x == x2) break;
                if (!used[x2]) {
                    ans += w[x2];
                    used[x2] = true;
                }
            }
        }
        System.out.println(ans);
    }

}
