import java.util.Scanner;

public class CF609B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] ganres = new int[m];
        int[] sums = new int[m];

        for (int i = 0; i < n; i++) {
            int ganre = scanner.nextInt();
            ganres[ganre - 1]++;
        }

        sums[m - 1] = ganres[m - 1];
        for (int i = m - 2; i > 0; i--) {
            sums[i] = sums[i + 1] + ganres[i];
        }

        int result = 0;
        for (int i = 0; i < m - 1; i++) {
            result += ganres[i] * sums[i + 1];
        }
        System.out.println(result);
    }
}