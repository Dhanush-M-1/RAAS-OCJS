import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
  Road to blue
 */
public class Main implements Runnable {
  BufferedReader in;
  PrintWriter out;
  StringTokenizer tok = new StringTokenizer("");

  @Override
  public void run() {
    init();
    long time = System.currentTimeMillis();
    solve();
    out.close();
    System.err.println(System.currentTimeMillis() - time);
  }

  private void init() {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
  }

  public static void main(String[] args) {
    new Thread(new Main()).start();
  }

  private String readString() {
    while (!tok.hasMoreTokens()) {
      try {
        tok = new StringTokenizer(in.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return tok.nextToken();
  }

  private int readInt() {
    return Integer.parseInt(readString());
  }

  private double readDouble() {
    return Double.parseDouble(readString());
  }

  private long readLong() {
    return Long.parseLong(readString());
  }

  private void solve() {
    String s1 = readString();
    String s2 = readString();
    int n = readInt();
    out.println(s1+" "+s2);
    while(n-->0) {
      String killed = readString();
      String added = readString();
      if(killed.equals(s1)) {
        s1 = added;
      } else {
        s2 = added;
      }
      out.println(s1+" "+s2);
    }
  }
}