
/*


        HARSH KHATRI
        DA-IICT

                      */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CF893D {

    static FasterScanner in = new FasterScanner();
    static PrintWriter out = new PrintWriter(System.out);
    static boolean debug = true;

    public static void main(String[] args) {

        int n = in.nextInt(), a[] = new int[n+2];
        int i, j, k, count = 0;
        boolean valid = true;
        long d = in.nextLong(), pre[] = new long[n+2], max[] = new long[n+2];

        for(i=1; i<=n; i++) {
            pre[i] = a[i] = in.nextInt();
            pre[i] += pre[i-1];
            if(pre[i]>d) valid = false;
        }

        max[n+1] = (long)-1e10;
        for(i=n; i>0; i--) {
            max[i] = pre[i];
            max[i] = Math.max(max[i], max[i+1]);
        }

        long tot, add; tot = add = 0;
        for(i=1; i<=n; i++) {
            tot+=a[i];
            if(a[i]==0 && tot<0) {
                tot += d - (max[i]+add);
                add += d - (max[i]+add);
                if(tot<0) { valid = false; break; }
                else count++;
            }
        }

        out.println(valid ? count : "-1");
        out.close();
    }
}

class Pair implements Comparator<Pair> {

    int x;
    int y;
    int z;

    Pair() {}

    Pair(int a, int b) {
        x = a;
        y = b;
    }

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

    public char nextChar() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char)c;
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