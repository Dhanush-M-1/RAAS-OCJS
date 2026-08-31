import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();
        boolean a = false, b = false;
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            if (word.equals(password)) {
                System.out.println("YES");
                return;
            }
            if (word.charAt(1) == password.charAt(0)) {
                a = true;
            }
            if (word.charAt(0) == password.charAt(1)) {
                b = true;
            }
        }
        System.out.println(a && b ? "YES" : "NO");
    }
}
