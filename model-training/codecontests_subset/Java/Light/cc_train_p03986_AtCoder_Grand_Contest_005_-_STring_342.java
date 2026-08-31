import java.io.*;
import java.util.*;

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
}

public class Main {
  private static int solve(char[] x) {
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (char c : x) {
      if (c == 'T' && !stack.isEmpty() && stack.peekLast() == 'S') {
        stack.pollLast();
      } else {
        stack.addLast(c);
      }
    }
    return stack.size();
  }
  
  private static void execute(ContestReader reader, PrintWriter out) {
    char[] x = reader.next().toCharArray();
    out.println(solve(x));
  }
  
  public static void main(String[] args) {
    ContestReader reader = new ContestReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    execute(reader, out);
    out.flush();
  }
}

