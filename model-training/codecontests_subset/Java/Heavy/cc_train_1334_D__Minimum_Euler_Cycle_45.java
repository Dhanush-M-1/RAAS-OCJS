import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rustam Musin (t.me/musin_acm)
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    OutputWriter out = new OutputWriter(outputStream);
    DMinimalniiEilerovTsikl solver = new DMinimalniiEilerovTsikl();
    solver.solve(1, in, out);
    out.close();
  }

  static class DMinimalniiEilerovTsikl {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
      int t = in.readInt();
      while (t-- > 0) {
        int n = in.readInt();
        long l = in.readLong();
        long r = in.readLong();
        List<Integer> answer = solve(n, l, r);
        for (int x : answer) out.print(x + 1 + " ");
        out.printLine();
      }
    }

    List<Integer> solve(int n, long l, long r) {
      long skip = l - 1;
      long len = r - l + 1;
      List<Integer> answer = new ArrayList<>();
      for (int i = 0; i + 1 < n; i++) {
        IntLongPair cur = IntLongPair.makePair(i, 2 * n - (i + 1) * 2);
        if (skip >= cur.second) {
          skip -= cur.second;
          continue;
        }
        Queue<Integer> curList = new ArrayDeque<>();
        for (int j = cur.first + 1; j < n; j++) {
          curList.add(cur.first);
          curList.add(j);
        }
        while (skip > 0) {
          skip--;
          curList.poll();
        }
        while (len > 0 && !curList.isEmpty()) {
          answer.add(curList.poll());
          len--;
        }
        if (len == 0) break;
      }
      if (len == 1) answer.add(0);
      return answer;
    }

  }

  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (numChars == -1) {
        throw new InputMismatchException();
      }
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0) {
          return -1;
        }
      }
      return buf[curChar++];
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9') {
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public long readLong() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9') {
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public boolean isSpaceChar(int c) {
      if (filter != null) {
        return filter.isSpaceChar(c);
      }
      return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);

    }

  }

  static class IntLongPair implements Comparable<IntLongPair> {
    public final int first;
    public final long second;

    public static IntLongPair makePair(int first, long second) {
      return new IntLongPair(first, second);
    }

    public IntLongPair(int first, long second) {
      this.first = first;
      this.second = second;
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      IntLongPair pair = (IntLongPair) o;

      return first == pair.first && second == pair.second;
    }

    public int hashCode() {
      int result = Integer.hashCode(first);
      result = 31 * result + Long.hashCode(second);
      return result;
    }

    public String toString() {
      return "(" + first + "," + second + ")";
    }

    public int compareTo(IntLongPair o) {
      int value = Integer.compare(first, o.first);
      if (value != 0) {
        return value;
      }
      return Long.compare(second, o.second);
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
        if (i != 0) {
          writer.print(' ');
        }
        writer.print(objects[i]);
      }
    }

    public void printLine() {
      writer.println();
    }

    public void close() {
      writer.close();
    }

  }
}

