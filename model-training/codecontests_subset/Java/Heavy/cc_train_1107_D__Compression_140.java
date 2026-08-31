import java.util.Scanner;

public class D {
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        byte a[][] = new byte[n][n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n / 4; j++) {
                short dec = dec(s.charAt(j));
                for (int h = 3; h >= 0; h--) {
                    a[i][4 * j + h] = (byte) (dec % 2);
                    dec /= 2;
                }
            }
        }
        boolean may[] = new boolean[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != a[i - 1][j] || a[j][i] != a[j][i - 1]) {
                    may[i] = true;
                }
            }
        }
        int ans = n;
        for (int i = 1; i < n; i++) {
            if (may[i]) {
                ans = gcd(ans, i);
            }
        }
        System.out.println(ans);
    }

    static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        return gcd(b, a % b);
    }

    static byte dec(char c) {
        if (0 <= c - '0' && c - '0' <= 9) {
            return (byte) (c - '0');
        }
        return (byte) (c - 'A' + 10);
    }
}
