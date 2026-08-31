import java.util.Scanner;

/**
 * Created by Saksham on 9/7/2015.
 */
public class BearAndRaspberry {
    public static void main (String []args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] price = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            if (max < (price[i] - price[i + 1])) {
                max = price[i] - price[i + 1];
            }
        }
        if (max - c > 0) {
            System.out.println(max - c);
        } else {
            System.out.println(0);
        }
    }
}
