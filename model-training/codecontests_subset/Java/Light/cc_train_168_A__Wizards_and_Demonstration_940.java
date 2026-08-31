import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        sc.nextLine();
        int out = (int) (Math.ceil(y * n / 100.000000000000000000000000) - x);
        System.out.println(out >= 0 ? out : 0);
    }
}
