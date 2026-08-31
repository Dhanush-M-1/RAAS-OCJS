import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author svilen.marchev@gmail.com
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputStreamReader in = new InputStreamReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskA solver = new TaskA();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskA {
    public void solve(int testNumber, InputStreamReader in, PrintWriter out) {
      SvScanner sc = new SvScanner(in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < n; ++i) {
        int a = sc.nextInt();
        if (k % a == 0) {
          min = Math.min(min, k / a);
        }
      }
      out.println(min);
    }

  }

  static class SvScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer = new StringTokenizer("");

    public SvScanner(InputStreamReader in) {
      reader = new BufferedReader(in);
    }

    public String next() {
      try {
        while (!tokenizer.hasMoreTokens()) {
          String nextLine = reader.readLine();
          if (nextLine == null) {
            throw new IllegalStateException("next line is null");
          }
          tokenizer = new StringTokenizer(nextLine);
        }
        return tokenizer.nextToken();
      } catch (IOException e) {
        throw new IllegalStateException(e);
      }
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

  }
}

