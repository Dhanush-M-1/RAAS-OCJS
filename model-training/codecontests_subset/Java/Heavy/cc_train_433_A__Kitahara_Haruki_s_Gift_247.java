
import java.util.Scanner;

public class KitaharaHarukisGift {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int o = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            int in = scan.nextInt();
            if (in == 100) {
                ++o;
            } else {
                ++t;
            }
        }
        int u = t % 2;
        if (u == 1 && o >= 2 && o % 2 == 0) {
            System.out.println("YES");
        } else if (u == 0 && o % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
