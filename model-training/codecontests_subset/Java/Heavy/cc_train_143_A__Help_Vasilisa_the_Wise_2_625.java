import java.util.Arrays;
import java.util.Scanner;
public class Comp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r1 = input.nextInt();
        int r2 = input.nextInt();
        int c1 = input.nextInt();
        int c2 = input.nextInt();
        int d1 = input.nextInt();
        int d2 = input.nextInt();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        if (i + j == r1 && k + l == r2 && k + i == c1 && l + j == c2 && l + i == d1 && k + j == d2 && i != j && i != k && i != l && j != k && j != l && k != l) {
                            System.out.println(i + " " + j);
                            System.out.println(k + " " + l);
                            System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}