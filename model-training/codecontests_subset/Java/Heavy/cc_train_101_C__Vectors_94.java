
import java.util.Scanner;

public class E {
    public static boolean solve(long x, long y, long c, long d) {
        if (x == 0 && y == 0)
            return c == 0 && d == 0;
        if (x == 0)
            return c % y == 0 && d % y == 0;
        if (y == 0)
            return c % x == 0 && d % x == 0;
        if ((c * x + d * y) % (x * x + y * y) != 0)
            return false;
        long a = (c * x + d * y) / (x * x + y * y);
        return (d - a * y) % x == 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long ax = in.nextInt();
        long ay = in.nextInt();
        long bx = in.nextInt();
        long by = in.nextInt();
        long cx = in.nextInt();
        long cy = in.nextInt();
        if (solve(cx, cy, bx - ax, by - ay) || solve(cx, cy, bx - ay, by + ax)
                || solve(cx, cy, bx + ax, by + ay)
                || solve(cx, cy, bx + ay, by - ax))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
