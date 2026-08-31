import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jialin Ouyang (Jialin.Ouyang@gmail.com)
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    QuickScanner in = new QuickScanner(inputStream);
    QuickWriter out = new QuickWriter(outputStream);
    TaskE solver = new TaskE();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskE {
    static int MAXN = 1 << 10;
    static double EPS = 1E-6;
    int n;
    int m;
    int r;
    int c;
    char[][] table;
    char[][] pattern;
    Complex[][] a = new Complex[MAXN][MAXN];
    Complex[][] b = new Complex[MAXN][MAXN];

    public void solve(int testNumber, QuickScanner in, QuickWriter out) {
      for (int i = 0; i < MAXN; ++i)
        for (int j = 0; j < MAXN; ++j) {
          a[i][j] = Complex.zero();
          b[i][j] = Complex.zero();
        }
      n = in.nextInt();
      m = in.nextInt();
      table = new char[n][m];
      for (int i = 0; i < n; ++i) {
        in.next(table[i]);
      }
      r = in.nextInt();
      c = in.nextInt();
      init(a, table, n + r - 1, m + c - 1, false);
      pattern = new char[r][c];
      int cnt = 0;
      for (int i = 0, j = r - 1; i < r; ++i, --j) {
        in.next(pattern[j]);
        CharArrayUtils.reverse(pattern[j]);
        for (int k = 0; k < c; ++k)
          if (pattern[j][k] != '?') {
            ++cnt;
          }
      }
      init(b, pattern, r, c, true);
      new FastFourierTransformer().mul(MAXN, a, b, a);
      for (int i = 0, x = r - 1; i < n; ++i, ++x) {
        for (int j = 0, y = c - 1; j < m; ++j, ++y) {
          out.print(a[x][y].real + EPS > cnt ? '1' : '0');
        }
        out.println();
      }
    }

    void init(Complex[][] a, char[][] table, int n, int m, boolean negative) {
      for (int i = 0, x = 0; i < n; ++i, x = x + 1 == table.length ? 0 : x + 1) {
        for (int j = 0, y = 0; j < m; ++j, y = y + 1 == table[0].length ? 0 : y + 1) {
          initComplex(a[i][j], table[x][y], negative);
        }
      }
    }

    void initComplex(Complex complex, char x, boolean negative) {
      if (x == '?') {
        complex.initZero();
      } else {
        double angle = (negative ? -1 : 1) * Math.PI / 13 * (x - 'a');
        complex.initPolar(1, angle);
      }
    }

  }

  static class Complex {
    public double real;
    public double imag;

    public Complex(double real, double imag) {
      this.real = real;
      this.imag = imag;
    }

    public static Complex zero() {
      return new Complex(0, 0);
    }

    public static Complex polar(double r, double angle) {
      return new Complex(r * Math.cos(angle), r * Math.sin(angle));
    }

    public static Complex mul(Complex a, Complex b) {
      return new Complex(a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real);
    }

    public void initZero() {
      this.real = 0;
      this.imag = 0;
    }

    public void initPolar(double r, double angle) {
      real = r * Math.cos(angle);
      imag = r * Math.sin(angle);
    }

    public void initSub(Complex a, Complex b) {
      assign(a.real - b.real, a.imag - b.imag);
    }

    public void initMul(Complex a, Complex b) {
      assign(a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real);
    }

    public void add(Complex o) {
      assign(real + o.real, imag + o.imag);
    }

    public void shrink(double scale) {
      assign(real / scale, imag / scale);
    }


    public String toString() {
      return String.format(imag < 0 ? "%f%fi" : "%f+%fi", real, imag);
    }

    private void assign(double real, double imag) {
      this.real = real;
      this.imag = imag;
    }

  }

  static class FastFourierTransformer {
    private Complex wBase;
    private Complex u;
    private Complex v;
    private Complex[] w;

    public FastFourierTransformer() {
      wBase = Complex.zero();
      u = Complex.zero();
      v = Complex.zero();
    }

    public void fft(int n, Complex[] a, boolean invert) {
      if (Integer.bitCount(n) != 1) {
        throw new IllegalArgumentException(n + " should be pow of 2.");
      }
      ensureCapacity(n);
      for (int i = 1, j = 0; i < n; ++i) {
        int bit = n >> 1;
        for (; j >= bit; bit >>= 1) {
          j -= bit;
        }
        j += bit;
        if (i < j) {
          Complex tmp = a[i];
          a[i] = a[j];
          a[j] = tmp;
        }
      }
//    for (int len = 2; len <= n; len <<= 1) {
//      int len2 = len >> 1;
//      wBase.initPolar(1, angle);
//      w[0].init(1, 0);
//      for (int i = 1; i < len2; ++i) {
//        w[i].initMul(w[i - 1], wBase);
//      }
//      for (int i = 0; i < n; i += len) {
//        for (int j = 0, pntU = i, pntV = i + len2; j < len2; ++j, ++pntU, ++pntV) {
//          u.init(a[pntU]);
//          v.initMul(a[pntV], w[j]);
//          a[pntU].initAdd(u, v);
//          a[pntV].initSub(u, v);
//        }
//      }
//    }
      for (int l = 1; l < n; l <<= 1) {
        int l2 = l << 1, step = n / l2;
        for (int i = 0; i < n; i += l2) {
          for (int j = 0, wIdx = invert ? n : 0; j < l; ++j, wIdx += invert ? -step : step) {
            u.initMul(a[i + j + l], w[wIdx]);
            a[i + j + l].initSub(a[i + j], u);
            a[i + j].add(u);
          }
        }
      }
      if (invert) {
        for (int i = 0; i < n; ++i) {
          a[i].shrink(n);
        }
      }
    }

    public void fft(int n, Complex[][] a, boolean invert) {
      for (int i = 0; i < n; ++i) {
        fft(n, a[i], invert);
      }
      for (int i = 0; i < n; ++i)
        for (int j = i + 1; j < n; ++j) {
          Complex tmp = a[i][j];
          a[i][j] = a[j][i];
          a[j][i] = tmp;
        }
      for (int i = 0; i < n; ++i) {
        fft(n, a[i], invert);
      }
    }

    public void mul(int n, Complex[][] a, Complex[][] b, Complex[][] res) {
      fft(n, a, false);
      fft(n, b, false);
      for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j) {
          res[i][j].initMul(a[i][j], b[i][j]);
        }
      fft(n, res, true);
    }

    private void ensureCapacity(int n) {
      if (w != null && w.length > n) return;
      w = new Complex[n + 1];
      wBase = Complex.polar(1, 2 * Math.PI / n);
      w[0] = new Complex(1, 0);
      for (int i = 1; i <= n; ++i) {
        w[i] = Complex.mul(w[i - 1], wBase);
      }
    }

  }

  static class QuickWriter {
    private final PrintWriter writer;

    public QuickWriter(OutputStream outputStream) {
      this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public QuickWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; ++i) {
        if (i > 0) {
          writer.print(' ');
        }
        writer.print(objects[i]);
      }
    }

    public void println(Object... objects) {
      print(objects);
      writer.print('\n');
    }

    public void close() {
      writer.close();
    }

  }

  static class QuickScanner {
    private static final int BUFFER_SIZE = 1024;
    private InputStream stream;
    private byte[] buffer;
    private int currentPosition;
    private int numberOfChars;

    public QuickScanner(InputStream stream) {
      this.stream = stream;
      this.buffer = new byte[BUFFER_SIZE];
      this.currentPosition = 0;
      this.numberOfChars = 0;
    }

    public int next(char[] s) {
      return next(s, 0);
    }

    public int next(char[] s, int startIdx) {
      int b = nextNonSpaceChar();
      int res = 0;
      do {
        s[startIdx++] = (char) b;
        b = nextChar();
        ++res;
      } while (!isSpaceChar(b));
      return res;
    }

    public int nextInt() {
      int c = nextNonSpaceChar();
      boolean positive = true;
      if (c == '-') {
        positive = false;
        c = nextChar();
      }
      int res = 0;
      do {
        if (c < '0' || '9' < c) throw new RuntimeException();
        res = res * 10 + c - '0';
        c = nextChar();
      } while (!isSpaceChar(c));
      return positive ? res : -res;
    }

    public int nextNonSpaceChar() {
      int res = nextChar();
      for (; isSpaceChar(res) || res < 0; res = nextChar()) ;
      return res;
    }

    public int nextChar() {
      if (numberOfChars == -1) {
        throw new RuntimeException();
      }
      if (currentPosition >= numberOfChars) {
        currentPosition = 0;
        try {
          numberOfChars = stream.read(buffer);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
        if (numberOfChars <= 0) {
          return -1;
        }
      }
      return buffer[currentPosition++];
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\t' || isEndOfLineChar(c);
    }

    public boolean isEndOfLineChar(int c) {
      return c == '\n' || c == '\r' || c < 0;
    }

  }

  static class CharArrayUtils {
    public static void reverse(char[] values) {
      reverse(values, 0, values.length);
    }

    public static void reverse(char[] values, int fromIdx, int toIdx) {
      for (int i = fromIdx, j = toIdx - 1; i < j; ++i, --j) {
        values[i] ^= values[j];
        values[j] ^= values[i];
        values[i] ^= values[j];
      }
    }

  }
}

