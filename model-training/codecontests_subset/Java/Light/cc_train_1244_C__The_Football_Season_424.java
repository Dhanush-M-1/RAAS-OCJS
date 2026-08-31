import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeForces592C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long p = scanner.nextLong();
        int w = scanner.nextInt();
        int d = scanner.nextInt();
        long nwp = n * w - p;
        int wd = w - d;
        long gcd = gcd(w, d);
        if (nwp < 0 || p % gcd != 0) {
            System.out.println(-1);
            return;
        }
        for (long z = 0; z <= n; z++) {
            long kz = nwp - z * w;
            long ky = nwp - z * wd;
            if (kz < 0 || ky < 0) {
                System.out.println(-1);
                return;
            }
            if (kz % wd == 0 && kz / wd + z <= n) {
                System.out.println((n - kz / wd - z) + " " + kz / wd + " " + z);
                return;
            }
            if (ky % w == 0 && ky / w + z <= n) {
                System.out.println((n - z - ky / w) + " " + z + " " + ky / w);
                return;
            }

        }
        System.out.println(-1);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

}