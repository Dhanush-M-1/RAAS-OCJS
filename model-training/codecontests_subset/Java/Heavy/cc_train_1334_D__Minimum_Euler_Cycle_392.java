import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumEulerCycle {

        static long getValue(long n, long input, long i) {
            long head;
            if (input == n * (n - 1) + 1) {
                return 1;
            }
            if (i == 1) {
                head = 0;
            } else
                head = (i - 1) * (4 * n - 2 * i) / 2;
            long offset = (input - head);
            long value = offset % 2 != 0 ? i : i + offset / 2;
            return value;
        }

        static long getBlock(long n, long input) {
            if ((2 * n - 2) >= input) {
                return 1;
            }
            double a = Math.ceil((-Math.sqrt(Math.pow(n, 2) * 4 - 4 * n - 4 * input + 1) + 2 * n - 1) / 2);
//            double b = Math.floor((-Math.sqrt(Math.pow(n, 2) * 4 - 4 * n - 4 * input + 1) + 2 * n + 1) / 2);
            return (long)a;
        }

        static void check(long n, long l, long r) {
            for (long i = l; i <= r; i++) {
                long block = getBlock(n, i);
                long value = getValue(n, i, block);
                System.out.print(value + " ");
            }
        }


        public static void main(String[] args) {
            int n;
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            long k, l, r;
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                k = sc.nextLong();
                l = sc.nextLong();
                r = sc.nextLong();
                check(k, l, r);
                sc.nextLine();
            }
        }


}
