import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] a = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int tmp = sc.nextInt();
            a[tmp] = true;
        }

        long[] ans = new long[n+1];
        ans[0] = 1;
        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i] % 1000000007;
            if (i+2 <= n && !a[i+2]) ans[i+2] += ans[i];
            if (i+1 <= n && !a[i+1]) ans[i+1] += ans[i];
        }

        System.out.println(ans[n]);
    }
}