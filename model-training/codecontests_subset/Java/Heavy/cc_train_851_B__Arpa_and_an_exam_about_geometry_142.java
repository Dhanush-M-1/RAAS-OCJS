import java.util.Scanner;

/**
 * Created by phuoc on 9/4/17.
 */
public class B_432 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long ax = in.nextLong();
        long ay = in.nextLong();
        long bx = in.nextLong();
        long by = in.nextLong();
        long cx = in.nextLong();
        long cy = in.nextLong();
        if (((ax + cx) == 2 * bx) && ((ay + cy) == 2 * by)) System.out.println("No");
        else if ((ax - bx) * (ax - bx) + (ay - by) * (ay - by) == (cx - bx) * (cx - bx) + (cy - by) * (cy - by))
            System.out.println("Yes");
        else System.out.println("No");
    }
}
