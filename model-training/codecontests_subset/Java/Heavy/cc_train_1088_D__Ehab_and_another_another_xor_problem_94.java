import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class _1088D {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Solver solver = new Solver();
    solver.solve(in, out);
    out.close();
  }

  private static class Solver {
    private void solve(InputReader in, PrintWriter out) {
      int a = 0;
      int b = 0;
      System.out.println(" ? 0 0");
      System.out.flush();
      int nextBigger = in.nextInt();
      for (int i = 29; i >= 0; i--) {
        System.out.println(" ? " + (a + (1 << i)) + " " + b);
        System.out.flush();
        int tmp1 = in.nextInt();
        System.out.println(" ? " + a + " " + (b + (1 << i)));
        System.out.flush();
        int tmp2 = in.nextInt();
        if (tmp1 != tmp2) {
          if (tmp1 == -1) {
            a += (1 << i);
            b += (1 << i);
          }
        } else {
          if (nextBigger == 1) {
            a += (1 << i);
          } else {
            b += (1 << i);
          }
          nextBigger = tmp1;
        }
      }
      System.out.println("! " + a + " " + b);
    }
  }

  private static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    private InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    private String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    private int nextInt() {
      return Integer.parseInt(next());
    }

    private long nextLong() {
      return Long.parseLong(next());
    }
  }
}