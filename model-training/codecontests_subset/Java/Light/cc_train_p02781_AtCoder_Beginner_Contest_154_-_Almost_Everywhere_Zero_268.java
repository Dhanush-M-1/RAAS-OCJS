import java.io.*;
import java.util.*;

class Solver {
  final char[] cs;
  final int k;
  
  private long[][][] cache;
  
  Solver(char[] cs, int k) {
    this.cs = cs;
    this.k = k;
  }
  
  private long solve(int digitIndex, boolean possibleExceed, int restPositiveNumber) {
    if (restPositiveNumber == 0) {
//    System.err.printf("%d %s %d %d\n", digitIndex, possibleExceed, restPositiveNumber, 1);
      return 1;
    }
    if (digitIndex < 0 && restPositiveNumber > 0) {
//    System.err.printf("%d %s %d %d\n", digitIndex, possibleExceed, restPositiveNumber, 0);
      return 0;
    }
    if (cache[digitIndex][possibleExceed ? 1 : 0][restPositiveNumber] >= 0) {
//    System.err.printf("%d %s %d %d\n", digitIndex, possibleExceed, restPositiveNumber, cache[digitIndex][possibleExceed ? 1 : 0][restPositiveNumber]);
      return cache[digitIndex][possibleExceed ? 1 : 0][restPositiveNumber];
    }
    long v = 0;
//    long v = solve(digitIndex - 1, false, restPositiveNumber);
    int limit = possibleExceed ? (cs[cs.length - digitIndex - 1] - '0') : 9;
    for (int i = 0; i <= limit; i++) {
//    System.err.printf("%d %s %d i: %d\n", digitIndex, possibleExceed, restPositiveNumber, i);
      v += solve(digitIndex - 1, possibleExceed && i == limit, restPositiveNumber - (i == 0 ? 0 : 1));
    }
    cache[digitIndex][possibleExceed ? 1 : 0][restPositiveNumber] = v;
//    System.err.printf("%d %s %d %d\n", digitIndex, possibleExceed, restPositiveNumber, v);
    return cache[digitIndex][possibleExceed ? 1 : 0][restPositiveNumber];
  }
  
  public long solve() {
    cache = new long[cs.length][2][k + 1];
    for (long[][] v1 : cache) {
      for (long[] v2 : v1) {
        Arrays.fill(v2, -1);
      }
    }
    return solve(cs.length - 1, true, k);
  }
}

public class Main {
  private static void execute(ContestReader reader, PrintWriter out) {
    char[] cs = reader.nextCharArray();
    int k = reader.nextInt();
    out.println(new Solver(cs, k).solve());
  }
  
  public static void main(String[] args) {
    ContestReader reader = new ContestReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    execute(reader, out);
    out.flush();
  }
}

class ContestReader {
  private BufferedReader reader;
  private StringTokenizer tokenizer;
  
  ContestReader(InputStream in) {
    reader = new BufferedReader(new InputStreamReader(in));
  }
  
  public String next() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      try {
        tokenizer = new java.util.StringTokenizer(reader.readLine());
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
  
  public double nextDouble() {
    return Double.parseDouble(next());
  }
  
  public String[] next(int n) {
    String[] array = new String[n];
    for (int i = 0; i < n; i++) {
      array[i] = next();
    }
    return array;
  }
  
  public int[] nextInt(int n) {
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextInt();
    }
    return array;
  }
  
  public long[] nextLong(int n) {
    long[] array = new long[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextLong();
    }
    return array;
  }
  
  public double[] nextDouble(int n) {
    double[] array = new double[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextDouble();
    }
    return array;
  }
  
  public char[] nextCharArray() {
    return next().toCharArray();
  }
  
  public int[][] nextInt(int n, int m) {
    int[][] matrix = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = nextInt();
      }
    }
    return matrix;
  }
  
  public long[][] nextLong(int n, int m) {
    long[][] matrix = new long[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = nextLong();
      }
    }
    return matrix;
  }
  
  public double[][] nextDouble(int n, int m) {
    double[][] matrix = new double[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = nextDouble();
      }
    }
    return matrix;
  }
  
  public char[][] nextCharArray(int n) {
    char[][] matrix = new char[n][];
    for (int i = 0; i < n; i++) {
      matrix[i] = next().toCharArray();
    }
    return matrix;
  }
}
