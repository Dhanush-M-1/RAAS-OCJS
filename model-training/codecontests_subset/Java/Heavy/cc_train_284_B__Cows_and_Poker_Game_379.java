import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


/**
 * @Author  Roman Dzhadan
 * @Team    VNTU [Noobs v3.0]
 * @E-Mail  dflash36@gmail.com
 * @Skype   ronex36
 */
public class Main {
    
    public static final String     TYPE              =   IOSystem.STANDART;
    public static final long       TIME_LIMIT        =   2;
    public static final long       MEMORY_LIMIT      =   256 * (1L << 20);
    public static final String     INPUT_FILE_NAME   =   "input.txt";
    public static final String     OUTPUT_FILE_NAME  =   "output.txt";
    public static final boolean    ONLINE_JUDGE      =   System.getProperty("ONLINE_JUDGE") != null;
    
    public static void main(String[] args) throws FileNotFoundException {
        IOSystem IO = (TYPE.equals(IOSystem.STANDART) ? new IOSystem() : new IOSystem(INPUT_FILE_NAME, OUTPUT_FILE_NAME));
        new Thread(null, new Task(IO), "", MEMORY_LIMIT).start();
    }
}

class Task implements Runnable {
//------------------------------------------------------  SOLUTION  -----------------------------------------------------------//   

    public void solve() throws IOException {
        int n = in.readInt();
        String line = in.readString();
        int res = 0;
        if (!line.contains("I")) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'A')
                    res++;
            }
        }
        else {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i)=='I') res++;
            }
            if (res != 1) res = 0;
        }
        out.println(res);
    
    }   

//-----------------------------------------------------------------------------------------------------------------------------//
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            solve();
            close();
            long endTime = System.currentTimeMillis();
            long totalMemory = Runtime.getRuntime().totalMemory();
            long freeMemory = Runtime.getRuntime().freeMemory();
            System.err.printf("Time = %.3f ms\n", (endTime - startTime) / 1000.0);
            System.err.printf("Memory = %.3f MB\n", (totalMemory - freeMemory) / (double)(1L << 20));
        }
        catch (Throwable e) {e.printStackTrace(System.err);System.exit(-1);}
    }
    public PrintWriter out;
    public IOSystem in;
    public Task(IOSystem io) {out = io.out; this.in = io;}
    public void close() throws IOException {in.in.close(); out.close();}
    void debug(Object... o) {if (!Main.ONLINE_JUDGE) {System.err.println(Arrays.deepToString(o));}}
}

class IOSystem {
    public static final String FILE = "file";
    public static final String STANDART = "stdin";
    
    BufferedReader in;
    StringTokenizer tok;
    PrintWriter out;
    
    public IOSystem() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        tok = new StringTokenizer("");
    }
    
    public IOSystem(String inputFileName, String outputFileName) throws FileNotFoundException {
        in = new BufferedReader(new FileReader(inputFileName));
        out = new PrintWriter(outputFileName);
        tok = new StringTokenizer("");
    }
    
    String readString() throws IOException {while (!tok.hasMoreTokens()) {String line = in.readLine();if (line == null) return null;tok = new StringTokenizer(line);}return tok.nextToken();}
    int readInt() throws IOException {return Integer.parseInt(readString());}
    long readLong() throws IOException {return Long.parseLong(readString());}
    double readDouble() throws IOException {return Double.parseDouble(readString());}
}

class Point {
    public double x;
    public double y;

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Line line(Point other) {
        if (equals(other))
            return null;
        double a = other.y - y;
        double b = x - other.x;
        double c = -a * x - b * y;
        return new Line(a, b, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Point point = (Point) o;

        return Math.abs(x - point.x) <= GeometryUtils.epsilon
                && Math.abs(y - point.y) <= GeometryUtils.epsilon;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double distance(Point other) {
        return GeometryUtils.fastHypot(x - other.x, y - other.y);
    }

    public double distance(Line line) {
        return Math.abs(line.a * x + line.b * y + line.c);
    }

    public double value() {
        return GeometryUtils.fastHypot(x, y);
    }
}

class Line {
    public final double a;
    public final double b;
    public final double c;

    public Line(double a, double b, double c) {
        double h = GeometryUtils.fastHypot(a, b);
        /*
         * if (a < -GeometryUtils.epsilon) { a = -a; b = -b; c = -c; } else if
         * (a < GeometryUtils.epsilon && b < -GeometryUtils.epsilon) { b = -b; c
         * = -c; }
         */
        this.a = a / h;
        this.b = b / h;
        this.c = c / h;
    }
    
    public Line(Point p1, Point p2) {
        double tmpa = +(p1.y - p2.y);
        double tmpb = -(p1.x - p2.x);
        double tmpc = p1.x * p2.y - p2.x * p1.y;
        double h = GeometryUtils.fastHypot(tmpa, tmpb);
        /*
         * if (a < -GeometryUtils.epsilon) { a = -a; b = -b; c = -c; } else if
         * (a < GeometryUtils.epsilon && b < -GeometryUtils.epsilon) { b = -b; c
         * = -c; }
         */
        this.a = tmpa / h;
        this.b = tmpb / h;
        this.c = tmpc / h;
    }

    public Point intersect(Line other) {
        if (parallel(other))
            return null;
        double determinant = b * other.a - a * other.b;
        double x = (c * other.b - b * other.c) / determinant;
        double y = (a * other.c - c * other.a) / determinant;
        return new Point(x, y);
    }

    public boolean parallel(Line other) {
        return Math.abs(a * other.b - b * other.a) < GeometryUtils.epsilon;
    }

    public boolean contains(Point point) {
        return Math.abs(value(point)) < GeometryUtils.epsilon;
    }

    public Line perpendicular(Point point) {
        return new Line(-b, a, b * point.x - a * point.y);
    }

    public double value(Point point) {
        return a * point.x + b * point.y + c;
    }

    public double distance(Point center) {
        return Math.abs(value(center));
    }
}

class GeometryUtils {
    public static double epsilon = 1e-8;

    public static double fastHypot(double... x) {
        if (x.length == 0)
            return 0;
        else if (x.length == 1)
            return Math.abs(x[0]);
        else {
            double sumSquares = 0;
            for (double value : x)
                sumSquares += value * value;
            return Math.sqrt(sumSquares);
        }
    }

    public static double fastHypot(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    public static double fastHypot(double[] x, double[] y) {
        if (x.length == 0)
            return 0;
        else if (x.length == 1)
            return Math.abs(x[0] - y[0]);
        else {
            double sumSquares = 0;
            for (int i = 0; i < x.length; i++) {
                double diff = x[i] - y[i];
                sumSquares += diff * diff;
            }
            return Math.sqrt(sumSquares);
        }
    }

    public static double fastHypot(int[] x, int[] y) {
        if (x.length == 0)
            return 0;
        else if (x.length == 1)
            return Math.abs(x[0] - y[0]);
        else {
            double sumSquares = 0;
            for (int i = 0; i < x.length; i++) {
                double diff = x[i] - y[i];
                sumSquares += diff * diff;
            }
            return Math.sqrt(sumSquares);
        }
    }

    public static double missileTrajectoryLength(double v, double angle,
            double g) {
        return (v * v * Math.sin(2 * angle)) / g;
    }

    public static double sphereVolume(double radius) {
        return 4 * Math.PI * radius * radius * radius / 3;
    }

    public static double triangleSquare(double first, double second,
            double third) {
        double p = (first + second + third) / 2;
        return Math.sqrt(p * (p - first) * (p - second) * (p - third));
    }

    public static double canonicAngle(double angle) {
        while (angle > Math.PI)
            angle -= 2 * Math.PI;
        while (angle < -Math.PI)
            angle += 2 * Math.PI;
        return angle;
    }
    
    public static Point rotatePoint(Point point, double angle) {
        double nx = point.x * Math.cos(angle) - point.y * Math.sin(angle);
        double ny = point.x * Math.sin(angle) + point.y * Math.cos(angle);
        return new Point(nx, ny);
    }
    
    public static Point[] rotatePointArray(Point[]points, double angle) {
        Point[]rotated = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            rotated[i] = rotatePoint(points[i], angle);
        }
        return rotated;
    }
}

class Polygon {
    public final Point[] vertices;

    public Polygon(Point... vertices) {
        this.vertices = vertices.clone();
    }

    public double square() {
        double sum = 0;
        for (int i = 1; i < vertices.length; i++)
            sum += (vertices[i].x - vertices[i - 1].x) * (vertices[i].y + vertices[i - 1].y);
        sum += (vertices[0].x - vertices[vertices.length - 1].x) * (vertices[0].y + vertices[vertices.length - 1].y);
        return Math.abs(sum) / 2;
    }

    public Point center() {
        double sx = 0;
        double sy = 0;
        for (Point point : vertices) {
            sx += point.x;
            sy += point.y;
        }
        return new Point(sx / vertices.length, sy / vertices.length);
    }

    private static boolean over(Point a, Point b, Point c) {
        return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) < -GeometryUtils.epsilon;
    }

    private static boolean under(Point a, Point b, Point c) {
        return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) > GeometryUtils.epsilon;
    }

    public static Polygon convexHull(Point[] points) {
        if (points.length == 1)
            return new Polygon(points);
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                int value = Double.compare(o1.x, o2.x);
                if (value != 0)
                    return value;
                return Double.compare(o1.y, o2.y);
            }
        });
        Point left = points[0];
        Point right = points[points.length - 1];
        List<Point> up = new ArrayList<Point>();
        List<Point> down = new ArrayList<Point>();
        for (Point point : points) {
            if (point == left || point == right || over(left, point, right)) {
                while (up.size() >= 2
                        && !over(up.get(up.size() - 2), up.get(up.size() - 1),
                                point))
                    up.remove(up.size() - 1);
                up.add(point);
            }
            if (point == left || point == right || under(left, point, right)) {
                while (down.size() >= 2
                        && !under(down.get(down.size() - 2),
                                down.get(down.size() - 1), point))
                    down.remove(down.size() - 1);
                down.add(point);
            }
        }
        Point[] result = new Point[up.size() + down.size() - 2];
        int index = 0;
        for (Point point : up)
            result[index++] = point;
        for (int i = down.size() - 2; i > 0; i--)
            result[index++] = down.get(i);
        return new Polygon(result);
    }

    public boolean contains(Point point) {
        double totalAngle = GeometryUtils.canonicAngle(Math.atan2(vertices[0].y
                - point.y, vertices[0].x - point.x)
                - Math.atan2(vertices[vertices.length - 1].y - point.y,
                        vertices[vertices.length - 1].x - point.x));
        for (int i = 1; i < vertices.length; i++) {
            totalAngle += GeometryUtils.canonicAngle(Math.atan2(vertices[i].y
                    - point.y, vertices[i].x - point.x)
                    - Math.atan2(vertices[i - 1].y - point.y, vertices[i - 1].x
                            - point.x));
        }
        return Math.abs(Math.abs(totalAngle) - 2 * Math.PI) < GeometryUtils.epsilon;
    }

    public static double triangleSquare(Point a, Point b, Point c) {
        return Math.abs((a.x - b.x) * (a.y + b.y) + (b.x - c.x) * (b.y + c.y)
                + (c.x - a.x) * (c.y + a.y)) / 2;
    }
}