import java.io.*;
import java.util.*;

class Solver {
  final int n, k, q;
  final int[] as;
  
  Solver(int n, int k, int q, int[] as) {
    this.n = n;
    this.k = k;
    this.q = q;
    this.as = as;
  }
  
  private int solve(int aThreshold) {
    PriorityQueue<PriorityQueue<Integer>> queueQueue = new PriorityQueue<PriorityQueue<Integer>>(
      new Comparator<PriorityQueue<Integer>>() {
        public int compare(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2) {
          return q1.peek() - q2.peek();
        }
      }
    );
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int a : as) {
      if (a < aThreshold) {
        if (queue.size() >= k) {
          queueQueue.add(queue);
        }
        queue = new PriorityQueue<>();
      } else {
        queue.add(a);
      }
    }
    if (queue.size() >= k) {
      queueQueue.add(queue);
    }
    
    int minValue = Integer.MAX_VALUE;
    int maxValue = 0;
    for (int i = 0; i < q; i++) {
      queue = queueQueue.poll();
      if (queue == null) {
        return Integer.MAX_VALUE;
      }
      int v = queue.poll();
      minValue = Math.min(minValue, v);
      maxValue = Math.max(maxValue, v);
      if (queue.size() >= k) {
        queueQueue.add(queue);
      }
    }
    return maxValue - minValue;
  }
  
  public int solve() {
    int answer = Integer.MAX_VALUE;
    for (int a : as) {
      answer = Math.min(answer, solve(a));
    }
    return answer;
  }
}

public class Main {
  private static void execute(ContestReader reader, PrintWriter out) {
    int n = reader.nextInt();
    int k = reader.nextInt();
    int q = reader.nextInt();
    int[] as = reader.nextInt(n);
    out.println(new Solver(n, k, q, as).solve());
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
