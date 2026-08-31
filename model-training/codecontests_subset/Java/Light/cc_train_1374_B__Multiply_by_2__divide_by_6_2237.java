

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            int a = input.nextInt();
            int count2 = 0, count3 = 0;
            while (a % 2 == 0) {
                a = a / 2;
                count2++;
            }
            while (a % 3 == 0) {
                a = a / 3;
                count3++;
            }
            if (a != 1 || count3 < count2) {
                System.out.println("-1");
            } else {
                System.out.println((count3 - count2) + count3);
            }
        }

    }
}
