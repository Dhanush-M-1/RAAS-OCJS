import java.util.Scanner;

public class TaskA {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), m = sc.nextInt();
        int[] cnt = new int[1001];
        for (int i = 0; i < n; i++)
            cnt[sc.nextInt()]++;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (ans == 0 && cnt[x] > 0)
                ans = x;
        }
        if (ans > 0)
            System.out.println("YES\n1 " + ans);
        else
            System.out.println("NO");
    }
}
