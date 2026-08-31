import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.BufferedInputStream;
import java.lang.*;
import java.lang.reflect.Array;
import java.math.*;
import java.util.*;
import java.awt.*;

public class Codeforces {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        double x = in.nextDouble(), y = in.nextDouble();

        in.nextLine();

        Point2D.Double a[] = new Point2D.Double[n];

        for(int i = 0; i < n; i++) {
            a[i] = new Point2D.Double(in.nextDouble(), in.nextDouble());
            in.nextLine();
        }

        double R = 0, r = 10000000000.0;

        for(int i = 0; i < n; i++) {
            R = Math.max(R, a[i].distance(x, y));
            r = Math.min(r, a[i].distance(x, y));
        }

        for(int i = 1; i < n; i++) {
            r = Math.min(r, (new Line2D.Double(a[i - 1], a[i])).ptSegDist(x, y));
        }

        r = Math.min(r, (new Line2D.Double(a[n - 1], a[0])).ptSegDist(x, y));
        
        System.out.print(Math.PI*R*R - Math.PI*r*r);
    }

}
