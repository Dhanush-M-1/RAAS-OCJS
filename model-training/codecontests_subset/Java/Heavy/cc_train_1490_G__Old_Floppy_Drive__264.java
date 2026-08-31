/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 */

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int t = Integer.parseInt(br.readLine());

      while (t-- > 0) {
         String[] line = br.readLine().split(" ");
         int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
         int[] a = new int[n], x = new int[m];
         line = br.readLine().split(" ");
         for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(line[i]);
         }
         line = br.readLine().split(" ");
         for (int i = 0; i < m; ++i) {
            x[i] = Integer.parseInt(line[i]);
         }

         long[] prefix = new long[n+1];
         for (int i = 0; i < n; ++i) {
            prefix[i+1] = prefix[i] + a[i];
         }
         List<long[]> pref = new ArrayList<>();
         pref.add(new long[]{0, 0});
         for (int i = 1; i <= n; ++i) {
            if (prefix[i] > pref.get(pref.size()-1)[0]) {
               pref.add(new long[]{prefix[i], i - 1});
            }
         }
         long max = pref.get(pref.size()-1)[0];

         for (int i = 0; i < m; ++i) {
            long ans = -1;

            if (x[i] <= max) {
               int l = 0, r = pref.size();
               while (l < r) {
                  int mid = (l + r) >> 1;
                  if (pref.get(mid)[0] < x[i]) {
                     l = mid + 1;
                  } else {
                     r = mid;
                  }
               }
               ans = pref.get(l)[1];
            } else if (prefix[n] > 0) {
               long need = (x[i] - max + prefix[n] - 1) / prefix[n];
               x[i] -= need * prefix[n];
               int l = 0, r = pref.size();
               while (l < r) {
                  int mid = (l + r) >> 1;
                  if (pref.get(mid)[0] < x[i]) {
                     l = mid + 1;
                  } else {
                     r = mid;
                  }
               }
               ans = pref.get(l)[1] + need * n;
            }

            bw.write(Long.toString(ans));
            bw.write(' ');
         }
         bw.newLine();
      }


      br.close();
      bw.close();
   }
}