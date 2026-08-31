import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
  int n;
  int[][] f;
  int[][] p;
  int[] table;
  int res;
  public static void main(String[] args) {
    new Main().solve();
  }

  private void solve() {
    try(InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out)) {

      n = in.nextInt();
      f = new int[n][10];
      for (int i = 0; i < n; i++) {
        f[i] = in.mapInt(10);
      }
      p = new int[n][11];
      for (int i = 0; i < n; i++) {
        p[i] = in.mapInt(11);
      }

      table = new int[10];
      res = Integer.MIN_VALUE;
      dfs(0);

      final int ans = res;
      out.println(ans);
    }
    catch(IOException e) {
      System.err.println(e);
    }
  }

  void evalute(){
    int sum = 0;
    boolean isAllZero = true;
    for (int i : table) {
      if(i == 0) continue;
      isAllZero = false;
    }
    if(isAllZero) return;

    for (int i = 0; i < n; i++) {
      int s = 0;
      for (int j = 0; j < 10; j++) {
        if(table[j] == 0) continue;
        s += f[i][j];
      }
      sum += p[i][s];
    }

    if(res < sum) {
      res = sum;
    }
  }

  void dfs(int cnt) {
    if(cnt == 10) evalute();
    else {
      table[cnt] = 0; dfs(cnt+1);
      table[cnt] = 1; dfs(cnt+1);
    }
  }

  int atoi(String s) { return Integer.parseInt(s); }
  long atol(String s) { return Long.parseLong(s); }

  static class InputReader implements AutoCloseable {
    public BufferedReader br;
    public StringTokenizer st;

    public InputReader(InputStream stream) {
      br = new BufferedReader(new InputStreamReader(stream), 32768);
      st = null;
    }
    public String next() {
      if (st == null || !st.hasMoreTokens()) {
        try { st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          throw new UncheckedIOException(e);
        }
      }
      return st.nextToken();
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public long nextLong() { return Long.parseLong(next()); }
    int[] mapInt(int len) {
      int[] ret = new int[len];
      for (int i = 0; i < len; i++) ret[i] = Integer.parseInt(next());
      return ret;
    }
    long[] mapLong(int len) {
      long[] ret = new long[len];
      for (int i = 0; i < len; i++) ret[i] = Long.parseLong(next());
      return ret;
    }
    @Override public void close() throws IOException { br.close(); }
  }
}