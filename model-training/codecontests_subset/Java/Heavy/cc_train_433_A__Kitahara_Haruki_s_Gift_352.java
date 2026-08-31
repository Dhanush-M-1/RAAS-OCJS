import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

  public static void main(String[] args) {
    MyScanner in = new MyScanner();

    int n = in.nextInt();

    int one = 0;
    int two = 0;
    for (int i = 0; i < n; i++) {
      int val = in.nextInt();
      if (val == 100)
        one++;
      else
        two++;
    }

    int A = 200 * (two / 2);
    int B = 200 * (two / 2);

    if (two % 2 == 1)
      A += 200;

    while (one > 0) {
      if (A < B)
        A += 100;
      else
        B += 100;

      one--;
    }

    String res = A == B ? "YES" : "NO";
    System.out.println(res);

  }


  public static class Pair implements Comparable<Pair> {
    int x, y;


    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }


    @Override
    public int compareTo(Pair o) {
      return Integer.compare(this.x, o.x);
    }


    @Override
    public int hashCode() {
      return x ^ y;
    }


    @Override
    public boolean equals(Object o) {
      Pair p = (Pair) o;
      return p.x == x && p.y == y;
    }

  }


  // -----------MyScanner class for faster input----------
  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;


    public MyScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }


    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
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
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

  }
  // --------------------------------------------------------
}

 		  	  	 				 	   		 		  	