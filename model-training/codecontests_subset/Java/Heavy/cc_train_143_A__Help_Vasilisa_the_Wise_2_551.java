import java.util.Scanner;


public class P4 {

    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);

        int[][] a = new int[3][2];
        int[] b = new int[4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = n.nextInt();
            }
        }
        if (a[1][1] + a[1][0] - a[0][0] - a[0][1] != 0 || a[2][0] + a[2][1] - a[0][0] - a[0][1] != 0) {
            System.out.print(-1);
        } else {

            b[0] = (a[0][0] - a[2][1] + a[1][0]) / 2;

            b[1] = a[0][0] - b[0];
            b[2] = a[1][0] - b[0];
            b[3] = a[2][0] - b[0];

            int u = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((i != j && b[i] == b[j]) || b[j] < 1 || b[j] > 9) {
                        u = 1;
                        i = 4;
                        j = 4;
                    }
                }
            }

            if (u == 0) {
                System.out.println(b[0] + " " + b[1]);
                System.out.print(b[2] + " " + b[3]);
            } else {
                System.out.print(-1);
            }
        }
    }
}
