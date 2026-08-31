import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long ax = scanner.nextLong();
        long ay = scanner.nextLong();
        long bx = scanner.nextLong();
        long by = scanner.nextLong();
        long cx = scanner.nextLong();
        long cy = scanner.nextLong();
        if (ax == bx && ax == cx && bx == cx) {
            System.out.println("No");
        }else{
            double k = ((double) (by - ay)) / ((double) (bx - ax));
            double b = ay - k * ax;
            long l_ab = (bx - ax) * (bx - ax) + (by - ay) * (by - ay);
            long l_bc = (cx - bx) * (cx - bx) + (cy - by) * (cy - by);
            if ((double) (cy) == k * cx + b) {
                System.out.println("No");
            } else {
                if (l_ab == l_bc) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
