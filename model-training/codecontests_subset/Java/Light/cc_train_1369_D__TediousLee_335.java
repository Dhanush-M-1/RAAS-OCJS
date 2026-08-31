import java.util.Scanner;

public class Main {

    public static final int MOD = (int) (1e9 + 7);
    public static final int N = (int) (2e6);

    public static long[] answer = new long[N + 1];

    public static void main(String[] args) {
        // write your code here

        initAnswer();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) solve(scanner);
    }

    private static void initAnswer() {
        for (int i = 0; i < answer.length; i++) {
            if (i > 3)
                answer[i] = (2 * answer[i - 2] + answer[i - 1] + (i % 3 == 0 ? 1 : 0)) % MOD;
            else if (i == 3) answer[i] = 1;
            else answer[i] = 0;
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        System.out.println((answer[n] * 4) % MOD);
    }
}
