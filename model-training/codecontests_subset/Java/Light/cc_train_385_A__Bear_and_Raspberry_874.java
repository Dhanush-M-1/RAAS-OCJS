import java.util.Scanner;
import java.util.stream.IntStream;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        int earn = Math.max(0, IntStream.range(1, n).map(i -> prices[i - 1] - prices[i] - c).max().getAsInt());
        System.out.println(earn);

    }
}
