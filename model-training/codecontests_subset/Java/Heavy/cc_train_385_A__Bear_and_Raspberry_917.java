import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) throws IOException {
        try(Scanner scan = new Scanner(System.in);
            PrintWriter print = new PrintWriter(System.out)) {
            final int n = scan.nextInt();
            final int lendCost = scan.nextInt();
            final int[] prices = new int[n];
            for(int i = 0; i < n; ++i) {
                prices[i] = scan.nextInt();
            }
            print.println(findMaxNRasp(prices, lendCost));
        }
    }

    public static int findMaxNRasp(final int[] prices, final int lendPrice) {
        int result = 0;
        for(int i = 0; i + 1 < prices.length; ++i) {
            result = Math.max(result, prices[i] - prices[i + 1] - lendPrice);
        }
        return result;
    }
}
