
import java.util.Scanner;

public class BestGift {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] genres = new int[m];
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            genres[b - 1] ++;
        }

        int sum = 0;
        for (int i = 0; i < m - 1; i++)
            for (int j = i + 1; j < m; j++)
                sum += genres[i] * genres[j];

        System.out.println(sum);
    }
}
