import java.io.*;
import java.util.*;
public class G {
  static boolean doit = true;
  static int[] sd = new int[(int) 1e7+2];
  static int[] nr = new int[(int) 1e7+2];
  void solve() {
    if (doit) {
      for (int i = 1; i<=(int) 1e7; i++) {
        for (int j = i; j<=(int) 1e7; j+=i) {
          sd[j]+=i;
        }
        if (sd[i]<=(int) 1e7&&nr[sd[i]]==0) {
          nr[sd[i]]=i;
        }
      }
      doit=false;
    }
    int n = nextInt();
    out.println(nr[n]>0 ? nr[n] : -1);
  }
  static int nextInt() {
    return Integer.parseInt(nextToken());
  }
  static String nextToken() {
    while (!st.hasMoreTokens()) {
      try {
        st=new StringTokenizer(br.readLine());
      } catch (Exception e) {
        throw new RuntimeException("out of tokens!");
      }
    }
    return st.nextToken();
  }
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st = new StringTokenizer("");
  static PrintWriter out = new PrintWriter(System.out);
  public static void main(String[] a) {
    int t = nextInt();
    for (int i = 1; i<=t; i++) {
      new G().solve();
    }
    out.flush();
  }
}
