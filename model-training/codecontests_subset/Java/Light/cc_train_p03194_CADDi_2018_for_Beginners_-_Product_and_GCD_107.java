import java.util.Scanner;

public class Main {

    public static long solve(long N, long P) {
        if (N == 1) return P;

        long M = (long) Math.round(Math.pow(P, 1.0 / N));
        while (M > 1) {
            long a = (long) Math.pow(M, N);
            if (P % a == 0) {
                break;
            }
            M -= 1;
        }
        return M;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long P = sc.nextLong();

        System.out.println(solve(N, P));
    }
}
