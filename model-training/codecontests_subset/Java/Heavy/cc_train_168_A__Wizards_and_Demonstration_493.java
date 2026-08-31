// package com.codeforces.wizardsanddemonstrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

   BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

   String line = null;

   PrintWriter out = new PrintWriter(System.out);

   StringTokenizer st;

   public String nextToken() throws IOException {
      if (line == null || !st.hasMoreElements()) {
         // line is finished
         if (s.ready()) {
            String line = s.readLine();
            st = new StringTokenizer(line, " ");
         }
      }

      if (st.hasMoreElements()) {
         return st.nextToken();
      }

      return null;
   }

   public int nextInt() throws IOException {
      return Integer.parseInt(nextToken());
   }

   public void execute() throws IOException {
      int n = nextInt();
      int x = nextInt();
      int y = nextInt();

      int wizardsNeeded = (int) Math.ceil(((double) y / 100) * (double) n);

      out.println(Math.max(wizardsNeeded - x, 0));
   }

   public void close() throws IOException {
      out.flush();
      out.close();
   }

   public static void main(String[] args) throws IOException {
      Main t = new Main();
      t.execute();
      t.close();
   }
}
