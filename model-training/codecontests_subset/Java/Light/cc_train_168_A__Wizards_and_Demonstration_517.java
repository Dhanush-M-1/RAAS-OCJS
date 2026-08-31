import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextInt();
        double x = scanner.nextInt();
        double y = scanner.nextInt();

        double ans;
        ans = (n / 100) * y - x;

        if (ans < 0) System.out.println(0);
        else {
            if (ans - (int) ans == 0) System.out.println((int) ans);
            else System.out.println((int) ans + 1);
        }
    }
}
