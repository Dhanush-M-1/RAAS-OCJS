import java.util.*;
import java.io.*;
 
public class a {
  public static void main(String[] args) {
    InputReader in = new InputReader();
    in.init(System.in);

    Solver soal = new Solver();
    soal.solve(in);
  }
}

class Solver {
  private char[] s;
  private int N;
  private int[][] hs;
  
  public void solve(InputReader in) {
    N = in.nextInt();
    s = in.next().toCharArray();
    hs = new int[N][N];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        hs[i][j] = 0;
      }
    }
    for (int i = 1; i <= N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (s[j] == '.') continue;
        hs[i - 1][j] = (j < i ? 1 : hs[i - 1][j - i] + 1);
      }
    }
    boolean is = false;
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (hs[i][j] > 4) is = true;
      }
    }
    System.out.println(is ? "yes" : "no");
  }
}

class InputReader {
  private BufferedReader reader;
  private StringTokenizer tokenizer;

  public void init(InputStream input) {
    reader = new BufferedReader(
            new InputStreamReader(input), 
            32768);
    tokenizer = null;
  }

  public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new StringTokenizer(reader.readLine());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return tokenizer.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }
  
  public long nextLong() {
    return Long.parseLong(next());
  }
}



