import java.util.Scanner;


public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        long C = sc.nextInt();
        if (A==0 && B==0 && C==0) {
            System.out.println(-1);
            return;
        }
        if (A==0) {
            if (B==0)
                System.out.println(0);
            else {
                System.out.println(1);
                System.out.println(-C*1.0/B);
            }
        }
        else {
            if (A < 0) {
                A = -A;
                B = -B;
                C = -C;
            }
            long D = B*B-4*A*C;
            if (D < 0)
                System.out.println(0);
            else {
                if (D==0) {
                    System.out.println(1);
                    System.out.println(-B/(2.0*A));
                }
                else {
                    System.out.println(2);
                    System.out.println((-B-Math.sqrt(D))/(2*A));
                    System.out.println((-B+Math.sqrt(D))/(2*A));
                }
            }
        }
    }

}
