
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();
        int r2 = in.nextInt();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        int d1 = in.nextInt();
        int d2 = in.nextInt();
        int v1, v2, v3, v4;    /*    v1  v2
                                     v3  v4      shape of square */

        for (int i = 1; i <= r1; i++) {
            v1 = r1 - i;
            v2 = r1 - v1;
            if (v1 + v2 == r1) {
                v3 = c1 - v1;
                v4 = c2 - v2;
                if (v3 + v4 == r2 && v1 + v3 == c1 && v2 + v4 == c2 && v1 + v4 == d1 && v2 + v3 == d2) {
                    if (v1 != v2 && v1 != v3 && v1 != v4 && v2 != v3 && v2 != v4
                            && v3 != v4 && v1 < 10 && v1 > 0 && v2 > 0 && v3 > 0 && v4 > 0 && v2 < 10 && v3 < 10 && v4 < 10) {
                        System.out.println(v1 + " " + v2 + "\n" + v3 + " " + v4);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
