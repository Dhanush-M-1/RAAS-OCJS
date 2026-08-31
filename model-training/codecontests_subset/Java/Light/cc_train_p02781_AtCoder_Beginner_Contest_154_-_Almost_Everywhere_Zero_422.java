import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author Silviase
 */
public class Main {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    EAlmostEverywhereZero solver = new EAlmostEverywhereZero();
    solver.solve(1, in, out);
    out.close();
  }

  static class EAlmostEverywhereZero {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
      // Nのlengthで考える
      // 例えば349なら3
      // ギリギリ(制約がある)とセーフ確定(なんでもいい)とアウトがある
      // 例えば左から一桁目が2,1,0ならセーフ確定,3ならギリギリ
      String n = in.next();
      int k = in.nextInt();
      int len = n.length();
      // g[i][j] = "i文字目まで見た"ときにj個使っているものの通り数
    /*
    配った方が良さそう
    (i) i文字目が0でないとき(x)
    g[i][j+1] = g[i-1][j]
    s[i][j+1] = g[i-1][j] * x-1(1~x-1)
              + g[i-1][j+1] * 1(0)
              + s[i-1][j] * 9 (1~9)
              + s[i-1][j+1] * 1  (0)
    s[i][0] = 1
    g[i][0] = 0
    (ii) i文字目が0
    g[i][j+1] = g[i-1][j+1]
    s[i][j+1] = s[i-1][j] * 9 (1~9)
              + s[i-1][j+1] * 1  (0)
    s[i][0] = 1
    g[i][0] = 0
     */

      int[][] giriGiri = new int[len + 1][k + 1];
      int[][] safeSafe = new int[len + 1][k + 1];

      giriGiri[0][0] = 1;
      for (int i = 1; i <= len; i++) {
        int x = n.charAt(i - 1) - '0';
        for (int j = 0; j < k; j++) {
          if (x == 0) {
            giriGiri[i][j + 1] = giriGiri[i - 1][j + 1];
            safeSafe[i][j + 1] = safeSafe[i - 1][j] * 9 + safeSafe[i - 1][j + 1];
            safeSafe[i][0] = 1;
            giriGiri[i][0] = 0;
          } else {
            giriGiri[i][j + 1] = giriGiri[i - 1][j];
            safeSafe[i][j + 1] = giriGiri[i - 1][j] * (x - 1)
                + giriGiri[i - 1][j + 1]
                + safeSafe[i - 1][j] * 9
                + safeSafe[i - 1][j + 1];
            safeSafe[i][0] = 1;
            giriGiri[i][0] = 0;
          }
        }
      }
    /*
    out.println("Girigiri");
    for (int i = 0; i <= len; i++) {
      for (int j = 0; j <= k; j++) {
        out.print(giriGiri[i][j] + " ");
      }
      out.println();
    }
    out.println("safesafe");
    for (int i = 0; i <= len; i++) {
      for (int j = 0; j <= k; j++) {
        out.print(safeSafe[i][j] + " ");
      }
      out.println();
    }
    
     */

      out.println(giriGiri[len][k] + safeSafe[len][k]);
    }

  }
}

