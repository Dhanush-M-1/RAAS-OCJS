import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, x, y;
        n = in.nextInt(); x = in.nextInt(); y = in.nextInt();
        double ans = Math.ceil(y/100.0 * n) - x;
        System.out.println(Math.max(0, (int)ans));
    }
}   