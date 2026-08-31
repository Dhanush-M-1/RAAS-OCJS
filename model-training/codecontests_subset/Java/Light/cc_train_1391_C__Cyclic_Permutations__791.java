/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class TaskC {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    long mod = 1_000_000_007L;
    long fact = 1;
    for (long i=1; i<=n; i++) {
      fact *= i;
      if (fact>=mod) {
        fact %= mod;
      }
    }
    long rowSum = 1;
    for (int i=0; i<n-1; i++) {
      rowSum *= 2L;
      if (rowSum>=mod) {
        rowSum %= mod;
      }
    }
    long ans = fact - rowSum;
    if (ans<0) {
      ans += mod;
    }
    System.out.println(ans);
  }
  

}

class MyUtils {
  static void shuffleArray(int[] arr) {
    int n = arr.length;
    Random rnd = new Random();
    for(int i=0; i<n; i++) {
      int tmp = arr[i];
      int randomPos = i + rnd.nextInt(n-i);
      arr[i] = arr[randomPos];
      arr[randomPos] = tmp;
    }
  }
  static void shuffleArray(long[] arr) {
    int n = arr.length;
    Random rnd = new Random();
    for(int i=0; i<n; i++) {
      long tmp = arr[i];
      int randomPos = i + rnd.nextInt(n-i);
      arr[i] = arr[randomPos];
      arr[randomPos] = tmp;
    }
  }
}
