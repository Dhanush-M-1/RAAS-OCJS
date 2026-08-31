import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.sort(A);
        long sum = 0;
        int[] B = new int[n];
        for (int i = 0; i < n - 1; i++) {
            B[i] = Math.abs(A[i] - A[i + 1]);
            sum += B[i];
        }
        int length = n / k;
        int b1 = n % k;
        int a1 = k - b1;
        long[][] min = new long[a1 + 1][b1 + 1];
        for (int i = 1; i <= a1; i++) {
            min[i][0] = min[i - 1][0] + B[length * i - 1];
        }
        for (int i = 1; i <= b1; i++) {
            min[0][i] = min[0][i - 1] + B[(length + 1) * i - 1];
        }
        for (int i = 1; i <= a1; i++) {
            for (int j = 1; j <= b1; j++) {
                min[i][j] = Math.max(min[i - 1][j], min[i][j - 1]) + B[length * (i + j) + j - 1];
            }
        }
        System.out.println(sum - min[a1][b1]);
    }
}
