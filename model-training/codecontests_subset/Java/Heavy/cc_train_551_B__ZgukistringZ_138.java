import java.io.*;
import java.util.*;

public class A {

  public static boolean canTake(int[] fs, int[] fa) {
    for(int i = 0; i < 26; i++) {
      if(fa[i] > fs[i])
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int[] fs = new int[26];
    int[] fa = new int[26];
    int[] fb = new int[26];
    String s = sc.nextLine();
    String a = sc.nextLine();
    String b = sc.nextLine();

    for(int i = 0; i < s.length(); i++) {
      fs[s.charAt(i) - 'a']++;
    }

    for(int i = 0; i < a.length(); i++) {
      fa[a.charAt(i) - 'a']++;
    }

    for(int i = 0; i < b.length(); i++) {
      fb[b.charAt(i) - 'a']++;
    }

    int res1 = 0, res2 = 0;
    for(int i = 0; ; i++) {
      // Calculate amount of b that we can take.
      int x = s.length();
      for(int j = 0; j < 26; j++) {
        if(fb[j] != 0)
          x = Math.min(x, fs[j] / fb[j]);
      }

      if(x + i > res1 + res2) {
        res1 = i;
        res2 = x;
      }

      // Now take one a from s.
      if(canTake(fs, fa)) {
        for(int j = 0; j < 26; j++) {
          fs[j] -= fa[j];
        }
      } else
        break;
    }

    // Calculate the final string.
    StringBuilder res = new StringBuilder();
    int[] f = new int[26];
    for(int i = 0; i < s.length(); i++) {
      f[s.charAt(i) - 'a']++;
    }

    for(int i = 0; i < 26; i++) {
      f[i] -= res1 * fa[i];
      f[i] -= res2 * fb[i];
    }

    for(int i = 0; i < res1; i++) {
      res.append(a);
    }
    for(int i = 0; i < res2; i++) {
      res.append(b);
    }

    for(int i = 0; i < 26; i++) {
      while(f[i]-- > 0)
        res.append((char)(i + 'a'));
    }

    System.out.println(res.toString());

    out.close();
  }

  public static PrintWriter out;

}

class MyScanner {
  BufferedReader br;
  StringTokenizer st;

  public MyScanner() {
     br = new BufferedReader(new InputStreamReader(System.in));
  }

  String next() {
    while (st == null || !st.hasMoreElements()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }

  int nextInt() {
    return Integer.parseInt(next());
  }

  long nextLong() {
    return Long.parseLong(next());
  }

  double nextDouble() {
    return Double.parseDouble(next());
  }

  String nextLine(){
    String str = "";
    try {
       str = br.readLine();
    } catch (IOException e) {
       e.printStackTrace();
    }
    return str;
  }

}
