import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
        a = a * 2;
        b = b * 2;
        int c1 = (x1 + y1);
        int d1 = c1 / a;
        int c2 = (x2 + y2);
        int d2 = c2 / a;
        if (x1 + y1 > 0) d1++;
        if (x2+y2 > 0) d2++;
        int x = Math.abs(d1-d2);
        c1 = (x1 - y1);
        d1 = c1 / b;
        c2 = (x2 - y2);
        d2 = c2 / b;
        if (x1-y1 > 0)
            d1++;
        if (x2-y2 >0)
            d2++;
        int y = Math.abs(d1-d2);
        System.out.println(Math.max(x, y));
    }
}