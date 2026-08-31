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
    AGC005ASTring solver = new AGC005ASTring();
    solver.solve(1, in, out);
    out.close();
  }

  static class AGC005ASTring {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
      String s = in.next();
      int res = 0;
      int sCnt = 0;
      // scnt = 0の状態でT -> res++;
      // 最後にscntを足す
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'S') {
          sCnt++;
        } else {
          if (sCnt > 0) {
            sCnt--;
          } else {
            res++;
          }
        }
      }

      out.println(res + sCnt);
    }

  }
}

