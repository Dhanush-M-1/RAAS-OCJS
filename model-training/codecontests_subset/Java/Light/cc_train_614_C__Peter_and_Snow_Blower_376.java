import java.util.Scanner;

public class C {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long px = in.nextLong(), py = in.nextLong();
    long[] x = new long[n], y = new long[n];
    double min = Double.POSITIVE_INFINITY, max = Double.NEGATIVE_INFINITY;
    for (int i = 0; i < n; i++) {
      x[i] = in.nextLong() - px;
      y[i] = in.nextLong() - py;
    }

    int j = n - 1;
    for (int i = 0; i < n; j = i, i++) {
      double len = Math.sqrt(x[i] * x[i] + y[i] * y[i]);
      min = Math.min(min, len);
      max = Math.max(max, len);

      double lo = 0, hi = 1;
      for (int itr = 0; itr < 50; itr++) {
        double mid1 = (2 * lo + hi) / 3;
        double mid2 = (lo + 2 * hi) / 3;
        double ax = x[i] + (x[j] - x[i]) * mid1;
        double ay = y[i] + (y[j] - y[i]) * mid1;
        double bx = x[i] + (x[j] - x[i]) * mid2;
        double by = y[i] + (y[j] - y[i]) * mid2;
        double val1 = Math.sqrt(ax * ax + ay * ay);
        double val2 = Math.sqrt(bx * bx + by * by);
        if (val1 > val2)
          lo = mid1;
        else
          hi = mid2;
      }

      double xx = x[i] + (x[j] - x[i]) * (lo + hi) / 2;
      double yy = y[i] + (y[j] - y[i]) * (lo + hi) / 2;
      double val = Math.sqrt(xx * xx + yy * yy);
      min = Math.min(min, val);
      max = Math.max(max, val);
    }

    System.out.println(Math.PI * (max * max - min * min));
  }
}
