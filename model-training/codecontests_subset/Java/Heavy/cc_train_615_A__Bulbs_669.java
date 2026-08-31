import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main implements Runnable {
  BufferedReader in;
  PrintWriter out;
  StringTokenizer tok = new StringTokenizer("");

  @Override
  public void run() {
    init();
    solve();
    out.close();
  }

  private void init() {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
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

  public static void main(String[] args) {
    new Thread(new Main()).run();
  }

  private long readLong() {
    return Long.parseLong(readString());
  }

  private void solve() {
    int n = readInt();
    int m = readInt();
    HashSet<Integer> can = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int t = readInt();
      while(t-->0) can.add(readInt());
    }
    out.print(can.size()==m?"YES":"NO");
  }




}
