//package com.example.demo_Amdocs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- != 0) {
      String s = br.readLine().trim();
      String ss[] = s.split("\\s+");
      int n = Integer.parseInt(ss[0]);
      int m = Integer.parseInt(ss[1]);
      s = br.readLine().trim();
      int a[] = new int[n];
      String ts = br.readLine().trim();
      ss = ts.split("\\s+");
      for (int i = 0; i < m; i++) {
        a[Integer.parseInt(ss[i]) - 1]++;
      }
      int ind = n;
      boolean chk=(a[n - 1] != 0) ? false : true;
      for (int i = n - 2; i >= 0; i--) {
        if (chk && a[i] != 0) {
          chk=false;
          ind = i+1;
        }
        a[i] += a[i + 1];
      }
      int res[]=new int[26];
      for(int i=0;i<n;i++){
        int j=s.charAt(i)-'a';
        res[j]+=a[i]+1;
      }
      for(int i=0;i<26;i++)
        System.out.print(res[i]+" ");
      System.out.println();
    }
  }
}
	