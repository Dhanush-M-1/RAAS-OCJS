import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author El Mehdi ASSALI
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    CCaninePoetry solver = new CCaninePoetry();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class CCaninePoetry {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
      char[] s = in.next().toCharArray();
      int answer = 0;
      for (int i = 0; i < s.length; i++) {
        if (i - 1 >= 0 && s[i] == s[i - 1]) {
          answer++;
          s[i] = '_';
        }
        if (s[i] != '_' && i - 2 >= 0 && s[i] == s[i - 2]) {
          answer++;
          s[i] = '_';
        }
      }
      out.println(answer);
    }

  }
}

