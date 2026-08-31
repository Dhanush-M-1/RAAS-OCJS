//                I know stuff but probably my rating tells otherwise...

//                  Love is no stone, it's soft... more like snow
//                        beautifying everything it covers
//                        And when it falls... you listen

//               Kya hua, code samajhne ki koshish kar rhe ho?? Mat karo,
//                      mujhe bhi samajh nhi aata kya likha hai


import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class _455C {

      static data[] dsu;

      static void Mangni_ke_bail_ke_dant_na_dekhal_jye() {

            n = ni();
            m = ni();
            t = ni();
            init();
            dsu = new data[n + 1];

            for (int i = 1; i <= n; i++) {
                  dsu[i] = new data(i, 0);
            }

            for (int i = 1; i <= m; i++) {
                  int x = ni(), y = ni();
                  adj[x].add(y);
                  adj[y].add(x);
            }

            for(int i = 1;i <= n; i++) {
                  if (!vis1[i]) {
                        //Arrays.fill(vis, false);
                        level = -1;
                        node = -1;
                        k = 0;
                        dfs(i, 0, i, -1);
                        size[node] = k;
                        //Arrays.fill(vis, false);
                        int temp = node;
                        dfs(node, 0, node, -1);
                        dsu[temp].len = level;
                  }
            }

            //pl(Arrays.toString(dsu));


            while (t-- > 0) {
                  if (ni() == 2) union(ni(), ni());
                  else pl(findlength(ni()));
                  //pl(Arrays.toString(dsu));
            }

      }

      static LinkedList<Integer> adj[] = new LinkedList[300005];
      static boolean vis1[] = new boolean[300005], vis[];
      static int size[] = new int[300005];

      static void init() {
//            adj = new LinkedList[n + 1];
////            vis = new boolean[n + 1];
//            vis1 = new boolean[n + 1];
//            size = new int[n + 1];
            for (int i = 0; i < n + 1; i++) adj[i] = new LinkedList<>();
      }

      static int level, node;
      int count = 0;
      static void dfs(int x, int lev, int baap, int p) {
            //vis[x] = true;
            vis1[x] = true;
            k++;
            if (lev > level) {
                  level = lev;
                  node = x;
            }

            dsu[x].baap = baap;
            for (int i : adj[x]) if (i != p) dfs(i, lev + 1, baap, x);
      }

      static int findlength(int x) {
            return dsu[find_father(x)].len;
      }

      static void union(int x, int y){
            x = find_father(x);
            y = find_father(y);

            if(x == y)return;
            if(size[y] > size[x]) {
                  int temp = x;
                  x = y;
                  y = temp;
            }
            size[x] += size[y];
            dsu[y].baap = x;

            int x_len = dsu[x].len;
            int y_len = dsu[y].len;
            int tot_len = 0;

            x_len = (x_len + 1) >> 1;
            y_len = (y_len + 1) >> 1;
            tot_len = x_len + y_len + 1;

            dsu[x].len = max(dsu[x].len, max(dsu[y].len, tot_len));
       }

      static int find_father(int x) {
            return dsu[x].baap == x ? x : (dsu[x].baap = find_father(dsu[x].baap));
      }

//      static int find_father(int x){
//            while(dsu[x].baap != x) x = dsu[x].baap;
//            return x;
//      }

      static class data{
            int baap, len;
            data(int a, int b){
                  baap = a;
                  len = b;
            }
            public String toString(){
                  return "{"+baap+", "+len+"}";
            }
      }


      //----------------------------------------The main code ends here------------------------------------------------------
      /*-------------------------------------------------------------------------------------------------------------------*/
      //-----------------------------------------Rest's all dust-------------------------------------------------------------


      static int mod9 = 1_000_000_007;
      static int n, m, l, k, t;
      static AwesomeInput input;
      static PrintWriter pw;

      static long power(long a, long b) {
            long x = max(a, b);
            if (b == 0) return 1;
            if ((b & 1) == 1) return a * power(a * a, b >> 1);
            return power(a * a, b >> 1);
      }

      static long modpow(long a, long b, long m) {
            if (b == 0) return 1;

            if ((b & 1) == 1) return a * modpow(a * a % m, b >> 1, m) % m;
            return modpow(a * a % m, b >> 1, m) % m;
      }

      // The Awesome Input Code is a fast IO method //
      static class AwesomeInput {
            private InputStream letsDoIT;
            private byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;
            private SpaceCharFilter filter;

            private AwesomeInput(InputStream incoming) {
                  this.letsDoIT = incoming;
            }

            public int read() {
                  if (numChars == -1)
                        throw new InputMismatchException();
                  if (curChar >= numChars) {
                        curChar = 0;
                        try {
                              numChars = letsDoIT.read(buf);
                        } catch (IOException e) {
                              throw new InputMismatchException();
                        }
                        if (numChars <= 0)
                              return -1;
                  }
                  return buf[curChar++];
            }

            private long ForLong() {
                  int c = read();
                  while (isSpaceChar(c))
                        c = read();
                  int sgn = 1;
                  if (c == '-') {
                        sgn = -1;
                        c = read();
                  }
                  long res = 0;
                  do {
                        if (c < '0' || c > '9')
                              throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = read();
                  }
                  while (!isSpaceChar(c));
                  return res * sgn;
            }

            private String ForString() {
                  int c = read();
                  while (isSpaceChar(c))
                        c = read();
                  StringBuilder res = new StringBuilder();
                  do {
                        res.appendCodePoint(c);
                        c = read();
                  }
                  while (!isSpaceChar(c));

                  return res.toString();
            }

            public boolean isSpaceChar(int c) {
                  if (filter != null)
                        return filter.isSpaceChar(c);
                  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

            public interface SpaceCharFilter {
                  boolean isSpaceChar(int ch);
            }
      }

      // functions to take input//
      static int ni() {
            return (int) input.ForLong();
      }

      static String ns() {
            return input.ForString();
      }

      static long nl() {
            return input.ForLong();
      }

      //functions to give output
      static void pl() {
            pw.println();
      }

      static void p(Object o) {
            pw.print(o + " ");
      }

      static void pws(Object o) {
            pw.print(o + "");
      }

      static void pl(Object o) {
            pw.println(o);
      }

      // Fast Sort is Radix Sort
      public static int[] fastSort(int[] f) {
            int n = f.length;
            int[] to = new int[n];
            {
                  int[] b = new int[65537];
                  for (int i = 0; i < n; i++) b[1 + (f[i] & 0xffff)]++;
                  for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
                  for (int i = 0; i < n; i++) to[b[f[i] & 0xffff]++] = f[i];
                  int[] d = f;
                  f = to;
                  to = d;
            }
            {
                  int[] b = new int[65537];
                  for (int i = 0; i < n; i++) b[1 + (f[i] >>> 16)]++;
                  for (int i = 1; i <= 65536; i++) b[i] += b[i - 1];
                  for (int i = 0; i < n; i++) to[b[f[i] >>> 16]++] = f[i];
                  int[] d = f;
                  f = to;
                  to = d;
            }
            return f;
      }

      public static void main(String[] args) {      //threading has been used to increase the stack size.
            try {
                  input = new AwesomeInput(System.in);
                  pw = new PrintWriter(System.out, true);
                  input = new AwesomeInput(new FileInputStream("/home/saurabh/Desktop/input.txt"));
                  pw = new PrintWriter(new BufferedWriter(new FileWriter("/home/saurabh/Desktop/output.txt")), true);

            } catch (Exception e) {
            }

            new Thread(null, null, "AApan_gand_hawai_dusar_ke_kare_dawai", 1 << 28)  //the last parameter is stack size desired.
            {
                  public void run() {
                        try {
                              double s = System.currentTimeMillis();
                              Mangni_ke_bail_ke_dant_na_dekhal_jye();
                              //System.out.println(("\nExecution Time : " + ((double) System.currentTimeMillis() - s) / 1000) + " s");
                              pw.flush();
                              pw.close();
                        } catch (Exception e) {
                              e.printStackTrace();
                              System.exit(1);
                        }
                  }
            }.start();
      }
}