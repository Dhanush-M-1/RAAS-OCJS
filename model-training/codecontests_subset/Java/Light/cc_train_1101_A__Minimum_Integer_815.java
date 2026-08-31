import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long T = sc.nextInt();
    for (long i = 0; i < T; i++) {
      long l = sc.nextInt();
      long r = sc.nextInt();
      long d = sc.nextInt();
      if (l > d) {
        // System.out.println("print d");
        System.out.println(d);
      } else {
        long x = d * (int)Math.ceil((double)r/d);
        if (x == r || x == 0) {
          x += d;
        }
        System.out.println(x);
      }
      // System.out.println("---");
    }
  }
}
