import java.util.Scanner;

public class Equation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long C = sc.nextInt();
        if (A == 0){
            if (B == 0){
                if (C == 0){
                    System.out.println(-1);
                }else{
                    System.out.println(0);
                }
            }else{
                System.out.println(1);
                System.out.println(-1.0*C/B+"00000");
            }
        }else{
            if (B*B-4*A*C < 0){
                System.out.println(0);
            }else {
                double determinant = java.lang.Math.sqrt(B * B - 4 * A * C);
                if (B*B == 4*A*C){
                    System.out.println(1);
                    System.out.println(-0.5*B/A+"00000");
                }else{
                    System.out.println(2);
                    if (A > 0) {
                        System.out.println((-B - determinant) / (2 * A) + "00000");
                        System.out.println((-B + determinant) / (2 * A) + "00000");
                    }else{
                        System.out.println((-B + determinant) / (2 * A) + "00000");
                        System.out.println((-B - determinant) / (2 * A) + "00000");
                    }


                }
            }
        }
    }
}
