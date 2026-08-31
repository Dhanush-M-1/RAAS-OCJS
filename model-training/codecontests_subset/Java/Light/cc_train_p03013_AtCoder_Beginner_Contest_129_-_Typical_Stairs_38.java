import java.util.Scanner;

public class Main {
    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[M];
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(N, M, a));
    }

    public static int solve(int N, int M, int[] a) {
        if (N == 1) return 1;

        int[] nlist = new int[N + 1];
        int aidx = 0;

        nlist[0] = 1;
        if (M != 0 && a[0] == 1) {
            nlist[1] = 0;
            aidx = 1;
        } else {
            nlist[1] = 1;
        }

        for (int i = 2; i <= N; i++) {
            if (aidx < M && a[aidx] == i) {
                nlist[i] = 0;
                aidx++;
            } else {
                nlist[i] = (nlist[i - 1] + nlist[i - 2]) % MOD;
            }
        }

        return nlist[N];
    }
}