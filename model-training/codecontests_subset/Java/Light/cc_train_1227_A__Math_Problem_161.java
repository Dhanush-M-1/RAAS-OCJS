
import java.util.Scanner;

/**
 *
 * @author Фёдор
 */
public class JavaApplication84 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int lmax = 0;
            int rmin = 2000000000;
            for (int j = 0; j < n; j++) {
                int l = in.nextInt();
                int r = in.nextInt();
                lmax = Math.max(lmax, l);
                rmin = Math.min(rmin, r);
            }
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            if (lmax - rmin >= 0) {
                System.out.println(Math.abs(rmin - lmax));
            }else{
                System.out.println(0);
            }
        }
    }

}
