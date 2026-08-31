
import java.util.Scanner;

public class A143 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] sums = new int[6];
        for (int i = 0; i < 6; i++) {
            sums[i] = in.nextInt();
        }
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (i + j == sums[0] && k + l == sums[1] && i + k == sums[2] && j + l == sums[3] && i + l == sums[4] && j + k == sums[5]) {
                            if (i != j && j != k && k != l && i != k && i != l && j != l) {
                                System.out.println(i + " " + j);
                                System.out.println(k + " " + l);
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
