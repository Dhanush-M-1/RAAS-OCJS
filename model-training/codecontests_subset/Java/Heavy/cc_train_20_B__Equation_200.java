import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution20B {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Solver20B solver = new Solver20B();
    solver.solve(0, in, out);
    out.close();
  }

  static class Solver20B {
    NumberFormat formatter = new DecimalFormat("#0.00000000");
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();

      if (a == 0) {
        if (b == 0) {
          if (c == 0) {
            out.println(-1);
          } else {
            out.println(0);
          }
        } else {
          out.println(1);
          out.println(formatter.format(-(double) c * 1.0 / (double) b));
        }
      } else {
        long tmp = (long) b * (long) b - 4L * (long) a * (long) c;
        if (tmp >= 0) {
          double sqrt = Math.sqrt((double) tmp / (4.0 * (double) a * (double) a));
          double d = (double) b / 2.0 / (double) a;
          if (tmp > 0) {
            out.println(2);
            out.println(formatter.format(-sqrt - d));
            out.println(formatter.format(sqrt - d));
          } else {
            out.println(1);
            out.println(formatter.format(-d));
          }
        } else {
          out.println(0);
        }
      }
    }
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}