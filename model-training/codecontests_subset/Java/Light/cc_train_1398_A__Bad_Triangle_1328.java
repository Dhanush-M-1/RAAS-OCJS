import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            long a1 = scanner.nextLong(), a2 = scanner.nextLong();
            for (int i = 2; i < n - 1; i++) {
                scanner.nextInt();
            }
            long an = scanner.nextLong();
            if (a1 + a2 <= an) {
                System.out.println(String.format("1 2 %d", n));
            } else {
                System.out.println(-1);
            }
        }
    }
}