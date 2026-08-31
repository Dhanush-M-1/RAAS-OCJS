import java.util.Scanner;

public class D {
    static Scanner in = new Scanner(System.in);

    static void run() {
        int n = in.nextInt();
        double d = Math.PI / n / 2;
        double b = 2 * 0.5 / Math.sin(d);
        System.out.println(b * Math.cos(d / 2));
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        while (t-- > 0) {
            run();
        }
    }
}
