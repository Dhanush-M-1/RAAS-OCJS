
import java.util.Scanner;

/**
 *
 * @author Aly Taha
 */
public class NewClass {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        int n = k.nextInt();
        int m = k.nextInt();
        int l = k.nextInt();
        double res = (double) l / 100;
        double res2 = res * n;
        double res3;
        if (res2 == (int) res2) {
            res3 = res2 - m;
        } else {
            res2 = res2 + (1 - (res2 - (int) res2));
            res3 = res2 - m;
        }
        if (res3 < 0) {
            System.out.println(0);
        } else {
            System.out.println((int)res3);
        }
    }
}
