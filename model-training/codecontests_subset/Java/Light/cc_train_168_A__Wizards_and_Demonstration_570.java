import java.util.Scanner;

public class A_168 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        double p = n * y / 100.0;
        int p1 = n * y / 100;
        if (p1 < p) {
            p = (int) p + 1;
        }
        if ((int) p <= x) {
            System.out.println(0);
            return;
        } else {
            System.out.println(Math.round(p - x));
        }

    }

}