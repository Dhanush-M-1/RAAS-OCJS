
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class HelpVasilisa {
  public static PrintWriter out = new PrintWriter(System.out);
  public static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    //      int t = ni();
    //      while (t-- > 0)
    solve();
    out.flush();
  }

  static int r1;
  static int r2;
  static int c1;
  static int c2;
  static int d1;
  static int d2;

  private static void solve() {
    r1 = ni();
    r2 = ni();
    c1 = ni();
    c2 = ni();
    d1 = ni();
    d2 = ni();
    int[][] a = new int[2][2];
    for (int i = 1; i < 10; i++) {
      a[0][0] = i;
      for (int j = 1; j < 10; j++) {
        a[0][1] = j;
        for (int k = 1; k < 10; k++) {
          a[1][0] = k;
          for (int l = 1; l < 10; l++) {
            a[1][1] = l;
            if (check(a)) {
              out.println(i + " " + j + "\n" + k + " " + l);
              return;
            }
          }
        }
      }
    }
    out.println(-1);
  }

  private static boolean check(int[][] a) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        if (set.contains(a[i][j])) return false;
        set.add(a[i][j]);
      }
    }
    if (a[1][0] + a[0][0] != c1) return false;
    if (a[1][1] + a[0][1] != c2) return false;
    if (a[0][1] + a[0][0] != r1) return false;
    if (a[1][0] + a[1][1] != r2) return false;
    if (a[0][0] + a[1][1] != d1) return false;
    if (a[1][0] + a[0][1] != d2) return false;
    return true;
  }

  private static int ni() {
    return in.nextInt();
  }

  private static int[] na(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = ni();
    return a;
  }

  private static long[] nal(int n) {
    long[] a = new long[n];
    for (int i = 0; i < n; i++) a[i] = nl();
    return a;
  }

  private static long nl() {
    return in.nextLong();
  }

  private float nf() {
    return in.nextFloat();
  }

  private static double nd() {
    return in.nextDouble();
  }
}
