import java.util.Arrays;
import java.util.Scanner;

class Main {
    final double eps = 1e-10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Double[] list = Arrays.stream(sc.nextLine().split(",")).map(Double::parseDouble).toArray(Double[]::new);
            Point a = new Point(list[0],list[1]);
            Point b = new Point(list[2],list[3]);
            Point c = new Point(list[4],list[5]);
            Point d = new Point(list[6],list[7]);
            System.out.println(innerTriangle(a, b, c, d) || innerTriangle(a, c, d, b) || innerTriangle(a, b, d, c) || innerTriangle(b, c, d, a) ? "NO" : "YES");
        }
    }

    static Point sub(Point a, Point b) {
        return new Point(b.x - a.x, b.y - a.y);
    }

    static double cross(Point a, Point b) {
        return a.x * b.y - a.y * b.x;
    }

    static boolean innerTriangle(Point a, Point b, Point c, Point p) {
        return cross(sub(a, b), sub(b, p)) < 0.0 &&
                cross(sub(b, c), sub(c, p)) < 0.0 &&
                cross(sub(c, a), sub(a, p)) < 0.0 ||
                cross(sub(a, b), sub(b, p)) > 0.0 &&
                        cross(sub(b, c), sub(c, p)) > 0.0 &&
                        cross(sub(c, a), sub(a, p)) > 0.0 ? true : false;
    }
}

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
