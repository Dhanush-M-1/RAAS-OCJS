import java.util.Scanner;

public class LevelStatistics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        while (t > 0) {
            int n = input.nextInt();
            int[] p = new int[n];
            int[] c = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = input.nextInt();
                c[i] = input.nextInt();
            }

            boolean f1 = LevelStatistics.inOrder(c, p, n);
            boolean f2 = LevelStatistics.isCLessP(c, p, n);

            if (f1 && f2)
                System.out.println("YES");
            else
                System.out.println("NO");

            t--;
        }
    }

    private static boolean inOrder(int[] c, int[] p, int n) {
        if (n > 1) {
            for (int i = 0; i < n-1; i++) {
                if (c[i] > c[i+1])
                    return false;
                if (p[i] > p[i+1])
                    return false;
                if((p[i+1] - p[i]) < (c[i+1] - c[i]))
                    return false;
            }
        }
        return true;
    }

    private static boolean isCLessP(int[] c, int[] p, int n) {
        for (int i = 0; i < n; i++) {
            if (c[i] > p[i])
                return false;
        }
        return true;
    }
}
