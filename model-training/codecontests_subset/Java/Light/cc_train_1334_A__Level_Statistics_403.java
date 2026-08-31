import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] stats = new int[n][2];
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                stats[j][0] = in.nextInt();
                stats[j][1] = in.nextInt();
                if (stats[j][0] < stats[j][1]) {
                    valid = false;
                }
            }
            if (!valid) {
                System.out.println("NO");
            } else {
                for (int j = 1; j < n; j++) {
                    if (stats[j][0] < stats[j - 1][0] || stats[j][1] < stats[j - 1][1] || stats[j][0] - stats[j - 1][0] < stats[j][1] - stats[j - 1][1]) {
                        valid = false;
                        break;
                    }
                }
                System.out.println(valid ? "YES" : "NO");
            }
        }
    }
}