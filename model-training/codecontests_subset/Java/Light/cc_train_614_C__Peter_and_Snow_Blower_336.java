// Copyright by tester2010
// http://www.codeforces.com/contest/613/submission/15380920
// I mock it just for study java ^_^

import java.awt.geom.Line2D;
import java.util.Scanner;

public class Solver {
    public static void main (String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int px = scanner.nextInt();
        int py = scanner.nextInt();

        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            xs[i] = scanner.nextInt();
            ys[i] = scanner.nextInt();
        }

        double max_dist = Double.MIN_VALUE;
        double min_dist = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            max_dist = Math.max(max_dist, dist(px, py, xs[i], ys[i]));
            min_dist = Math.min(min_dist, Line2D.ptSegDistSq(xs[i], ys[i], xs[(i+1)%n], ys[(i+1)%n], px, py));
        }

        double result = (max_dist - min_dist) * Math.PI;
        System.out.println(result);
    }

    private static double dist(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return dx * dx + dy * dy;
    }
}