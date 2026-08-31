import java.util.Scanner;

public class KitaharaHarukiGift {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), w100 = 0, w200 = 0;

        while (n-- > 0) {
            if (scanner.nextInt() == 100) {
                w100 += 1;
            } else {
                w200 += 1;
            }
        }
        if (w100 % 2 == 1 || (w200 % 2 == 1 && w100 == 0)) {
            System.out.println("NO");
            return;
        } else {
            System.out.println("YES");
        }
    }
}
