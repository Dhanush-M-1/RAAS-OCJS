/*
    https://codeforces.com/problemset/problem/1374/B
 */

import java.util.Scanner;

public class MultiplyDivide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int num = scanner.nextInt();
            int count2 = 0;
            int count3 = 0;

            while (num % 2 == 0) {
                count2++;
                num /= 2;
            }
            while (num % 3 == 0) {
                count3++;
                num /= 3;
            }
            if (num != 1 || count3 < count2) {
                System.out.println(-1);
                continue;
            }

            System.out.println(2 * count3 - count2);
        }
    }
}
