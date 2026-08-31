import java.util.Scanner;


public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long t = x1;
        x1 = x1+y1;
        y1 = t-y1;
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();
        t = x2;
        x2 = x2+y2;
        y2 = t-y2;
        if (x1 > x2) {
            t = x1;
            x1 = x2;
            x2 = t;
        }
        if (y1 > y2) {
            t = y1;
            y1 = y2;
            y2 = t;
        }
        a *= 2;
        b *= 2;
        long q = (long) -3e9;
        q += -(q % a);
        long hor = (x2+q)/a-(x1+q)/a;
        q = (long) -3e9;
        q += -(q % b);
        long ver = (y2+q)/b-(y1+q)/b;
        System.out.println(Math.max(hor, ver));
    }
}
