import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        long ax = in.nextInt();
        long ay = in.nextInt();
        long bx = in.nextInt();
        long by = in.nextInt();
        long cx = in.nextInt();
        long cy = in.nextInt();

        long ab_sq = (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
        long bc_sq = (cx - bx) * (cx - bx) + (cy - by) * (cy - by);

        if (ab_sq == bc_sq) {
            if ((cy - ay) * (bx - ax) != (cx - ax) * (by - ay)) {
                p("YES");
                return;
            }
        }
        p("NO");
    }

    static void p(Object str) {
        System.out.println(str);
    }

    public static void pa(int[] objs) {
        String str = "";
        for (Object obj : objs) {
            str += obj.toString() + " ";
        }
        p(str);
    }

    public static void pi(Object[] objs) {
        String str = "";
        for (Object obj : objs) {
            str += obj.toString() + " ";
        }
        p(str);
    }

}

