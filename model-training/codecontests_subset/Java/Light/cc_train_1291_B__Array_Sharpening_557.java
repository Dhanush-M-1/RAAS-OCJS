//package Round616;

import java.util.Scanner;

/**
 * @author sguar <shugangcao@gmail.com>
 * welcome to kuaishou
 * Created on 2020-02-07
 */
public class B {
    public static void main(String[] args) {
        new B().run();
    }

    private void run() {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        while (T > 0) {
            T--;
            int n = cin.nextInt();
            boolean ok = true;
            int last = -1;
            for (int i = 1; i <= n; i++) {
                int x = cin.nextInt();
                if (x < Math.min(i - 1, n - i)) {
                    ok = false;
                } else if (x == Math.min(i - 1, n - i)) {
                    if (last == x) {
                        ok = false;
                    } else {
                        last = x;
                    }
                } else {
                    last = -1;
                }
            }
            if (ok) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
