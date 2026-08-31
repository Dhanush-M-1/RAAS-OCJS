import java.util.*;
import java.io.*;

public class Q_385A {
   public static PrintWriter out; // -----------PrintWriter for faster output--------------
   public static class MyScanner { // -----------MyScanner class for faster input----------
      BufferedReader br;
      StringTokenizer st;
      public MyScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
      String next() { while (st == null || !st.hasMoreElements()) {try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); }} return st.nextToken();}
      int nextInt() { return Integer.parseInt(next()); }
      long nextLong() { return Long.parseLong(next()); }
      double nextDouble() { return Double.parseDouble(next()); }
      String nextLine(){ String str = "";try {str = br.readLine();} catch (IOException e) {e.printStackTrace();}return str; }
      int[] reada(int n) { int[] input = new int[n]; for (int i = 0; i < n; i++) input[i] = nextInt(); return input; }
      Map<Integer, Integer> readmap(Map<Integer, Integer> map,int n){for(int i=0;i<n;i++){ int a = nextInt(); if(!map.containsKey(a)) map.put(a, 1); else map.put(a, map.get(a)+1); } return map;}
      Map<String, Integer> readmaps(Map<String, Integer> map,int n){for(int i=0;i<n;i++){ String a = nextLine(); if(!map.containsKey(a)) map.put(a, 1); else map.put(a, map.get(a)+1); } return map;}
    }
   public static void printa(int[] a) { for (int i = 0; i < a.length; i++)out.print(a[i] + " "); }
   public static void printm(Map<Integer, Integer> map){map.forEach((k, v) -> System.out.println(k + " : " + v ));}
   public static void printmi(Map<String, Integer> map){map.forEach((k, v) -> System.out.println(k + " : " + v ));}
   public static boolean e(long n) { if (n % 2 == 0) return true; return false; }
   public static boolean sq(long n) { double sq = Math.sqrt(n);if (sq == (int) sq) return true; return false; }
   public static int[][] sort2d(int[][] a) { Arrays.sort(a, Comparator.comparingInt(o -> o[0])); return a; }
   public static boolean rem(long a,long b, long c){ if(a%b == c) return true; return false; }
   // ------------------------------------------------------------------------------------------------------------------------------

// we can create our function here...just above the main function

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n =sc.nextInt();
        int c = sc.nextInt();

        int x[] = sc.reada(n);

        int max = 0;
        for(int i=0;i<n-1;i++) if(x[i]-x[i+1]-c > max) max = x[i] - x[i+1] -c;

        out.println(max);
        
// do not change the code written below ---------------------------------------------------------------------------------
    out.close();
   }
}