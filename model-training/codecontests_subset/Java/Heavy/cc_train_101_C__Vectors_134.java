import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
public class C {

    public static long cross(long x1, long y1, long x2, long y2) {
        return x1*y2-y1*x2;
    }

    long x1, y1;
    long x3, y3;
    long d3p;
    long x4, y4;

    boolean test(long x2, long y2) {
        if (d3p==0) return x1==x2&&y1==y2;
        return cross(x3,y3,x2-x1,y2-y1)%d3p==0 
            && cross(y3,-x3,x2-x1,y2-y1)%d3p==0;
    }
    
    public C() throws Exception {
        x1 = in.nextInt();
        y1 = in.nextInt();
        long x2 = in.nextInt();
        long y2 = in.nextInt();
        x3 = in.nextInt();
        y3 = in.nextInt();
        d3p = x3*x3+y3*y3;

        boolean b = false;
        if (!b) b = test(x2,y2);
        if (!b) b = test(y2,-x2);
        if (!b) b = test(-x2,-y2);
        if (!b) b = test(-y2,x2);

        if (b)
            buf.append("YES\n");
        else
            buf.append("NO\n");
        System.out.print(buf);
    }

    Scanner in = new Scanner(System.in);
    StringBuilder buf = new StringBuilder();
    public static void main(String[] args) throws Exception { // {{{
        new C();
    } // }}}
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
}
