import java.util.Scanner;

public class Equation {
    
    static void metod() throws Exception {
        Scanner in = new Scanner(System.in);
        double A = in.nextInt();
        double B = in.nextInt();
        double C = in.nextInt();

        if (A == 0) {
            if (B == 0) {
                if (C == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println(1);
                System.out.println(r(-C / B));
            }
        } else {
            if (B * B - 4 * A * C >= 0) {
                double d = Math.sqrt(B * B - 4 * A * C);
                double x1 = (-B + d) / (2 * A);
                double x2 = (-B - d) / (2 * A);
                if (x1 == x2) {
                    System.out.println(1);
                    System.out.println(r(x1));
                } else if (x1 < x2) {
                    System.out.println(2);
                    System.out.println(r(x1));
                    System.out.println(r(x2));
                } else {
                    System.out.println(2);
                    System.out.println(r(x2));
                    System.out.println(r(x1));
                }
            } else {
                System.out.println(0);
            }
        }       
    }
    
    static double r(double a) {
        a = Math.round(a * 1000000);
        return a / 1000000;
    }

    public static void main(String args[]) throws Exception {
        Equation.metod();
    }
}
