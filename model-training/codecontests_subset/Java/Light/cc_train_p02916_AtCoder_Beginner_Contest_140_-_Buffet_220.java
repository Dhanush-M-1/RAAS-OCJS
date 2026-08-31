import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N-1];

        for (int i = 0; i < N; i++) A[i] = scanner.nextInt();
        for (int i = 0; i < N; i++) B[i] = scanner.nextInt();
        for (int i = 0; i < N - 1; i++) C[i] = scanner.nextInt();

        int res = B[A[0] - 1];
        for (int i = 1; i < A.length; i++) {
            res += B[A[i] - 1];
            if (A[i] - A[i - 1] == 1) res += C[A[i - 1] - 1];
        }

        System.out.println(res);
    }
}
