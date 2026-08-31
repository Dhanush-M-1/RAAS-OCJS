import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class A102 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter w = new PrintWriter(System.out, true);

    static int ni() {
        return in.nextInt();
    }

    static String nl() {
        return in.nextLine();
    }

    public static void main(String[] args) {
        int r1 = ni(), r2 = ni(), c1 = ni(), c2 = ni(), d1 = ni(), d2 = ni();
        int a, c, d;
        for (int b = 1; b < 10; b++) {
            a = r1 - b;
            c = c1 - a;
            d = c2 - b;
            if (a <= 0 || c <= 0 || d <= 0 || a > 9 || c > 9 || d > 9) continue;
            if (c+d != r2 || a + d != d1 || c+b != d2) continue;
            if (a==b || a == c || a == d || b == c || b == d || c==d) continue;
            w.println(a + " " + b);
            w.println(c + " " + d);
            return;
        }
        w.println(-1);
    }
}
