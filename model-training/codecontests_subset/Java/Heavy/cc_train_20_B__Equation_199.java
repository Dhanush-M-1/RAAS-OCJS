
import java.util.Scanner;

public class P20B {
    P20B(){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        sc.close();


        if (a == 0){
            if (b == 0){
                if (c == 0){
                    System.out.println(-1);
                }
                else {
                    System.out.println(0);
                }
            }
            else {
                System.out.println(1);
                System.out.println(-1 * c / b);
            }
        }
        else {
            double delta = b * b - 4 * a * c;

            if (delta < 0){
                System.out.println(0);
            }
            else if (delta == 0){
                System.out.println(1);
                System.out.println((-1 * b) / (2 * a));
            }
            else {
                System.out.println(2);
                double x1 = (-1 * b - Math.sqrt(delta)) / (2 * a);
                double x2 = (-1 * b + Math.sqrt(delta)) / (2 * a);
                if (x1 < x2){
                    System.out.println(x1);
                    System.out.println(x2);
                }
                else {
                    System.out.println(x2);
                    System.out.println(x1);
                }
            }
        }


    }

    public static void main (String []args){
        new P20B();
    }
}
