/*
 *created by Kraken on 02-05-2020 at 14:27
 */
//package com.kraken.cf.practice;

import java.util.*;
import java.io.*;

public class D1334 {

  public static void main(String[] args) {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      long l = sc.nextLong(), r = sc.nextLong();
      long[] block = new long[n + 1];
      block[0] = 0;
      for (int i = 1; i <= n; i++) block[i] = 2 * (n - i) + block[i - 1];
      block[n] += 2;
//      System.out.println(Arrays.toString(block));
      long left = findBlock(block, l);
      long right = findBlock(block, r);
//      System.out.printf("left: %d, right: %d\n", left, right);
      long curr = left;
      ArrayList<Long> path = new ArrayList<>();
      while (curr <= right) {
        for (long i = curr + 1; i <= n; i++) {
          path.add(curr);
          path.add(i);
        }
        curr++;
      }
      if (right == n) path.add(1L);
//      System.out.println(path.toString());
      StringBuilder sb = new StringBuilder();
      long lidx = l - block[(int) (left - 1)] - 1;
      for (int i = 0; i < r - l + 1; i++) {
        sb.append(path.get((int) (lidx + i))).append(" ");
      }
      System.out.println(sb.toString());
    }
  }

  private static int findBlock(long[] a, long key) {
    int l = 1, r = a.length - 1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (a[mid] >= key) r = mid;
      else l = mid + 1;
    }
    return r;
  }

  static class FastReader {

    BufferedReader br;

    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
