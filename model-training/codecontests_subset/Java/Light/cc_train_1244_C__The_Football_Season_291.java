/*
 *created by Kraken on 07-05-2020 at 01:43
 */
//package com.kraken.cf.cf592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

  public static void main(String[] args) {
    FastReader sc = new FastReader();
    long n = sc.nextLong(), p = sc.nextLong(), w = sc.nextLong(), d = sc.nextLong();
    for (int i = 0; i < w; i++) {
      long pleft = p - d * i;
      if (pleft >= 0 && pleft % w == 0 && pleft / w <= n - i) {
        System.out.printf("%d %d %d\n", pleft / w, i, (n - i - pleft / w));
        return;
      }
    }
    System.out.println(-1);
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
