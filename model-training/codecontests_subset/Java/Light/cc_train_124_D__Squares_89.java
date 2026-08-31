import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        int n1 = Math.floorDiv(x1 + y1, 2 * a);
        int m1 = Math.floorDiv(x1 - y1, 2 * b);
        int n2 = Math.floorDiv(x2 + y2, 2 * a);
        int m2 = Math.floorDiv(x2 - y2, 2 * b);

        int res = Math.max(Math.abs(n2 - n1), Math.abs(m2 - m1));

        System.out.print(res);
    }
}
