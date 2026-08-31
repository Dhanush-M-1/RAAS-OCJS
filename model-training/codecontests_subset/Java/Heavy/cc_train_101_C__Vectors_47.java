import java.io.*;
import java.math.*;
import java.util.*;

public class Task101C implements Runnable {
  class Point {
    long x, y;
    Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
    Point(Point that) {
      this.x = that.x;
      this.y = that.y;
    }
    void rotateClockwise() {
      long tmp = this.x;
      this.x = this.y;
      this.y = -tmp;
    }
    long cross(Point that) {
      return this.x * that.y - this.y * that.x;
    }
    long dot(Point that) {
      return this.x * that.x + this.y * that.y;
    }
    Point substract(Point that) {
      return new Point(this.x - that.x, this.y - that.y);
    }
    @Override
    public boolean equals(Object other) {
      if (!(other instanceof Point)) return false;
      if (this == other) return true;
      Point that = (Point)other;
      return this.x == that.x && this.y == that.y;
    }
    @Override
    public String toString() {
      return "(" + this.x + "," + this.y + ")";
    }
  }
  private void solve() throws IOException {
    Point A = new Point(nextLong(), nextLong());
    Point B = new Point(nextLong(), nextLong());
    Point C = new Point(nextLong(), nextLong());
    Point D = new Point(C);
    D.rotateClockwise();
    boolean found = false;
    for (int i = 0; i < 4; ++i) {
      Point R = B.substract(A);
      if (C.equals(new Point(0, 0))) {
        if (R.equals(new Point(0, 0))) {
          found = true;
          break;
        }
      } else {
        long x = C.cross(D);
        long y = R.cross(D);
        long z = R.cross(C);
        if (z % x == 0 && y % x == 0) {
          found = true;
          break;
        }
      }
      A.rotateClockwise();
    }
    if (!found) {
      writer.println("NO");
    } else {
      writer.println("YES");
    }

  }

  public static void main(String args[]) {
    new Task101C().run();
  }

  BufferedReader reader;
  PrintWriter writer;
  StringTokenizer tokenizer;

  public void run() {
    try {
      // System.setIn(new FileInputStream("test.in"));
      // System.setOut(new PrintStream(new FileOutputStream("test.out")));
      reader = new BufferedReader(new InputStreamReader(System.in));
      writer = new PrintWriter(System.out);
      solve();
      reader.close();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  String next() throws IOException {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      String s = reader.readLine();
      if (s == null) throw new IOException();
      tokenizer = new StringTokenizer(s);
    }
    return tokenizer.nextToken();
  }

  int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  double nextDouble() throws IOException {
    return Double.parseDouble(next());
  }
}
