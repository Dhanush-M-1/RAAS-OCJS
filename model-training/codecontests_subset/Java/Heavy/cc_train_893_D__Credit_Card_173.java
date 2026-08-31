import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 public class _893D {

 }

 */
public class _893D {
  public void solve() throws FileNotFoundException {
    InputStream inputStream = System.in;

    InputHelper in = new InputHelper(inputStream);

    // actual solution
    int n = in.readInteger();
    int d = in.readInteger();

    int[] a = new int[n];

    long rd = 0;

    long[] rda = new long[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.readInteger();
      rd += a[i];

      rda[i] = rd;

      if (rd > d) {
        System.out.println("-1");
        return;
      }
    }

    long[] maxrda = new long[n];

    maxrda[n - 1] = rda[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      maxrda[i] = Math.max(rda[i], maxrda[i + 1]);
    }


    rd = 0;

    int ans = 0;
    long added = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        if (rd < 0) {
          long min = -rd;
          long max = i == n - 1 ? min : d - (maxrda[i + 1] + added);
          max = Math.min(max, d + min);

          if (min > max) {
            System.out.println("-1");
            return;
          }

          ans++;

          added += max;
          rd += max;
        }
      }

      rd += a[i];
    }

    System.out.println(ans);
    // end here
  }

  public static void main(String[] args) throws FileNotFoundException {
    (new _893D()).solve();
  }

  class InputHelper {
    StringTokenizer tokenizer = null;
    private BufferedReader bufferedReader;

    public InputHelper(InputStream inputStream) {
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      bufferedReader = new BufferedReader(inputStreamReader, 16384);
    }

    public String read() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          String line = bufferedReader.readLine();
          if (line == null) {
            return null;
          }
          tokenizer = new StringTokenizer(line);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      return tokenizer.nextToken();
    }

    public Integer readInteger() {
      return Integer.parseInt(read());
    }

    public Long readLong() {
      return Long.parseLong(read());
    }
  }
}
