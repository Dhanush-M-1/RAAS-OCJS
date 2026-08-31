import java.util.Scanner;

/**
 * Created by tdph5945 on 2016-06-18.
 */
public class HelpVasilisaTheWise2 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        int r1 = scanner.nextInt(), r2 = scanner.nextInt();
        int c1 = scanner.nextInt(), c2 = scanner.nextInt();
        int d1 = scanner.nextInt(), d2 = scanner.nextInt();

        for (int i1 = 1; i1 < 10; i1++) {
            for (int i2 = 1; i2 < 10; i2++) {
                if (i1 == i2) {
                    continue;
                }
                for (int i3 = 1; i3 < 10; i3++) {
                    if (i1 == i3 || i2 == i3) {
                        continue;
                    }
                    for (int i4 = 1; i4 < 10; i4++) {
                        if (i1 == i4 || i2 == i4 || i3 == i4) {
                            continue;
                        }
                        boolean b1 = r1 == i1 + i2;
                        boolean b2 = r2 == i3 + i4;
                        boolean b3 = c1 == i1 + i3;
                        boolean b4 = c2 == i2 + i4;
                        boolean b5 = d1 == i1 + i4 ;
                        boolean b6 = d2 == i3 + i2;
                        if (b1 && b2 && b3 && b4 && b5 && b6) {
                            System.out.println(i1 + " " + i2);
                            System.out.println(i3 + " " + i4);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
