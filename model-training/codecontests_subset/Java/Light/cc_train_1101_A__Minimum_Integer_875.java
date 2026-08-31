import java.util.Scanner;

public class CF1101_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scanner);
        }
    }

    private static void solve(Scanner scanner) {
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int n = scanner.nextInt();
        int i = n;
        while (true) {
            if (i < l || i > r) {
                System.out.println(i);
                return;
            } else {
                i = n + r- (r %n);
            }
        }
    }
}
