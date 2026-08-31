import java.io.*;
import java.util.*;

class LazySegmentTree {
  final int n;
  final int[] values;
  final int[] lazyValues;
  
  LazySegmentTree (int size) {
    int tempN = 1;
    while (tempN < size) {
      tempN *= 2;
    }
    n = tempN;
    values = new int[2 * n - 1];
    lazyValues = new int[2 * n - 1];
  }
  
  private void eval(int k, int l, int r) {
    if (lazyValues[k] != 0) {
      if (r - l > 1) {
        lazyValues[2 * k + 1] += lazyValues[k];
        lazyValues[2 * k + 2] += lazyValues[k];
      } else {
        values[k] += lazyValues[k];
      }
      lazyValues[k] = 0;
    }
  }
  
  private void add(int a, int b, int k, int l, int r) {
    eval(k, l, r);
    if (b <= l || r <= a) {
      return;
    }
    if (a <= l && r <= b) {
      lazyValues[k] += 1;
      eval(k, l, r);
      return;
    }
    add(a, b, 2 * k + 1, l, (l + r) / 2);
    add(a, b, 2 * k + 2, (l + r) / 2, r);
  }
  
  public void add(int a, int b) {
    add(a, b, 0, 0, n);
  }
  
  private int get(int a, int k, int l, int r) {
    if (a + 1 <= l || r <= a) {
      return 0;
    }
    eval(k, l, r);
    if (a <= l && r <= a + 1) {
      return values[k];
    }
    int vl = get(a, 2 * k + 1, l, (l + r) / 2);
    int vr = get(a, 2 * k + 2, (l + r) / 2, r);
    return vl + vr;
  }
  
  public int get(int a) {
    return get(a, 0, 0, n);
  }
}

class Range {
  final int l, r;
  Range(int l, int r) {
    this.l = l;
    this.r = r;
  }
}

class Solver {
  final int n, m;
  final int[][] lrs;
  
  Solver(int n, int m, int[][] lrs) {
    this.n = n;
    this.m = m;
    this.lrs = lrs;
  }
  
  List<Integer> solve() {
    List<List<Range>> rangeMatrix = new ArrayList<>();
    for (int i = 0; i <= m; i++) {
      rangeMatrix.add(new ArrayList<>());
    }
    for (int[] lr : lrs) {
      rangeMatrix.get(lr[1] - lr[0] + 1).add(new Range(lr[0], lr[1]));
    }
    
    LazySegmentTree lazySegmentTree = new LazySegmentTree(m + 2);
    List<Integer> answers = new ArrayList<>();
    int longEnoughCount = n;
    for (int d = 1; d <= m; d++) {
      for (Range range : rangeMatrix.get(d)) {
        lazySegmentTree.add(range.l, range.r + 1);
        longEnoughCount--;
      }
      int answer = longEnoughCount;
      for (int i = 1; d * i <= m; i++) {
        answer += lazySegmentTree.get(d * i);
      }
      answers.add(answer);
    }
    return answers;
  }
}

public class Main {
  private static void execute(ContestReader reader, PrintWriter out) {
    int n = reader.nextInt();
    int m = reader.nextInt();
    int[][] lrs = reader.nextInt(n, 2);
    for (int answer : new Solver(n, m, lrs).solve()) {
      out.println(answer);
    }
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
