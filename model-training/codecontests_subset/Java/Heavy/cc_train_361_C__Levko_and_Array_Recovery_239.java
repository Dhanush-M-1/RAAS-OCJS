import java.io.*;
import java.util.*;

public class cf360a {
  static FastIO in = new FastIO(), out = in;

  public static void main(String[] args) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] v = new int[n];
    int[] t = new int[m];
    int[] l = new int[m];
    int[] r = new int[m];
    int[] x = new int[m];
    boolean[] init = new boolean[n];
    for(int i=0; i<m; i++) {
      t[i] = in.nextInt();
      l[i] = in.nextInt()-1;
      r[i] = in.nextInt()-1;
      x[i] = in.nextInt();
    }
    for(int i=m-1; i>=0; i--) {
      if(t[i] == 2) {
        for(int j=l[i]; j<=r[i]; j++) {
          if(!init[j]) v[j] = x[i];
          else v[j] = Math.min(v[j], x[i]);
          init[j] = true;
        }
      }
      else {
        for(int j=l[i]; j<=r[i]; j++) {
          if(init[j]) v[j] -= x[i];
        }
      }
    }
    int[] a = new int[n];
    for(int i=0; i<n; i++)
      if(init[i]) a[i] = v[i];
      else a[i] = v[i] = 0;
    
    boolean ok = true;
    for(int i=0; i<m; i++) {
      if(t[i] == 2) {
        int max = v[l[i]];
        for(int j=l[i]+1; j<=r[i]; j++)
          max = Math.max(max, v[j]);
        if(max != x[i]) ok = false;
      }
      else {
        for(int j=l[i]; j<=r[i]; j++)
          v[j] += x[i];
      }
    }

    if(!ok) {
      out.println("NO");
    }
    else {
      out.println("YES");
      for(int z : a) out.print(z+" ");
      out.println();
    }
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
