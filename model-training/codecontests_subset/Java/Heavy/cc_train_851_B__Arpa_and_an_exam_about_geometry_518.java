import java.util.Scanner;

/**
 * Created by igarus on 17.10.2016.
 */
public class CF_432_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long ax = scanner.nextInt();
        long ay = scanner.nextInt();
        long bx = scanner.nextInt();
        long by = scanner.nextInt();
        long cx = scanner.nextInt();
        long cy = scanner.nextInt();

        long ab = (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
        long bc = (bx - cx) * (bx - cx) + (by - cy) * (by - cy);
//        long ca = (cx - ax) * (cx - ax) + (cy - ay) * (cy - ay);

        long A = ay - cy;
        long B = cx - ax;
        long C = ax * cy - cx * ay;

        if (ab == bc && A * bx + B * by + C != 0)
            System.out.println("Yes");
        else
            System.out.println("No");


    }

}
