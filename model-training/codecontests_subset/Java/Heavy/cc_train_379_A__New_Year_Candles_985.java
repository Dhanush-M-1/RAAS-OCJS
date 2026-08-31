import java.io.*;
import java.util.*;

public class cf379a {
  static FastIO in = new FastIO(), out = in;

  public static void main(String[] args) {
    int ok = in.nextInt();
    int bad = 0;
    int b = in.nextInt();
    
    int ans = 0;
    while(true) {
      ans += ok;
      bad += ok;
      ok = bad / b;
      bad %= b;
      if(ok == 0) break;
    }
    out.println(ans);
    
    out.close();
  }

  static class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    public FastIO() {
      this(System.in, System.out);
    }

    public FastIO(InputStream in, OutputStream out) {
      super(new BufferedWriter(new OutputStreamWriter(out)));
      br = new BufferedReader(new InputStreamReader(in));
      scanLine();
    }

    public void scanLine() {
      try {
        st = new StringTokenizer(br.readLine().trim());
      } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
      }
    }

    public int numTokens() {
      if (!st.hasMoreTokens()) {
        scanLine();
        return numTokens();
      }
      return st.countTokens();
    }

    public String next() {
      if (!st.hasMoreTokens()) {
        scanLine();
        return next();
      }
      return st.nextToken();
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
