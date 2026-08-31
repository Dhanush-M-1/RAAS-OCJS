//  package com.company.codeforces;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class Solution {
    static int dept[];
    static class Node{
        Node left;
        Node right;
        int val;
    }

    public static void main(String[] args) {
      Scanner input=new Scanner(System.in);
      int t=input.nextInt();
      while (t-->0) {
          int n = input.nextInt();
          int a[]=new int[n];
          dept=new int[n+1];
          for (int i = 0; i <n ; i++) {
              a[i]=input.nextInt();

          }
          Node root=con(a,0,n-1);
          dfs(root,0);
          for (int i = 0; i <n ; i++) {
              System.out.print(dept[a[i]]+" ");
          }
          System.out.println();

      }

}

    private static void dfs(Node root,int d) {
    if (root==null) return;
    dept[root.val]=d;
    dfs(root.left,d+1);
    dfs(root.right,d+1);
    }

    private static Node con(int[] a, int l, int r) {
    if (l<0 ||r<l||r==a.length) return null;
        int maxval = 0;
        int in = -1;
        for (int i = l; i <= r; i++) {
            if (a[i] > maxval) {
                maxval = a[i];
                in = i;
            }
        }
        Node curr = new Node();
        curr.val = a[in];
       curr.left=con(a,l,in-1);
       curr.right=con(a,in+1,r);
       return curr;
    }
}