import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] p = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = in.nextInt() - 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (p[i] == i) {
                    if (i + 1 < N) {
                        int swap = p[i];
                        p[i] = p[i + 1];
                        p[i + 1] = swap;
                        count++;
                    } else {
                        int swap = p[i];
                        p[i] = p[i - 1];
                        p[i - 1] = swap;
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
