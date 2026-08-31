import java.io.*;
import java.util.*;

public class A {
  
  public static void main(String[] args) throws Throwable {
    new A().go();
  }
  
  void p(String s) {
    System.out.println(s);
  }
  
  int pi(String s) {
    return Integer.parseInt(s);
  }
  
  void go() throws Throwable {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String[] t = in.readLine().split(" ");
    int n = Integer.parseInt(t[0]);
    int m = Integer.parseInt(t[1]);
    int[] v = new int[n];
    Arrays.fill(v, 950000000);
    int[] aq = new int[m];
    int[] al = new int[m];
    int[] ar = new int[m];
    int[] ax = new int[m];
    for (int i = 0; i < m; i++) {
      t = in.readLine().split(" ");
      aq[i] = pi(t[0]);
      al[i] = pi(t[1]) - 1;
      ar[i] = pi(t[2]) - 1;
      ax[i] = pi(t[3]);
    }
    
    for (int i = 0; i < m; i++) {
      int q = aq[i], l = al[i], r = ar[i], x = ax[i];
      if (q == 1) {
        for (int j = l; j <= r; j++) {
          v[j] += x;
        }
      } else {
        int mx = Integer.MIN_VALUE;
        for (int j = l; j <= r; j++) {
          if (v[j] > x) {
            v[j] = x;
          }
          if (v[j] > mx) {
            mx = v[j];
          }
        }
        if (mx < x) {
          p("NO");
          System.exit(0);
        }
      }
    }
    for (int i = 0; i < m; i++) {
      int q = aq[i], l = al[i], r = ar[i], x = ax[i];
      if (q == 1) {
        x = -x;
        for (int j = l; j <= r; j++) {
          v[j] += x;
        }
      }
    }
    int cv[] = new int[v.length];
    for (int i = 0; i < v.length; i++) {
      cv[i] = v[i];
    }
    for (int i = 0; i < m; i++) {
      int q = aq[i], l = al[i], r = ar[i], x = ax[i];
      if (q == 1) {
        for (int j = l; j <= r; j++) {
          v[j] += x;
        }
      } else {
        int mx = Integer.MIN_VALUE;
        for (int j = l; j <= r; j++) {
          if (v[j] > mx) {
            mx = v[j];
          }
        }
        if (mx != x) {
          p("NO");
          System.exit(0);
        }
      }
    }
    p("YES");
    for (int i = 0; i < n; i++) {
      System.out.print(cv[i] + (i == n - 1 ? "\n" : " "));
    }
  }
}