import java.util.Scanner;

public class Main {

    private static final String KEYENCE = "keyence";
    private static final int K_LEN = KEYENCE.length();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();

        scanner.close();

        if (S.equals(KEYENCE)) {
            System.out.println("YES");
            return;
        }

        int length = S.length();
        for (int i = 0; i < K_LEN; i++) {
            String s = S.substring(0, i) + S.substring(length - K_LEN + i, length);
            if (s.equals(KEYENCE)) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
