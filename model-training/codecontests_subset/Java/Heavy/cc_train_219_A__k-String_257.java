import java.io.*;
import java.util.*;
//import java.math.*; // for bigInteger

public class Main {

  static InputReader sc;
  static PrintWriter out;

  public static void main(String args[]) throws Exception {
    sc = new InputReader();
    out = new PrintWriter(System.out);
    int t = 1;  
    //t = sc.nextInt();
    for (int tt = 1; tt <= t; ++tt)
      solve(tt);
    out.close();
  }
  
  static void solve(int t) {
    int k = sc.nextInt();
    String s = sc.next();
    int[] count = new int[26];
    for(int i=0;i<s.length();++i) ++count[s.charAt(i)-'a']; 
    boolean possible = true;
    for(int i=0;i<26;++i)  if(count[i]%k!=0) possible = false;
    if(!possible) out.println(-1);
    else {
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<26;++i) {
        for(int j=0;j<count[i]/k;++j) {
          sb.append((char)(i+97));
        }
      }
      for(int i=0;i<k;++i) {
        out.print(sb);
      }
    } 
  } 

  public static class InputReader {
    BufferedReader br;
    StringTokenizer st;

    InputReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
        }
      }
      return st.nextToken();
    }
  }

  /*
   * private final static int m =(int)1e9+7; private static class Pair<T,V> { T
   * first; V second; Pair(final T first, final V second) { this.first = first;
   * this.second = second; } public boolean equals(Object o) { Pair given =
   * (Pair)o; if(given.first == first && given.second == second) return true;
   * return false; } public int hashCode() { long temp =
   * (long)(first.hashCode())*31; temp = (temp+(long)second.hashCode())%m; return
   * (int)temp; } }
   */

  public static void debug(final int[]... var) {
    for (final int[] row : var) {
      debug(row);
    }
  }

  public static void debug(final long[]... var) {
    for (final long[] row : var) {
      debug(row);
    }
  }

  public static void debug(final String[]... var) {
    for (final String[] row : var) {
      debug(row);
    }
  }

  public static void debug(final double[]... var) {
    for (final double[] row : var) {
      debug(row);
    }
  }

  public static void debug(final char[]... var) {
    for (final char[] row : var) {
      debug(row);
    }
  }

  public static void debug(final int... var) {
    for (final int i : var)
      System.err.print(i + " ");
    System.err.println();
  }

  public static void debug(final String... var) {
    for (final String i : var)
      System.err.print(i + " ");
    System.err.println();
  }

  public static void debug(final double... var) {
    for (final double i : var)
      System.err.print(i + " ");
    System.err.println();
  }

  public static void debug(final long... var) {
    for (final long i : var)
      System.err.print(i + " ");
    System.err.println();
  }

  public static void debug(final char... var) {
    for (final char c : var)
      System.err.print(c + " ");
    System.err.println();
  }

  /*
   * public static <T> void debug(T ...varargs) { // Warning // Heap Pollution
   * might occur // this overrides even 1d and 2d array methods as it is an
   * object... // + i am not using object based array like Integer[] // I am using
   * int[] so that is a problem as i need Wrapper class as an argument for(T
   * val:varargs) System.err.printf("%s ",val); System.err.println(); }
   */
}
