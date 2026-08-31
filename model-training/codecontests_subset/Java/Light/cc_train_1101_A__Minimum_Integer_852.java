import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(solve(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }

    }

    private static int solve(int l, int r, int d) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (l <= d * i && d * i <= r) {
                i = r / d;
                continue;
            }
            return d * i;
        }
        return -1;
    }
}