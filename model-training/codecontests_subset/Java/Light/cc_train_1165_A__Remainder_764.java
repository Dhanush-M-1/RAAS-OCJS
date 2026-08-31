import java.util.Scanner;

public class SolutionA {

    private static int changes(int n, String num, int x, int y) {
        int count = 0;
        for (int i = 0; i < y; i++) {
            if (num.charAt(n - i - 1) != '0')
                count++;
        }
        if (num.charAt(n - y - 1) != '1')
            count++;
        for (int i = y + 1; i < x; i++) {
            if (num.charAt(n - i - 1) != '0')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String num = scanner.next();
        System.out.println(changes(n, num, x, y));
    }
}
