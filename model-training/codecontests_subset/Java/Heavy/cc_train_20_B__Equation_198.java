
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        long B = in.nextLong();
        long C = in.nextLong();
        if (A == 0) {
            if (B == 0) {
                if (C == 0)
                    System.out.println(-1);
                else
                    System.out.println(0);
            } else {
                System.out.println(1);
                System.out.println(-C * 1.0 / B);
            }
        } else {
            double des = B * B - 4 * A * C;
            if (des < 0) {
                System.out.println(0);
            } else {
                if (des == 0) {
                    System.out.println(1);
                    System.out.println(-B / 2 / A);
                } else {
                    System.out.println(2);
                    if (A > 0) {
                        System.out.println((-B - Math.sqrt(des)) / 2 / A);
                        System.out.println((-B + Math.sqrt(des)) / 2 / A);
                    } else {
                        System.out.println((-B + Math.sqrt(des)) / 2 / A);
                        System.out.println((-B - Math.sqrt(des)) / 2 / A);
                    }
                }
            }
        }
    }
}
