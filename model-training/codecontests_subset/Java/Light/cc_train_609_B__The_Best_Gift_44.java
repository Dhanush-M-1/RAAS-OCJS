import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < n; i++) {
            int g = scanner.nextInt();
            arr[g - 1]++;
        }
        int res = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                res += arr[i] * arr[j];
            }
        }
        System.out.println(res);
    }
}
