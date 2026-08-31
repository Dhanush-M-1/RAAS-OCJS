import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args){
    FastScanner sc = new FastScanner();
    int n = sc.nextInt();
    int[] a = new int[n];
    int max = -1;
    for(int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      max = Math.max(a[i], max);
    }

    long freeRounds = 0;
    for(int i = 0; i < n; i++) {
      freeRounds += max - a[i];
    }

    long result = max;

    if(freeRounds < result) {
      long diff = result - freeRounds;
      result += (diff / (n - 1));
      if(diff % (n - 1) != 0) result++;
    }

    System.out.println(result);
  }

  public static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(String s) {
      try {
        br = new BufferedReader(new FileReader(s));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    public FastScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() {
      while (st == null || !st.hasMoreElements()) try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(nextToken());
    }

    long nextLong() {
      return Long.parseLong(nextToken());
    }

    double nextDouble() {
      return Double.parseDouble(nextToken());
    }
  }
}
