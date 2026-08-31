import java.io.*;
import java.util.*;
import java.math.*;

public class P20B {

  public void run() throws Exception {
    double a = nextDouble();
    double b = nextDouble();
    double c = nextDouble();

    if (a == 0) {
      if (b == 0) {
        if (c == 0) {
          println(-1);
          return;
        } else {                                                                                               
          println(0);
          return;
        }
      } else {
        println(1);
        println(-c / b);
        return;
      }
    }

    double d = b * b - 4 * a * c;

    if (d < 0) {
      println(0);
      return;
    }

    double x1 = (-b + Math.sqrt(d)) / (2 * a);
    double x2 = (-b - Math.sqrt(d)) / (2 * a);

    if (d == 0) {
      println(1);
      println(x1);
    } else {
      println(2);
      println(Math.min(x1, x2));
      println(Math.max(x1, x2));
    }
  }

  public static void main(String... args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(new BufferedOutputStream(System.out));
    new P20B().run();
    br.close();
    pw.close();
  }

  static BufferedReader br;
  static PrintWriter pw;                                                                                                          
  StringTokenizer stok;

  String nextToken() throws IOException {
    while (stok == null || !stok.hasMoreTokens()) {
      String s = br.readLine();
      if (s == null) {
        return null;
      }
      stok = new StringTokenizer(s);
    }
    return stok.nextToken();
  }

  void print(byte b) {
    print("" + b);
  }

  void print(int i) {
    print("" + i);
  }

  void print(long l) {
    print("" + l);
  }

  void print(double d) {
    print("" + d);
  }

  void print(char c) {
    print("" + c);
  }

  void print(StringBuffer sb) {
    print("" + sb);
  }

  void print(String s) {
    pw.print(s);
  }

  void println(byte b) {
    println("" + b);
  }

  void println(int i) {
    println("" + i);
  }

  void println(long l) {
    println("" + l);
  }

  void println(double d) {
    println("" + d);
  }

  void println(char c) {
    println("" + c);
  }

  void println(StringBuffer sb) {
    println("" + sb);
  }

  void println(String s) {
    pw.println(s);
  }

  int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  char nextChar() throws IOException {
    return (char) (br.read());
  }

  String next() throws IOException {
    return br.readLine();
  }

}