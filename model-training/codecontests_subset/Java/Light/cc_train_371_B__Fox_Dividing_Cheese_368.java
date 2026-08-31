import java.util.Scanner;

/**
 * Created by IgorK on 13.12.13.
 */
public class Codeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] a = new int[3];
        int[] b = new int[3];

        int result = 0, xprev = 0, yprev = 0;

        if (x == y) {
            System.out.println(0);
            return;
        }

        while (x != xprev) {
            xprev = x;
            if (x % 2 == 0) {
                a[0]++;
                x /= 2;
            }
            if (x % 3 == 0) {
                a[1]++;
                x /= 3;
            }
            if (x % 5 == 0) {
                a[2]++;
                x /= 5;
            }
        }

        while (y != yprev) {
            yprev = y;
            if (y % 2 == 0) {
                b[0]++;
                y /= 2;
            }
            if (y % 3 == 0) {
                b[1]++;
                y /= 3;
            }
            if (y % 5 == 0) {
                b[2]++;
                y /= 5;
            }
        }

        if (x != y) {
            System.out.println(-1);
            return;
        }


        for (int i = 0; i < 3; i++)
            result += Math.abs(a[i] - b[i]);

        System.out.println(result);
    }
}
