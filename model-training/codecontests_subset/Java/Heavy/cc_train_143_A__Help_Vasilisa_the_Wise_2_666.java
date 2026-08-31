import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[][] = new int[3][2];
        int x, y, z, w;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        x = ((a[0][0] - a[1][1]) + a[2][0]) / 2;
        y = ((a[0][0] - a[1][0]) + a[2][1]) / 2;
        z = ((a[1][0] - a[0][0]) + a[2][1]) / 2;
        w = ((a[0][1] - a[1][0]) + a[2][0]) / 2;
        boolean c = (x == y || x == z || x == w || y == w || y == z || w == z)
                || ((x < 1 || x > 9) || (y < 1 || y > 9) || (z < 1 || z > 9) || (w < 1 || w > 9))
                ||((a[0][0]+a[0][1])!=(a[1][0]+a[1][1])||(a[0][0]+a[0][1])!=(a[2][0]+a[2][1]));
        if (c) {
            System.out.println(-1);
        } else {

        System.out.println(x + " " + y);
        System.out.println(z + " " + w);
    }

    }
}