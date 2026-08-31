import java.util.*;

public class Main {

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];
        boolean[] searched = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (searched[i]) {
                continue;
            }
            if (p[i] == i + 1) {
                ans++;
                if (i != n - 1 && p[i + 1] == i + 2) {
                    searched[i + 1] = true;
                }
            }
        }
        System.out.println(ans);
    }
}