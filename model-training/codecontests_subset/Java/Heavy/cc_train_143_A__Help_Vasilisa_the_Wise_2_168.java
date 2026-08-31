
import java.util.Scanner;

/**
 *
 * @author AdminHP-262
 */
public class HelpVasilisatheWise2 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int r1 = scanner.nextInt();
        int r2 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int d1 = scanner.nextInt();
        int d2 = scanner.nextInt();

        int num1, num2, num3, num4;

        for (int i = 1; i < 10; i++) {
            num1 = i;
            for (int j = 1; j < 10; j++) {
                num2 = j;
                for (int k = 1; k < 10; k++) {
                    num3 = k;
                    for (int l = 1; l < 10; l++) {
                        num4 = l;
                        if ((num1 + num2 == r1) && (num3 + num4 == r2)
                                && (num1 + num4 == d1) && (num2 + num3 == d2)
                                && (num1 + num3 == c1) && (num2 + num4 == c2)) {
                            if (num1 != num2 && num1 != num3 && num1 != num4
                                    && num2 != num3 && num2 != num4 && num3 != num4) {
                                System.out.println(num1 + " " + num2 + "\n" + num3 + " " + num4);
                                return;
                            }

                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
