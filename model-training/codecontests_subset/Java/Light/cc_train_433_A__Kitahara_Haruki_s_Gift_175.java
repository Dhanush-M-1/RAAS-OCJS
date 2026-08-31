import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++)
      sum += a[i] = in.nextInt();

    if (sum % 100 == 0) {
      sum /= 2;
      Arrays.sort(a);
      for (int i = n - 1; i > -1; i--)
        if (sum >= a[i])
          sum -= a[i];
      System.out.println(sum == 0 ? "YES" : "NO");
    } else
      System.out.println("NO");
  }
}
