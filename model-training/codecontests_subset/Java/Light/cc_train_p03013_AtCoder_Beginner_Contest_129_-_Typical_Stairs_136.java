import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        int a[] = new int[m + 2];
        for (int i = 1; i <= m; i++) {
            a[i] = Integer.parseInt(sc.next());
        }
        sc.close();
        a[0] = -1;
        a[m + 1] = n + 1;
        List<Integer> b = new ArrayList<>();
        for (int i = 1; i <= m + 1; i++) {
            if (a[i] - a[i - 1] == 1) {
                System.out.println(0);
                return;
            }
            b.add(a[i] - a[i - 1] - 1);
        }
        long memo[] = new long[n + 2];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            memo[i] %= 1_000_000_007;
        }
        long ans = 1;
        for (int i = 0; i < b.size(); i++) {
            ans *= memo[b.get(i)];
            ans %= 1_000_000_007;
        }
        System.out.print(ans);
    }
}