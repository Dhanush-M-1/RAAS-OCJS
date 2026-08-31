import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int r1 = cin.nextInt();
        int r2 = cin.nextInt();
        int c1 = cin.nextInt();
        int c2 = cin.nextInt();
        int d1 = cin.nextInt();
        int d2 = cin.nextInt();
        boolean ok = false;
        for (int a = 1; a <= 9; ++a)
            for (int b = 1; b <= 9; ++b)
                for (int c = 1; c <= 9; ++c)
                    for (int d = 1; d <= 9; ++d) {
                        if (a == b || a == c || a == d) continue;
                        if (b == c || b == d) continue;
                        if (c == d) continue;
                        if (r1 == a + b && r2 == c + d && d1 == a + d && d2 == b + c && c1 == a + c && c2 == b + d) {
                            System.out.println(a + " " + b);
                            System.out.println(c + " " + d);
                            ok = true;
                        }
                        if (ok) System.exit(0);
                    }
        if (!ok) System.out.println(-1);
    }
}