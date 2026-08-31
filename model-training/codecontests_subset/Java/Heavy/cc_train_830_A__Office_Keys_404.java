import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author greperror
 */
public class Main {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskD solver = new TaskD();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskD {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int k = in.nextInt();
      int p = in.nextInt();
      int arrn[] = new int[n];
      int arrk[] = new int[k];
      for (int i = 0; i < n; i++) {
        arrn[i] = in.nextInt();
      }
      for (int i = 0; i < k; i++) {
        arrk[i] = in.nextInt();
      }
      ArrayUtils.randomizeAndSortArray(arrk);
      ArrayUtils.randomizeAndSortArray(arrn);
      int ans = Integer.MAX_VALUE;
      int s, e;
      for (s = 0; s <= k - n; s++) {
        e = s + n - 1;
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
          max = Math.max(max, Math.abs(arrn[i] - arrk[s + i]) + Math.abs(arrk[s + i] - p));
          max2 = Math.max(max2, Math.abs(arrn[n - i - 1] - arrk[s + i]) + Math.abs(arrk[s + i] - p));
        }
        int min = Math.min(max, max2);
        ans = Math.min(min, ans);
      }
      out.println(ans);
    }

  }

  static class ArrayUtils {

    public static int[] randomizeAndSortArray(int[] a) {
      int n = a.length;
      Random r = new Random();
      for (int iter = 0; iter < 100000; iter++) {
        int x = r.nextInt(n), y = r.nextInt(n);
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
      }
      Arrays.sort(a);
      return a;
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

