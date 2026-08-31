import java.util.*;
import java.io.*;

public class P236C {


  private static void solve() {
    long n = nextInt();

    if (n < 3) {
      System.out.println(n);
    } else if (n % 2 != 0) {
      System.out.println(n * (n - 1) * (n - 2));
    } else {
      if (n % 3 != 0) {
        System.out.println(n * (n - 1) * (n - 3));
      } else {
        System.out.println((n - 1) * (n - 2) * (n - 3));
      }
    }
  }

  private static void run() {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);

    solve();

    out.close();
  }

  private static StringTokenizer st;
  private static BufferedReader br;
  private static PrintWriter out;

  private static String next() {
    while (st == null || !st.hasMoreElements()) {
      String s;
      try {
        s = br.readLine();
      } catch (IOException e) {
        return null;
      }
      st = new StringTokenizer(s);
    }
    return st.nextToken();
  }

  private static int nextInt() {
    return Integer.parseInt(next());
  }

  private static long nextLong() {
    return Long.parseLong(next());
  }

  public static void main(String[] args) {
    run();
  }
}