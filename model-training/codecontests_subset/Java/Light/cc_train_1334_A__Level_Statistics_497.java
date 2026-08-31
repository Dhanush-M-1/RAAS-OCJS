import java.util.Scanner;

public class Application {

    static boolean check(Scanner scanner) {
        int p1, p2, c1, c2;
        int n = scanner.nextInt();
        boolean ans = true;
        p2 = 0; c2 = 0;

        for (int i = 0; i < n; ++i) {
            p1 = p2; c1 = c2;
            p2 = scanner.nextInt();
            c2 = scanner.nextInt();
            if (c2 > p2 || c2 < c1 || p2 < p1 || c2-c1 > p2-p1) {
                ans = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; ++i) {
            if (check(scanner)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
