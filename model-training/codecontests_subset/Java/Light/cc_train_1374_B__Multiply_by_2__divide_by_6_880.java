
import java.util.*;
import javafx.util.*;

public class Master {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        while (T-- > 0) {
            long n = in.nextInt();
            int th = 0;
            int two = 0;

            while (n % 2 == 0 || n % 3 == 0) {
                if (n % 2 == 0) {
                    two++;
                    n /= 2;
                }
                if (n % 3 == 0) {
                    th++;
                    n /= 3;
                }
            }
            if (n == 1) {
                if (th == two) {
                    System.out.println(th);
                } else {
                    if (th > two) {
                        int dif = th - two;
                        System.out.println(dif + th);
                    } else {
                        System.out.println("-1");
                    }
                }
            } else {
                System.out.println("-1");
            }
        }
    }

}
