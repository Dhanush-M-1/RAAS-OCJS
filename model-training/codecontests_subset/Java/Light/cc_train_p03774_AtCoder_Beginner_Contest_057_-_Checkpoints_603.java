import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] a = new int[N];
            int[] b = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
            }
            int[] c = new int[M];
            int[] d = new int[M];
            for (int i = 0; i < M; i++) {
                c[i] = in.nextInt();
                d[i] = in.nextInt();
            }

            for (int n = 0; n < N; n++) {
                int minDistance = (int) 1e9;
                int minM = -1;
                for (int m = 0; m < M; m++) {
                    int distance = Math.abs(a[n] - c[m]) + Math.abs(b[n] - d[m]);
                    if (distance < minDistance) {
                        minDistance = distance;
                        minM = m;
                    }
                }
                System.out.println(minM + 1);
            }
        }
    }
}
