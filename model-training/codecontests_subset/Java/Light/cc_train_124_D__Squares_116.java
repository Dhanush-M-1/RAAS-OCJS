
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong() * 2;
        long b = in.nextLong() * 2;
        long x1 = in.nextLong();
        long y1 = in.nextLong();
        long x2 = in.nextLong();
        long y2 = in.nextLong();
        long s1 = x1 + y1;
        long m1 = x1 - y1;
        long s2 = x2 + y2;
        long m2 = x2 - y2;
        if (s1 < 0)
            s1 -= a;
        if (s2 < 0)
            s2 -= a;
        if (m1 < 0)
            m1 -= b;
        if (m2 < 0)
            m2 -= b;
        s1 /= a;
        s2 /= a;
        m1 /= b;
        m2 /= b;
        System.out.println(Math.max(Math.abs(s1 - s2), Math.abs(m1 - m2)));
    }
}
