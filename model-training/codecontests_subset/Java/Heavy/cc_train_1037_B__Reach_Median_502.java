import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class C0902201802 {

  private static void solve(final Input input, final PrintWriter output) throws IOException {
    int n = input.nextInt();
    int s = input.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = input.nextInt();
    }
    Arrays.sort(array);
    long count = 0;
    if (array[n / 2] > s) {
      for (int i = n / 2; i >= 0; i--) {
        if (array[i] > s) {
          count += array[i] - s;
        } else {
          break;
        }
      }
    } else if (array[n / 2] < s) {
      for (int i = n / 2; i < n; i++) {
        if (array[i] < s) {
          count += s - array[i];
        } else {
          break;
        }
      }
    }
    output.println(count);
  }

  public static void main(String[] args) throws IOException {
    try (final PrintWriter output = new PrintWriter(System.out);
        final Input input = new Input(new BufferedReader(new InputStreamReader(System.in)))) {
      solve(input, output);
    }
  }

  private static class Input implements Closeable {

    private final BufferedReader bufferedReader;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final static char[] SEPERATOR = { '\t', '\n', '\r', ' ' };

    public Input(final BufferedReader in) {
      this.bufferedReader = in;
    }

    private boolean isAnySeperator(final char ch) {
      return ch == SEPERATOR[3] || ch == SEPERATOR[1] || ch == SEPERATOR[0] || ch == SEPERATOR[2];
    }

    private boolean isLineSeperator(final char ch) {
      return ch == SEPERATOR[1] || ch == SEPERATOR[2];
    }

    public String next() throws IOException {
      stringBuilder.setLength(0);
      while (true) {
        int c = bufferedReader.read();
        if (c == -1) {
          return null;
        }
        char ch = (char) c;
        if (!isAnySeperator(ch)) {
          stringBuilder.append(ch);
          break;
        }
      }
      while (true) {
        int c = bufferedReader.read();
        char ch = (char) c;
        if (c == -1 || isAnySeperator(ch)) {
          break;
        }
        stringBuilder.append(ch);
      }
      return stringBuilder.toString();
    }

    public String nextLine() throws IOException {
      stringBuilder.setLength(0);
      while (true) {
        final int c = bufferedReader.read();
        if (c == -1) {
          return null;
        }
        final char ch = (char) c;
        if (!isLineSeperator(ch)) {
          stringBuilder.append(ch);
          break;
        }
      }
      while (true) {
        int c = bufferedReader.read();
        char ch = (char) c;
        if (c == -1 || isLineSeperator(ch)) {
          break;
        }
        stringBuilder.append(ch);
      }
      return stringBuilder.toString();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next(), 10);
    }

    public long nextLong() throws IOException {
      return Long.parseLong(next(), 10);
    }

    @Override
    public void close() throws IOException {
      bufferedReader.close();
    }
  }
}