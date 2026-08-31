import java.util.Scanner;

public class Dicrim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double eps = 0.0000000001;
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double d = Math.pow(b, 2) - 4.0 * a * c;
        if (a != 0.0) {
            if (d < 0.0) {
                System.out.println("0");
            } else if (Math.abs(d) < eps) {
                System.out.println("1");
                double result = -b / (2 * a);
                System.out.println(result);
            } else {
                System.out.println("2");
                double result1 = (-b + Math.sqrt(d)) / (2 * a);
                double result2 = (-b - Math.sqrt(d)) / (2 * a);
                if (result1 < result2) {
                    System.out.println(result1);
                    System.out.println(result2);
                } else {
                    System.out.println(result2);
                    System.out.println(result1);
                }
            }
        } else {
            if (b != 0.0) {
                System.out.println("1");
                double result = -c / b;
                System.out.println(result);
            } else {
                if (c != 0.0) {
                    System.out.println("0");
                } else {
                    System.out.println("-1");
                }
            }
        }
    }

}
