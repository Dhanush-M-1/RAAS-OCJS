import java.util.Arrays;
import java.util.Scanner;

public class Problem893D {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long d = in.nextLong();
    long[] a = new long[n];
    long[] amounts = new long[n];
    int res = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
      if (i == 0) amounts[0] = a[i];
      else {
        amounts[i] = amounts[i - 1] + a[i];
      }
      if (amounts[i] > d) {
        System.out.println(-1);
        return;
      }
    }
    long[] max = new long[n]; // max[i] = max(amount[i...n])
    max[n - 1] = amounts[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      max[i] = Math.max(max[i + 1], amounts[i]);
    }

//    System.out.println(Arrays.toString(amounts));
//    System.out.println(Arrays.toString(max));

    long added = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        if (added + amounts[i] < 0) {
          added += Math.max(d - (added + max[i]), 0 - (amounts[i] + added));
          res++;
        }
      } else if (added + amounts[i] > d) {
        System.out.println(-1);
        return;
      }
    }

    System.out.println(res);
  }
}
