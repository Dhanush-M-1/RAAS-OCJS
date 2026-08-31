import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Gil Vegliach
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    OutputWriter out = new OutputWriter(outputStream);
    TaskA solver = new TaskA();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
      int n = in.nextInt();
      int sum = 0;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        int a = in.nextInt();
        max = Math.max(max, a);
        sum += a;
      }
      int k = (2 * sum) / n + 1;
      out.println(Math.max(k, max));
    }

  }

  static class InputReader {
    private InputStream is;
    private byte[] buff = new byte[8 * 1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream is) {
      this.is = is;
    }

    public int read() {
      if (numChars == -1) throw new InputMismatchException();
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = is.read(buff);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0) return -1;
      }
      return buff[curChar++];
    }

    public int nextInt() {
      int c = read();
      while (isSpaceChar(c)) c = read();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

  }

  static class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
      writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; i++) {
        if (i != 0) writer.print(' ');
        writer.print(objects[i]);
      }
    }

    public void println(Object... objects) {
      print(objects);
      writer.println();
    }

    public void close() {
      writer.close();
    }

  }
}

