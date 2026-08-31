import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C {
  FastScanner in;
  PrintWriter out;

  public void run() {
    try {
      in = new FastScanner(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      solve();
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] arg) {
    C o = new C();
    o.run();
  }

  public void solve() throws IOException {
    long q = Long.valueOf(in.nextLine());
    if (q == 1 || q == 2) { // simplest number. First wins immediately.
      out.println(1);
      out.println(0);
      return;
    }
    int z = 1000001;
    boolean [] seed = new boolean[z];
    for (int i=0; i<z; i++) {
      seed[i] = true;
    }
    for (int i=2; i<z; i++) {
      if (seed[i]) {
        for (int j=2*i; j<z; j+=i) {
          seed[j] = false;
        }
      }
    }

    TreeSet<Long> divs = new TreeSet<Long>();
    for (long i=2; i*i <= q; i++) {
      if (q % i == 0) {
        divs.add(i);
        divs.add(q / i);
      }
    }
    if (divs.isEmpty()) {
      out.println(1);
      out.println(0);
      return;
    }
    while (!divs.isEmpty()) {
      long att = divs.pollFirst();
      for (int i = 2; i < z; i++) {
        if (att != i && att % i == 0 && seed[(int)(att / i)]) {
          out.println(1);
          out.println(att);
          return;
        }
      }
    }

    out.println(2);
  }

  class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(FileReader in) {
      br = new BufferedReader(in);
    }

    FastScanner(InputStreamReader in) {
      br = new BufferedReader(in);
    }

    String nextLine() {
      String str = null;
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }

      return str;
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
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
  }

}