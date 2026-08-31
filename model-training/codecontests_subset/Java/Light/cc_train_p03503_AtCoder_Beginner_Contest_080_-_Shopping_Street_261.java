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
    CShoppingStreet solver = new CShoppingStreet();
    solver.solve(1, in, out);
    out.close();
  }

  static class CShoppingStreet {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
      int n = in.nextInt();
      boolean[][] isOpen = new boolean[n][10];
      int[][] profitTable = new int[n][11];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 10; j++) {
          // 店iは時刻jにopenしているか
          isOpen[i][j] = (in.nextInt() == 1);
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 11; j++) {
          profitTable[i][j] = in.nextInt();
        }
      }

      int ans = Integer.MIN_VALUE;
      boolean[] isJoisinoOpen = new boolean[10];

      for (int i = 1; i <= 1023; i++) {
        int num = i;
        int profitJoisinoGet = 0;
        for (int j = 0; j < 10; j++) {
          isJoisinoOpen[j] = ((num % 2) == 1);
          num /= 2;
        }

        int[] countBothOpen = new int[n];

        for (int j = 0; j < n; j++) {
          for (int k = 0; k < 10; k++) {
            if (isJoisinoOpen[k] && isOpen[j][k]) {
              countBothOpen[j]++;
            }
          }
          // out.println("both open:" + countBothOpen[j]);
          profitJoisinoGet += profitTable[j][countBothOpen[j]];
        }

        ans = Math.max(ans, profitJoisinoGet);

        // out.println("i:" + i + " profit:" + profitJoisinoGet);

      }

      out.println(ans);
    }

  }
}