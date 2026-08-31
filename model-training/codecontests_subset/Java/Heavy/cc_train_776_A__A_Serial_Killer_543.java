import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alvindeng on 2/23/17.
 */
public class Codeforces_round_400_div_2_ASerialKiller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] info = input.nextLine().split(" ");
        String a = info[0];
        String b = info[1];
        int n = input.nextInt();
        input.nextLine();
        System.out.println(a + " " + b);
        for (int i = 0; i < n; i++) {
            String[] pair = input.nextLine().split(" ");
            if (a.equals(pair[0])) {
                a = pair[1];
            } else if (b.equals(pair[0])) {
                b = pair[1];
            }
            System.out.println(a + " " + b);
        }
    }
}
