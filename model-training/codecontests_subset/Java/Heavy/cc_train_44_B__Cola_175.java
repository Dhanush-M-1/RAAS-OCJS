import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Cola {

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);

        int n = r.nextInt();
        int a = r.nextInt();
        int b = r.nextInt();
        int c = r.nextInt();

        int ways = 0;

        for (int i = 0; i <= a; i += 2) {
            for (int j = 0; j <= c; j++) {
                int rem = (int) (n - ((i * 0.5) + (2 * j)));
                if (rem == 0) {
                    ways++;
                } else if (rem > 0 && rem <= b) {
                    ways++;
                }
            }
        }

        System.out.println(ways);
    }
}
