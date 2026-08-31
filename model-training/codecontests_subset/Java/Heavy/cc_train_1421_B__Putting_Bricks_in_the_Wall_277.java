

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String[][] map = new String[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                String[] strings = sc.next().split("");
                for (int j = 1; j <= n; j++) {
                    map[i][j] = strings[j - 1];
                }
            }
            String a = map[1][2];
            String b = map[2][1];
            String c = map[n][n - 1];
            String d = map[n - 1][n];

            int sum = 0;
            int[] x = new int[4];
            int[] y = new int[4];
            int index = 0;
            if (a.equals(b)) {
                if (a.equals(c)) {
                    sum++;
                    x[index] = n;
                    y[index] = n - 1;
                    index++;
                }
                if (a.equals(d)) {
                    sum++;
                    x[index] = n - 1;
                    y[index] = n;
                    index++;
                }
            } else {
                if (b.equals(c) && b.equals(d)) {
                    sum++;
                    x[index] = 2;
                    y[index] = 1;
                    index++;

                } else if (!b.equals(c) && !b.equals(d)) {
                    sum++;
                    x[index] = 1;
                    y[index] = 2;
                    index++;
                } else {
                    sum++;
                    x[index] = 2;
                    y[index] = 1;
                    index++;
                    if (a.equals(c)) {
                        sum++;
                        x[index] = n;
                        y[index] = n - 1;
                        index++;
                    }
                    if (a.equals(d)) {
                        sum++;
                        x[index] = n - 1;
                        y[index] = n;
                        index++;
                    }
                }
            }
            System.out.println(sum);
            for (int i = 0; i < sum; i++) {
                System.out.println(x[i] + " " + y[i]);
            }
        }
    }
}
