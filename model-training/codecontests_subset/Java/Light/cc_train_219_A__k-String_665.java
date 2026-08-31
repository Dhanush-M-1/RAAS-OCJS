
import java.util.Scanner;

/**
 *
 * @author Muhammad
 */
public class KString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int[] all = new int[26];
        for (char a : s.toCharArray()) {
            int x = (a - 'a');
            all[x]++;
        }
        String p = "";
        for (int i = 0; i < all.length; i++) {
            if (all[i] % n != 0) {
                System.out.println(-1);
                return;
            }
            for (int j = 0; j < all[i] / n; j++) {
                p += (char) (i + 'a');
            }
        }
        s = "";
        for (int i = 0; i < n; i++) {
            s += p;
        }
        System.out.println(s);

    }

}
