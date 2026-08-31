import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import javax.print.attribute.HashAttributeSet;

public class CodeForces {

  public void solve() throws IOException, NoSuchAlgorithmException {
    int k = nextInt();
    char[] str = nextToken().toCharArray();
    Arrays.sort(str);
    char[] res = new char[str.length];
    boolean can = true;
    if (str.length % k != 0) {
      can = false;
    } else {
      for (int i = 0, l = str.length; i < l; i+=k) {
        int temp = str[i];
        for (int j = 0; j < k; j++) {
          if(str[i+j]!=temp) {
            can = false;
          } else {
            res[i/k+l*j/k]=str[i+j];
          }
        }
      }
    }

    if (can) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0, l = res.length; i < l; i++) {
        sb.append(res[i]);
      }
      out.print(sb.toString());
    } else {
      out.print(-1);
    }

  }

  private boolean test(String n) {
    if (n.charAt(0) != n.charAt(1) && n.charAt(0) != n.charAt(2) && n.charAt(0) != n.charAt(3) && n.charAt(1) != n.charAt(2)
        && n.charAt(1) != n.charAt(3) && n.charAt(2) != n.charAt(3)) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    new CodeForces().run();
  }

  long NOD(long a, long b) {
    while (a != 0 && b != 0) {
      if (a >= b)
        a = a % b;
      else
        b = b % a;
    }
    return a + b;
  }

  BufferedReader reader;
  StringTokenizer tokenizer;
  PrintWriter out;
  boolean isOuterFile = false;

  public void run() {
    try {
      if (isOuterFile) {
        reader = new BufferedReader(new FileReader("input.txt"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        out = new PrintWriter(System.out);
      } else {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
      }

      tokenizer = null;
      // long t=new Date().getTime();
      solve();
      // writer.println(t-new Date().getTime());
      reader.close();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  String nextToken() throws IOException {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }
}