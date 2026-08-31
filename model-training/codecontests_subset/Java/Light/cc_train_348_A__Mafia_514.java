import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
  public static boolean ok(long x, int[] a) {
    long res = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > x)
        return false;
      res += x - a[i];
      res = Math.min(res, x);
    }
    return (res >= x);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] Line = br.readLine().split(" ");
    int[] a = new int[Line.length];
    for (int i = 0; i < a.length; i++) {
      a[i] = Integer.parseInt(Line[i]);
    }
    long low = 0, hig = (long)1e17;
    while (low + 1 < hig) {
      long mid = low + (hig - low) / 2;
      if (!ok(mid, a))
        low = mid;
      else
        hig = mid;
    }
    System.out.println(hig);
  }
}