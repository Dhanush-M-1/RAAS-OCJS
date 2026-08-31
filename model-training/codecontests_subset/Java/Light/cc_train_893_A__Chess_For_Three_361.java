
import java.util.Scanner;

/**
 *
 * @author rn-sshawish
 */
public class Solutions {

    public static void main(String[] args) {

        int notPlay = 3;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int win = input.nextInt();
            if (win == notPlay) {
                System.out.println("NO");
                return;
            }
            notPlay = getNotPlay(win, notPlay);
        }
        System.out.println("YES");
    }

    public static int getNotPlay(int win, int previousNotPlay) {
        if (win == 1 && previousNotPlay == 3) {
            return 2;
        } else if (win == 2 && previousNotPlay == 3) {
            return 1;
        } else if (win == 1 && previousNotPlay == 2) {
            return 3;
        } else if (win == 3 && previousNotPlay == 2) {
            return 1;
        } else if (win == 2 && previousNotPlay == 1) {
            return 3;
        } else {
            return 2;
        }

    }
}
