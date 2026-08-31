/**
 * Codeforces Beta Round 20
 * 
 * @author ProjectYoung
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF20B {
  private void solve(InputReader in, PrintWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    if (a == 0) {
      if (b == 0) {
        out.println(c == 0 ? -1 : 0);
      } else {
        out.println(1);
        out.printf("%.8f", (double) -c / b);
      }
    } else {
      long d = (long) b * b - 4L * a * c;
      if (d < 0) {
        out.println(0);
      } else if (d == 0) {
        out.println(1);
        out.printf("%.8f", (double) -b / a / 2);
      } else {
        out.println(2);
        double sqr = Math.sqrt(d);
        double[] ans = {(-sqr - b) / a / 2, (sqr - b) / a / 2};
        Arrays.sort(ans);
        out.printf("%.8f\n%.8f", ans[0], ans[1]);
      }
    }
  }

  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    new CF20B().solve(in, out);
    out.close();
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
