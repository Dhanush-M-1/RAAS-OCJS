import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        Point2D.Double center = new Point2D.Double(in.nextInt(), in.nextInt());
        Point2D.Double[] points = new Point2D.Double[n];
        for (int i = 0; i < n; ++i) {
            points[i] = new Point2D.Double(in.nextInt(), in.nextInt());
        }
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, center.distanceSq(points[i]));
            min = Math.min(min, new Line2D.Double(points[i], points[(i + 1) % n]).ptSegDistSq(center));
        }
        System.out.println((max - min) * Math.PI);
    }
}

