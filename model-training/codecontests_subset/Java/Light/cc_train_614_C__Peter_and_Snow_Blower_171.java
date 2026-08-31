import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    double min_distance = Double.POSITIVE_INFINITY;
    double max_distance = Double.NEGATIVE_INFINITY;

    void update_distance(double distance) {
        min_distance = Math.min(min_distance, distance);
        max_distance = Math.max(max_distance, distance);
    }

    void run() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = in.nextInt();
        Point2D center = new Point2D.Double(in.nextInt(), in.nextInt());
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; ++i) {
            points[i] = new Point2D.Double(in.nextInt(), in.nextInt());
        }
        for (int i = 0; i < n; ++i) {
            update_distance(center.distanceSq(points[i]));
            update_distance(new Line2D.Double(points[i], points[(i + 1) % n]).ptSegDistSq(center));
        }
        out.println((max_distance - min_distance) * Math.PI);
        out.flush();
    }
}

