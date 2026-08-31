import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int xx1 = x1 + y1;
        int yy1 = x1 - y1;
        int xx2 = x2 + y2;
        int yy2 = x2 - y2;
        System.out.println(Math.max(divs(xx1, xx2, 2 * a),
                divs(yy1, yy2, 2 * b)));
    }

    public static int divs(int f, int t, int m) {
        int a = t / m;
        int b = f / m;
        int ans = 0;
        if (f % m == 0)
            ans += Math.abs(a - b) + 1;
        else
            ans += Math.abs(a - b);
        if ((long) f * (long)t < 0)
            ans++;
        return ans;
    }
}