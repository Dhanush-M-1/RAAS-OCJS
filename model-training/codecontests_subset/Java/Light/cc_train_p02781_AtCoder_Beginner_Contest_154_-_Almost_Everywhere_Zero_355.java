
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    static Scanner sc = null;
    static PrintWriter pw = null;

    static {

        try {
            sc = new Scanner(System.in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        String x = sc.nextLine();
        int a = sc.nextInt();
        switch (a) {
            case 1:
                System.out.println(p1(x));
                break;
            case 2:
                System.out.println(p2(x));
                break;
            case 3:
                System.out.println(p3(x));
                break;
        }

    }

    private static final String r0(String s) {
        if (s.length() == 0) return s;
        if (s.charAt(0) == '0') return r0(s.substring(1));
        return s;
    }

    private static long p1(String a) {
        a = r0(a);
        if (a.length() < 1) return 0;

        return 9 * (a.length() - 1) + (a.charAt(0) - '0');
    }

    private static long p2(String a) {
        a = r0(a);
        if (a.length() < 2) return 0;

        int rr = a.length() - 1;


        return 9 * 9 * rr * (rr - 1) / 2 + p1(a.substring(1)) + (a.charAt(0) - '1') * 9 * rr;
    }

    private static long p3(String a) {
        a = r0(a);
        if (a.length() < 3) return 0;

        int rr = a.length() - 1;

        return 9 * 9 * 9 * rr * (rr - 1) * (rr - 2) / 6 + p2(a.substring(1)) + (a.charAt(0) - '1') * 9 * 9 * rr * (rr - 1) / 2;
    }
}
