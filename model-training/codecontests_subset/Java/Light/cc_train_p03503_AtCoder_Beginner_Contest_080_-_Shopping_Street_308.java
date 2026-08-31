import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int f[][] = new int[n][10];
        int p[][] = new int[n][11];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                f[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                p[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        sc.close();

        int min = Integer.MIN_VALUE;
        for (int i = 1; i < (1 << 10); i++) {
            int cc = 0;
            for (int j = 0; j < n; j++) {
                int c = 0;
                for (int k = 0; k < 10; k++){
                    if ((i >> k & 1) == 1 && f[j][9 - k] == 1) {
                        c++;
                    }
                }
                cc += p[j][c];
            }
            if (min < cc) {
                min = cc;
            }
        }
        System.out.println(min);
    }
}