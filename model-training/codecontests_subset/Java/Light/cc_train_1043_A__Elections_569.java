//package Round519_Div2;

import java.util.Scanner;

public class A_Elections {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int sumVotes = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (x > max) max = x;
            sumVotes += x;
        }
        int i = max;
        while (1 == 1) {
            if (i * n > 2 * sumVotes) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
