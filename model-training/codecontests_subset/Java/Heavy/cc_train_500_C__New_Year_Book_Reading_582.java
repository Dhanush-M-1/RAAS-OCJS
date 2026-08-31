import java.lang.*;
import java.util.*;
import java.io.*;

public class Template {

  public static void main(String[] args) throws Exception {
    InputReader reader = new InputReader(System.in);
    PrintWriter writer = new PrintWriter(System.out, true);
    try {
      new Solution(reader, writer).run();
    } finally {
      reader.close();
      writer.close();
    }
  }
}


class Solution {
  private InputReader reader;
  private PrintWriter writer;

  Solution(InputReader reader, PrintWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public void run() throws Exception {
    int n = reader.nextInt();
    int m = reader.nextInt();

    int[] ws = new int[n];
    for (int i=0; i < n; i++) {
      ws[i] = reader.nextInt();
    }

    int[] bs = new int[m];
    long[] sums = new long[m];
    for (int i=0; i < m; i++) {
      bs[i] = reader.nextInt();
      //;sums[i] = (0 != i ? sums[i-1] : 0) + ws[bs[i] - 1];
    }
    long result = 0;
    for (int j = m -1; j >=0; j--) {
      Set<Integer> visited = new TreeSet<Integer>();
      for (int k = j - 1; k>=0; k--) {
        if (bs[k] == bs[j]) break;
        if (!visited.contains(bs[k])) {
          visited.add(bs[k]);
          result += ws[bs[k] -1];

        }
      }
    }
    writer.println(result);
  }
}

class InputReader {
  private BufferedReader reader;
  private StringTokenizer tokenizer;

  InputReader(InputStream inputStream) {
    this.reader = new BufferedReader(new InputStreamReader(inputStream));
  }

  protected String nextToken() throws Exception {
    while (null == tokenizer || !tokenizer.hasMoreTokens()) {
      this.tokenizer = new StringTokenizer(reader.readLine());
    }
    return tokenizer.nextToken();
  }

  public int nextInt() throws Exception {
    return Integer.parseInt(nextToken());
  }

  public int read() throws Exception {
    int ch = reader.read();
    while (Character.isWhitespace(ch)) {
      ch = reader.read();
    }
    return ch;
  }
  public void close() throws Exception {
    reader.close();
  }
}
