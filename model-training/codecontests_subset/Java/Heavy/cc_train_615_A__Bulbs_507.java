
import java.util.Scanner;

/**
 *
 * @author Muhammad
 */
public class Bulbs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] a = new boolean[m + 1];
        a[0]=true;
        for (int i = 0; i < n; i++) {
            for (int j = in.nextInt(); j > 0; j--) {
                a[in.nextInt()] = true;
            }
        }
        for (boolean b : a) {
            if(!b){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
