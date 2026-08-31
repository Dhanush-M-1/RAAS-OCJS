import java.util.Scanner;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int ans[] = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;
        int index = 0;
        for (int i = 2; i < n + 1; i++) {
            // 壊れている床を考慮
            if (index < m) {
                if (i - 1 == a[index]) {
                    ans[i - 1] = 0;
                    index++;
                }
            }
            // dpで算出
            ans[i] = (ans[i - 2] + ans[i - 1]) % MOD;
        }
        System.out.println(ans[n]);
    }

}
