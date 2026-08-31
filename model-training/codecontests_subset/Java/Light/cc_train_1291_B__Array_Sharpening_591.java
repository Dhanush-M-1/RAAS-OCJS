import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int test = 0; test < tests; ++test) {
            int n = sc.nextInt();
            boolean[] b1 = new boolean[n];
            boolean[] b2 = new boolean[n];
            for (int i = 0; i < n; ++i) {
                int ai = sc.nextInt();
                b1[i] = (ai >= i);
                b2[i] = (ai >= n - 1 - i);
            }

            int p = -1;
            while (p + 1 < n && b1[p + 1]) p++;
            if (p != -1) p--;
            while (p + 1 < n && b2[p + 1]) p++;

            System.out.println(p == n - 1 ? "Yes" : "No");
        }
    }
}
