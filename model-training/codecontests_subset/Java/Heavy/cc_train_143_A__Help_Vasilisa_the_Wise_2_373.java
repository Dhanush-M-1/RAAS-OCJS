

import java.util.Scanner;

/**
 *
 * @author LYT
 */
public class CodeForces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int r1 = 0, r2 = 0, c1 = 0, c2 = 0, d1 = 0, d2 = 0;
        int[] x = new int[4];//i,j,k,l
        for (int i = 0; i < 4; i++) {
            x[i] = -1;
        }

        Scanner scanner = new Scanner(System.in);
        r1 = scanner.nextInt();
        r2 = scanner.nextInt();
        c1 = scanner.nextInt();
        c2 = scanner.nextInt();
        d1 = scanner.nextInt();
        d2 = scanner.nextInt();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        if ((i != j && j != k && k != l && i != k && i != l && j != l) && (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 && i + l == d1 && j + k == d2)) {
                            x[0] = i;
                            x[1] = j;
                            x[2] = k;
                            x[3] = l;
                        }
                    }
                }
            }
        }

        if (x[0] != -1) {
            System.out.println(x[0] + " " + x[1] + "\n" + x[2] + " " + x[3]);
        } else {
            System.out.println("-1");
        }



    }
}
