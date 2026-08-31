import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author dauom
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    CKingsPath solver = new CKingsPath();
    solver.solve(1, in, out);
    out.close();
  }

  static class CKingsPath {
    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      int x0 = in.nextInt();
      int y0 = in.nextInt();
      int x1 = in.nextInt();
      int y1 = in.nextInt();
      int n = in.nextInt();
      HashSet<Long> allowed = new HashSet<>();
      while (n-- > 0) {
        int r = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        while (b >= a) {
          allowed.add(hash(r, b--));
        }
      }

      ArrayDeque<int[]> queue = new ArrayDeque<>();
      queue.add(new int[] {x0, y0, 0});
      while (!queue.isEmpty()) {
        int x = queue.peek()[0];
        int y = queue.peek()[1];
        int d = queue.poll()[2];
        for (int dx = -1; dx <= 1; dx++) {
          for (int dy = -1; dy <= 1; dy++) {
            if (dx != 0 || dy != 0) {
              int nx = x + dx;
              int ny = y + dy;
              if (allowed.remove(hash(nx, ny))) {
                if (nx == x1 && ny == y1) {
                  out.println(d + 1);
                  return;
                }
                queue.add(new int[] {nx, ny, d + 1});
              }
            }
          }
        }
      }
      out.println(-1);
    }

    private final long hash(int a, int b) {
      return ((long) a) << 32 | b;
    }
  }

  static final class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[1 << 16];
    private int curChar;
    private int numChars;

    public InputReader() {
      this.stream = System.in;
    }

    public InputReader(final InputStream stream) {
      this.stream = stream;
    }

    private final int read() {
      if (this.numChars == -1) {
        throw new UnknownError();
      } else {
        if (this.curChar >= this.numChars) {
          this.curChar = 0;

          try {
            this.numChars = this.stream.read(this.buf);
          } catch (IOException ex) {
            throw new InputMismatchException();
          }

          if (this.numChars <= 0) {
            return -1;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public final int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {}

      byte sgn = 1;
      if (c == 45) { // 45 == '-'
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) { // 48 == '0', 57 == '9'
        res *= 10;
        res += c - 48; // 48 == '0'
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    private static final boolean isSpaceChar(final int c) {
      return c == 32 || c == 10 || c == 13 || c == 9
          || c == -1; // 32 == ' ', 10 == '\n', 13 == '\r', 9 == '\t'
    }
  }
}
