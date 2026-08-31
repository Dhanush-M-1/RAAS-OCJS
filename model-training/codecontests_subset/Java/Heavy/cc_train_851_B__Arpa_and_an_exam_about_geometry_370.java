import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CF851B {

    static FasterScanner in = new FasterScanner();
    static PrintWriter out = new PrintWriter(System.out);
    static boolean debug = false;

    public static void main(String[] args) {

        long x1 = in.nextLong(), y1 = in.nextLong();
        long x2 = in.nextLong(), y2 = in.nextLong();
        long x3 = in.nextLong(), y3 = in.nextLong();
        boolean b1 = false, b2 = false, b3 = false, ans;

        long d1 = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
        long d2 = (x3-x2)*(x3-x2) + (y3-y2)*(y3-y2);
        if((y3-y2)*(x2-x1)!=(y2-y1)*(x3-x2) )b1 = true;
        if((y3-y1)*(x1-x2)!=(y1-y2)*(x3-x1) )b2 = true;
        if((y2-y3)*(x3-x1)!=(x2-x3)*(y3-y1) )b3 = true;

        ans = (b1 & b2 & b3); ans &= (d1==d2);
        out.println( ans ? "Yes" : "No");
        out.close();
    }
}

class Pair implements Comparator<Pair> {

    int x;
    int y;
    int z;

    Pair() {}

    Pair(int a, int b, int c) {
        x = a;
        y = b;
        z = c;
    }

    @Override
    public int compare(Pair p, Pair q) {
        return (p.x-q.x);
    }

    @Override
    public boolean equals(Object object) {

        if(object!=null && object instanceof Pair) {
            return (this.x==((Pair)object).x && this.y==((Pair)object).y && this.z==((Pair)object).z);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}

class FasterScanner {
    private byte[] buf = new byte[1024];
    private int curChar;
    private int snumChars;

    public int read() {
      if (snumChars == -1)
    throw new InputMismatchException();
      if (curChar >= snumChars) {
    curChar = 0;
    try {
      snumChars = System.in.read(buf);
    } catch (IOException e) {
      throw new InputMismatchException();
    }
    if (snumChars <= 0)
      return -1;
      }
      return buf[curChar++];
    }

    public double nextDouble() {
      return Double.parseDouble(this.nextString());
    }

    public String nextLine() {
      int c = read();
      while (isSpaceChar(c))
    c = read();
      StringBuilder res = new StringBuilder();
      do {
    res.appendCodePoint(c);
    c = read();
      } while (!isEndOfLine(c));
      return res.toString();
    }

    public String nextString() {
      int c = read();
      while (isSpaceChar(c))
    c = read();
      StringBuilder res = new StringBuilder();
      do {
    res.appendCodePoint(c);
    c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public long nextLong() {
      int c = read();
      while (isSpaceChar(c))
    c = read();
      int sgn = 1;
      if (c == '-') {
    sgn = -1;
    c = read();
      }
      long res = 0;
      do {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public int nextInt() {
      int c = read();
      while (isSpaceChar(c))
    c = read();
      int sgn = 1;
      if (c == '-') {
    sgn = -1;
    c = read();
      }
      int res = 0;
      do {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public int[] nextIntArray(int n) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
    arr[i] = nextInt();
      }
      return arr;
    }

    public long[] nextLongArray(int n) {
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
    arr[i] = nextLong();
      }
      return arr;
    }

    private boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }
}