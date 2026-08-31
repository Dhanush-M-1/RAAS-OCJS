
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sol = 0;
        int N = sc.nextInt();

        int[] A = new int[N];
        int[] C = new int[N - 1];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            sol += sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            C[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            if (A[i] + 1 == A[i + 1]) {
                sol += C[A[i] - 1];
            }
        }

        System.out.println(sol);
    }
}
