import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 */

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
         int n = sc.nextInt();
         int[] a = new int[n];
         int[] ans = new int[n+1];
         for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
         }
         findAns(a, ans, 0, n-1, 0);
         for (int i = 0; i < n; i++) {
            System.out.printf("%d ", ans[i]);
         }
         System.out.println();
      }
   }

   private static void findAns(int[] a, int[] ans, int start, int end, int depth) {
      int mx = -1, mxi=-1;
      if (start>end) return;
      if (start==end) {
         ans[start] = depth;
         return;
      }
      for (int i = start; i <= end; i++) {
         if (a[i]>mx) {
            mx = a[i];
            mxi = i;
         }
      }
      ans[mxi] = depth;
      findAns(a, ans, start, mxi-1, depth+1);
      findAns(a, ans, mxi+1, end, depth+1);
   }
}