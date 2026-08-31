/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class TaskD {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int n = Integer.parseInt(br.readLine());
    long[] sums = new long[n];
    String[] s = br.readLine().split(" ");
    for (int i=0; i<n; i++) {
      sums[i] = Long.parseLong(s[i]);
    }
    int[] ans = new int[n];
    FT1 ft = new FT1(n);
    TreeSet<Integer> vis = new TreeSet<>();
    for (int i=1; i<=n; i++) {
      vis.add(i);
    }
    for (int i=n-1; i>=0; i--) {
      int lo = 1;
      int hi = n;
      //System.out.println("Index: "+i);
      while (lo<=hi) {
        long mid = (lo+hi)/2;
        if (!vis.contains((int)mid)) {
          Integer hier = vis.higher((int)mid);
          if (hier!=null && hier<=hi) {
            mid = (int)hier;
          } else {
            Integer loer = vis.lower((int)mid);
            mid = (int)loer;
          }
        }
        long sub = ft.sum((int)mid-1);
        //System.out.printf("Trying: %d, sub is: %d\n", mid, sub);
        long val = (mid*(mid-1))/2 - sub;
        if (val==sums[i]) {
          ans[i] = (int)mid;
          break;
        } else if (val<sums[i]) {
          lo = (int)mid+1;
        } else {
          hi = (int)mid-1;
        }
      }
      ft.add(ans[i], ans[i]);
      vis.remove(ans[i]);
    }
    for (int i=0; i<n; i++) {
      sb.append(ans[i]);
      sb.append((i==n-1) ? "\n" : " ");
    }
    System.out.print(sb);
  }
}
class FT1 {
  long[] arr;
  FT1(int n) { arr = new long[n + 1]; } // Initialize with 0's
  FT1(long[] vals) { // Initialize using array, vals[0] is unused
    arr = (long[]) vals.clone();
    for (int i = 1; i < arr.length; i++) {
      int j = i + (i & -i);
      if (j < arr.length) arr[j] += arr[i]; } }
  long sum(int i, int j) { // Get the sum of [i,j]
    return sum(j) - sum(i - 1); }
  long sum(int i) { // Get the sum of [1,i]
    long sum = 0; while (i > 0) { sum += arr[i]; i -= i & -i; } return sum; }
  void add(int i, int delta) { // Add delta to value at i
    if (i <= 0) return;
    while (i < arr.length) { arr[i] += delta; i += i & -i; } } }
