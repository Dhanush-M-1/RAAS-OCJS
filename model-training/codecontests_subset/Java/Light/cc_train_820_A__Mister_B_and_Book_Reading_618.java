import java.util.Scanner;

public class A {

    private static Scanner in;

    private static int c, v0, v1, a, l;

    private static void solve() {
        c = in.nextInt();
        v0 = in.nextInt();
        v1 = in.nextInt();
        a = in.nextInt();
        l = in.nextInt();

        int numPages = 0;
        int day = 0;
        while (numPages < c) {
            if (day > 0)
                numPages -= l;
            numPages += Math.min(v0 + a * day, v1);
            day++;
        }
        System.out.println(day);
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        solve();
        System.exit(0);
    }

}
