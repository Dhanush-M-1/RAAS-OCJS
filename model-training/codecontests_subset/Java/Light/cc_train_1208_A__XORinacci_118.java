import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by AMK on 8/20/2019.
 * Life is nice :)
 * Enjoy coding :D
 */
public class MyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            int n = scanner.nextInt();
            if (n == 0){
                System.out.println(a);
            }else if (n == 1){
                System.out.println(b);
            }else {
                long aa = a ^ b;
                long ab = aa ^ b;
                long ac = ab ^ aa;
                if (n % 3 == 0) {
                    System.out.println(ab);
                } else if (n % 3 == 1) {
                    System.out.println(ac);
                } else {
                    System.out.println(aa);
                }
            }
        }
    }
}