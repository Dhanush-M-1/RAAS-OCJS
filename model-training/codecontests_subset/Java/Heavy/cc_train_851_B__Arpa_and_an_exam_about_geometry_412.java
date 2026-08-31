import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static long distance(int x, int y, int xx, int yy) {
        return (long) (x - xx) * (x - xx) + (y - yy) * (y - yy);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ax = in.nextInt(), ay = in.nextInt();
        int bx = in.nextInt(), by = in.nextInt();
        int cx = in.nextInt(), cy = in.nextInt();
        if ((long) (ax - bx) == (bx - cx) && (long) (ay - by) == (by - cy)) {
            System.out.println("No");
        } else if ((long) (ax-bx)*(ax-bx) + (long) (ay-by)*(ay-by) == (long) (bx-cx)*(bx-cx) + (long) (by-cy)*(by-cy)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}