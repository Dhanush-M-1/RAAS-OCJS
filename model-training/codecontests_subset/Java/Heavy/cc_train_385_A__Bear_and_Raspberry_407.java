import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    private static final InputStreamReader standardInput = new InputStreamReader(System.in);
    private static final BufferedReader bufferedReader = new BufferedReader(standardInput);
    private static final Scanner scanner = new Scanner(bufferedReader);

    private static final OutputStreamWriter standardOutput = new OutputStreamWriter(System.out);
    private static final BufferedWriter bufferedWriter = new BufferedWriter(standardOutput);
    private static final PrintWriter printWriter = new PrintWriter(bufferedWriter);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        printWriter.println(getMaxProfix(n, c, x));
        printWriter.flush();
        scanner.close();
    }

    private static int getMaxProfix(int n, int c, int[] x) {
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            int profit = x[i];
            profit -= x[i + 1];
            profit -= c;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
