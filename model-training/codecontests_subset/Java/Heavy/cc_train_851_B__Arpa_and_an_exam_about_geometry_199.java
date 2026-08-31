import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class B {

    static PrintWriter out = new PrintWriter(System.out);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        String[] ar= reader.readLine().split(" ");
        long ax = Long.valueOf(ar[0]);
        long ay = Long.valueOf(ar[1]);
        long bx = Long.valueOf(ar[2]);
        long by = Long.valueOf(ar[3]);
        long cx = Long.valueOf(ar[4]);
        long cy = Long.valueOf(ar[5]);

        if (    judge(ax, ay, bx, by, cx, cy)
//                judge(cx, cy, bx, by, ax, ay) ||
//                judge(ax, ay, cx, cy, bx, by) ||
//                judge(bx, by, cx, cy, ax, ay) ||
//                judge(cx, cy, ax, ay, bx, by) ||
//                judge(bx, by, ax, ay, cx, cy)
                ) System.out.println("Yes");
        else System.out.println("No");
    }

    static boolean judge(long ax, long ay, long bx, long by, long cx, long cy){
        long a = ay - by, b = ax - bx, c = cy - by , d = cx - bx;
        if (a * a + b * b != c * c + d *d){
            return false;
        }
        long dx = bx + bx - ax;
        long dy = by + by - ay;
        return !(dx == cx && dy == cy);
        //        if(b != 0 && d != 0) {
//            if (a / b == c / d && a % b == c % d) {
//                return false;
//            }
//            return true;
//        }
//        if (ay != by || by != cy) return true;
//        return false;
    }
}