import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BGeometry {

  private static final String REGEX = " ";
  private static final Boolean DEBUG = false;
  private static final String FILE_NAME = "input.txt";


  public static void main(String[] args) throws IOException {
    if (DEBUG) {
      generate();
    }
    Solver solver = new Solver();
    solver.readData();
    solver.solve();
    solver.print();
  }

  private static void generate() throws IOException {
//    FileWriter writer = new FileWriter("input.txt");
//    writer.close();
  }

  private static class Solver {
    private StringBuilder myStringBuilder = new StringBuilder();
    long ax, ay, bx, by, cx, cy;
    Point[] points = new Point[3];
    Point a, b, c;
    Point aOr, bOr, cOr;

    class Point {
      long x, y;

      public Point(long x, long y) {
        this.x = x;
        this.y = y;
      }
    }

    void readData() throws IOException {
      Scanner scanner = new Scanner();
      ax = scanner.nextInt();
      ay = scanner.nextInt();
      aOr = new Point(ax, ay);
      points[0] = aOr;
      bx = scanner.nextInt();
      by = scanner.nextInt();
      bOr = new Point(bx, by);
      points[1] = bOr;
      cx = scanner.nextInt();
      cy = scanner.nextInt();
      cOr = new Point(cx, cy);
      points[2] = cOr;
      scanner.close();
    }

    void solve() {
      Arrays.sort(points, new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
          if (o1.x < o2.x) {
            return -1;
          } else if (o1.x == o2.x) {
            return 0;
          } else {
            return 1;
          }
        }
      });
      a = points[0];
      b = points[1];
      c = points[2];

      long dx1 = b.x - a.x;
      long dy1 = b.y - a.y;

      long dx2 = c.x - b.x;
      long dy2 = c.y - b.y;

      if (dx1 == 0 && dx2 == 0) {
        out("No");
      } else if (dy1 == 0 && dy2 == 0) {
        out("No");
      } else if (dy1 * dx2 == dy2 * dx1) {
        out("No");
      } else {
        long dist1 = pow2(bOr.y - aOr.y) + pow2(bOr.x - aOr.x);
        long dist2 = pow2(cOr.y - bOr.y) + pow2(cOr.x - bOr.x);
        if (dist1 == dist2) {
          out("Yes");
        } else {
          out("No");
        }
      }

    }

    long pow2(long a) {
      return a * a;
    }

    void print() {
      System.out.println(myStringBuilder);
    }


    void out(Object object) {
      myStringBuilder.append(object);
    }

    void out(String string) {
      myStringBuilder.append(string);
    }

    public void out(boolean b) {
      myStringBuilder.append(b);
    }

    public void out(char c) {
      myStringBuilder.append(c);
    }

    public void out(int i) {
      myStringBuilder.append(i);
    }

    public void out(long lng) {
      myStringBuilder.append(lng);
    }

    public void out(float f) {
      myStringBuilder.append(f);
    }

    public void out(double d) {
      myStringBuilder.append(d);
    }

    public void newLine() {
      myStringBuilder.append("\n");
    }

    @SuppressWarnings("SameParameterValue")
    int[] splitInteger(String string, int n) {
      final String[] split = string.split(REGEX, n);
      int[] result = new int[split.length];
      for (int i = 0; i < n; ++i) {
        result[i] = Integer.parseInt(split[i]);
      }
      return result;
    }

    public int[] splitInteger(String string) {
      return splitInteger(string, 0);
    }


    @SuppressWarnings("SameParameterValue")
    long[] splitLong(String string, int n) {
      final String[] split = string.split(REGEX, n);
      long[] result = new long[split.length];
      for (int i = 0; i < n; ++i) {
        result[i] = Long.parseLong(split[i]);
      }
      return result;
    }

    public long[] splitLong(String string) {
      return splitLong(string, 0);
    }

    @SuppressWarnings("SameParameterValue")
    double[] splitDouble(String string, int n) {
      final String[] split = string.split(REGEX, n);
      double[] result = new double[split.length];
      for (int i = 0; i < n; ++i) {
        result[i] = Double.parseDouble(split[i]);
      }
      return result;
    }

    public double[] splitDouble(String string) {
      return splitDouble(string, 0);
    }

    @SuppressWarnings("SameParameterValue")
    String[] splitString(String string, int n) {
      return string.split(REGEX, n);
    }

    public int max(int a, int b) {
      return Math.max(a, b);
    }

    public int max(int[] arr) {
      int max = Integer.MIN_VALUE;
      for (int x : arr) {
        max = max(max, x);
      }
      return max;
    }

    public long max(long a, long b) {
      return Math.max(a, b);
    }

    public int min(int a, int b) {
      return Math.min(a, b);
    }

    public long min(long a, long b) {
      return Math.min(a, b);
    }

    public double max(double a, double b) {
      return Math.max(a, b);
    }

    public double min(double a, double b) {
      return Math.min(a, b);
    }

    private final static int MOD = 1000000009;

    int multMod(int a, int b) {
      return ((a % MOD) * (b % MOD)) % MOD;
    }

    int sumMod(int a, int b) {
      return ((a % MOD) + (b % MOD)) % MOD;
    }

    long multMod(long a, long b) {
      return ((a % MOD) * (b % MOD)) % MOD;
    }

    long sumMod(long a, long b) {
      return ((a % MOD) + (b % MOD)) % MOD;
    }

    int sum(int[] arr) {
      int sum = 0;
      for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
      }
      return sum;
    }

    long sum(long[] arr) {
      long sum = 0;
      for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
      }
      return sum;
    }

    private class Scanner {
      private int currentIndex = 0;
      private String[] objects;
      private final BufferedReader myReader;
      private Computable<Character> charComputer;
      private Computable<Double> doubleComputer;
      private Computable<Integer> intComputer;
      private Computable<Long> longComputer;

      Scanner() throws FileNotFoundException {
        InputStream in = DEBUG ? new FileInputStream(FILE_NAME) : System.in;
        myReader = new BufferedReader(new InputStreamReader(in));
        charComputer = () -> objects[currentIndex].charAt(0);
        doubleComputer = () -> Double.parseDouble(objects[currentIndex]);
        intComputer = () -> Integer.parseInt(objects[currentIndex]);
        longComputer = () -> Long.parseLong(objects[currentIndex]);
      }

      String nextLine() throws IOException {
        objects = null;
        currentIndex = 0;
        return myReader.readLine();
      }

      int nextInt() throws IOException {
        return next(intComputer);
      }

      int[] nextIntArray(int n) throws IOException {
        return splitInteger(nextLine(), n);
      }

      long[] nextLongArray(int n) throws IOException {
        return splitLong(nextLine(), n);
      }

      long nextLong() throws IOException {
        return next(longComputer);

      }

      double nextDouble() throws IOException {
        return next(doubleComputer);

      }

      char nextChar() throws IOException {
        return next(charComputer);
      }

      <T> T next(Computable<T> computer) throws IOException {
        T result;
        if (objects == null || currentIndex >= objects.length) {
          String s = myReader.readLine();
          objects = s.split(" ");
          currentIndex = 0;
        }
        result = computer.compute();
        currentIndex++;
        return result;
      }

      public void close() throws IOException {
        myReader.close();
      }

    }

    interface Computable<T> {
      T compute();
    }

  }

}
