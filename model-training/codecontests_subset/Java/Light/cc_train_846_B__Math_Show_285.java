//package codeforces.er28;

import java.util.Arrays;
import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int m = scanner.nextInt();
    int a[] = new int[k];
    int sum[] = new int[k];
    for (int t = 0; t < k; t++) {
      a[t] = scanner.nextInt();
    }

    Arrays.sort(a);
    for (int t = 0; t < k; t++) {
      sum[t] = a[t];
      if (t != 0) sum[t] += sum[t-1];
    }

    int max = 0;
    for (int x = 0; x <= k; ++x) {
      for (int y = 0; y <=n; ++y) {
        for (int z = y-1; z < n; ++z) {
          int t = 0;
          if (x != 0) t = sum[x-1] * n;
          t += y == 0? 0 : sum[k-1] * y;
          if (x != 0) t -= sum[x-1] * y;
          t += x == k? 0 : a[x] * (z + 1 - y);
          if (t <= m) {
            int point = x * n + y * (k + 1) - x * y + (z + 1 - y);
            if (point > max) max = point;
          }
        }
      }
    }

    System.out.printf("%d\n", max);

  }
}