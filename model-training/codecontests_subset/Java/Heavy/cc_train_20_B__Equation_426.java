

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double d = b*b-4*a*c;
        if ((a == 0 && b == 0 && c == 0)){
            System.out.println(-1);
            return;
        }
        if ((a == 0 && b == 0) || d < 0){
            System.out.println(0);
            return;
        }
        if (a == 0){
            System.out.println(1);
            System.out.printf("%.5f",-c/b);
            return;
        }
        double x1 = (-b-Math.sqrt(d))/(2*a);
        double x2 = (-b+Math.sqrt(d))/(2*a);
        if (x1 == x2){
            System.out.println(1);
            System.out.printf("%.5f",x1);
        }else{
            System.out.println(2);
            if (x1 > x2){
                double temp = x1;
                x1 = x2;
                x2 = temp;
            }
            System.out.printf("%.5f",x1);
            System.out.println();
            System.out.printf("%.5f",x2);
        }
    
    }

}
