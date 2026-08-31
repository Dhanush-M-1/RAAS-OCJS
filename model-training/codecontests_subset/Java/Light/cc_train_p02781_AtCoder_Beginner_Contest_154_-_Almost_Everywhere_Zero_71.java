import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            String N = sc.next();
            int K = sc.nextInt();

            long ans = main(N, K);

            System.out.println(ans);
        }
    }

    static long main(String N, int K) {
        long ans = calc(N.length() - 1, K);

        int n = Integer.parseInt(N.substring(0, 1));

        if (K == 1) {
            ans += n;
        } else {
            if (n > 1) {
                ans += calc(N.length() - 1, K - 1) * (n - 1);
            }
            for (int i = 1; i < N.length(); i++) {
                if (N.charAt(i) != '0') {
                    ans += main(N.substring(i), K - 1);
                    break;
                }
            }
        }

        return ans;
    }

    static long calc(int M, int K) {
        long ans = 0;

        for (int i = 1; i <= M; i++) {
            if (K == 1) {
                ans += comb(i - 1, i - 1) * 9;
            } else if (K == 2) {
                ans += comb(i - 1, i - 2) * 9 * 9;
            } else if (K == 3) {
                ans += comb(i - 1, i - 3) * 9 * 9 * 9;
            }
        }

        return ans;
    }

    static long comb(int a, int b) {
        if (b < 0) {
            return 0;
        }

        if (b > a - b) {
            b = a - b;
        }

        long x = 1;
        for (int i = 0; i < b; i++) {
            x *= (a - i);
        }
        for (int i = 0; i < b; i++) {
            x /= (1 + i);
        }

        return x;
    }

}
