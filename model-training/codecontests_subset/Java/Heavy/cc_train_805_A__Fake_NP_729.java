import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemA {
  public static void main(String []args) {
    InputReader input = new InputReader(System.in);

    int l = input.nextInt();
    int r = input.nextInt();
    if (l == r) {
      System.out.println(l);
      return;
    }
    int twoCount = r / 2 - (l - 1) / 2;
    int threeCount = r / 3 - (l - 1) / 3;
    if (twoCount > threeCount) System.out.println(2);
    else System.out.println(3);
  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

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

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
