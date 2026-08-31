import java.util.Scanner;

public class P020B {

    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        double a = inScanner.nextInt();
        double b = inScanner.nextInt();
        double c = inScanner.nextInt();
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    System.out.println(-1);
                else
                    System.out.println(0);
            } else {
                System.out.println(1);
                printWithZeros(-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println(0);
            } else if (delta == 0) {
                System.out.println(1);
                printWithZeros(-b / (2 * a));
            } else {
                System.out.println(2);
                if (a > 0) {
                    printWithZeros((-b - Math.sqrt(delta)) / (2 * a));
                    printWithZeros((-b + Math.sqrt(delta)) / (2 * a));
                } else {
                    printWithZeros((-b + Math.sqrt(delta)) / (2 * a));
                    printWithZeros((-b - Math.sqrt(delta)) / (2 * a));
                }
            }
        }
    }

    private static void printWithZeros(double d) {
        String number = Double.toString(d);
        if (!number.contains("."))
            number += ".";
        number += "00000";
        System.out.println(number);
    }
}
