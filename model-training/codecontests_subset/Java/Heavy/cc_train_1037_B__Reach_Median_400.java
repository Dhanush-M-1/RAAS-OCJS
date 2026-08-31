/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class TaskB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    long target = Long.parseLong(s[1]);
    long[] arr = new long[n];
    s = br.readLine().split(" ");
    for (int i=0; i<n; i++) {
      arr[i] = Long.parseLong(s[i]);
    }
    Arrays.sort(arr);
    int mid = n/2;
    if (arr[mid]==target){
      System.out.println(0);
      return;
    }
    long total = 0;
    if (arr[mid]>target) {
      for (int i=mid; i>=0; i--) {
        if (arr[i]>target) {
          total += arr[i]-target;
        } else {
          break;
        }
      }
    } else {
      for (int i=mid; i<n; i++) {
        if (arr[i]<target) {
          total += target-arr[i];
        } else {
          break;
        }
      }
    }
    System.out.println(total);

  }
}
