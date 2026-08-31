import java.io.*;
import java.util.*;

public class GFG {

  static StringBuffer str = new StringBuffer("");
  static long n;

  // Refer whatsapp chat with Harsha
  static void solve() {
    n = 2 * n;
    str.append(String.format("%.9f", ((float) 1 / Math.sin((float) Math.PI / (2.0 * n))) / 2.0) + "\n");
  }

  public static void main(String[] args) throws Exception {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(bf.readLine());
    while (t-- > 0) {
      n = Long.parseLong(bf.readLine());
      solve();
    }
    System.out.println(str);
  }
}
