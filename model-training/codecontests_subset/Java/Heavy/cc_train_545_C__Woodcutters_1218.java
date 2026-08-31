import java.awt.*;
import java.util.Scanner;

public class Woodcutters {

    private static class Tuple {
        long x;
        long y;

        Tuple(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        /**
         * max goint to left  1 0 0 0 3// 0 if intersects in place, if it intersects the right then 1+(max(left, in place)), else right+1(?)
         * max going in place 0 1 2 2 2 // max of previous's left, in place, right
         * max going to right 0 2 0 0 3 // 0 if intersects next's in place && not last element, else 1+max of previous's left, in place, right
         * return max
         * 1 2
         * 2 1
         * 5 10
         * 10 9
         * 19 1
         */
        long[] left = new long[n];
        long[] place = new long[n];
        long[] right = new long[n];
        Tuple[] data = new Tuple[n];
        for (int i = 0; i < n; i++) {
            data[i] = new Tuple(in.nextLong(), in.nextLong());
        }
        left[0] = 1;
        place[0] = 0;
        right[0] = data[0].x + data[0].y >= data[1].x ? 0 : 1;
        //   System.out.printf("%d %d %d\n", right[0], place[0], left[0]);
        for (int i = 1; i < n; i++) {
            left[i] = data[i].x - data[i].y <= data[i - 1].x ?
                    0 :
                    data[i].x - data[i].y <= data[i - 1].x + data[i
                            - 1].y ?
                            1 + max(left[i - 1], place[i - 1]) :
                            right[i - 1] + 1;
            place[i] = max(left[i - 1], place[i - 1], right[i - 1]);
            right[i] = (i != n - 1 && data[i].x + data[i].y >= data[i
                    + 1].x) ?
                    0 :
                    1 + max(left[i - 1], place[i - 1], right[i - 1]);
            //   System.out.printf("%d %d %d\n", right[i], place[i], left[i]);
        }
        System.out.println(max(left[n - 1], place[n - 1], right[n - 1]));
    }

    //
    static long max(long a, long b, long c) {
        return Math.max(Math.max(a, b), c);
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }
}
