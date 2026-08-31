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
 * @author sumit
 */
public class Main {
      public static void main(String[] args) {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            OutputWriter out = new OutputWriter(outputStream);
            DMinimumEulerCycle solver = new DMinimumEulerCycle();
            solver.solve(1, in, out);
            out.close();
      }

      static class DMinimumEulerCycle {
            public void solve(int testNumber, InputReader in, OutputWriter out) {
                  int t = in.nextInt();
                  while (t-- > 0) {
                        int n = in.nextInt();
                        long l = in.nextLong();
                        long r = in.nextLong();
                        StringBuilder str = new StringBuilder();
                        long[] sum = new long[n];
                        sum[0] = 2 * (n - 1);
                        int mm = 2;
                        for (int i = 1; i < n; i++) {
                              int xx = n - mm;
                              sum[i] = sum[i - 1] + 2 * xx;
                              mm++;
                        }

                        while (l <= r) {
                              if (l == (1L * n * (n - 1) + 1)) {
                                    str.append("1 ");
                              } else {
                                    int start = 0;
                                    int end = n - 1;
                                    int ans = -1;
                                    while (start <= end) {
                                          int mid = (start + end) / 2;
                                          if (sum[mid] < l) {
                                                start = mid + 1;
                                          } else if (sum[mid] >= l) {
                                                ans = mid;
                                                end = mid - 1;
                                          }
                                    }

                                    long l1 = l;


                                    if (ans > 0)
                                          l = l - sum[ans - 1];

                                    String ss = "";
                                    if (l % 2 == 1) {
                                          ss = (1 + ans) + " ";
                                    } else {
                                          ss = (1 + ans + l / 2) + " ";
                                    }
                                    str.append(ss);

                                    l = l1;

                              }
                              l++;
                        }
                        out.printLine(str.toString());
                  }
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

            public void printLine(Object... objects) {
                  print(objects);
                  writer.println();
            }

            public void close() {
                  writer.close();
            }

      }

      static class InputReader {
            private InputStream stream;
            private byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;

            public InputReader(InputStream stream) {
                  this.stream = stream;
            }

            public int read() {
                  if (numChars == -1)
                        throw new InputMismatchException();

                  if (curChar >= numChars) {
                        curChar = 0;
                        try {
                              numChars = stream.read(buf);
                        } catch (IOException e) {
                              throw new InputMismatchException();
                        }
                        if (numChars <= 0)
                              return -1;
                  }

                  return buf[curChar++];
            }

            public int nextInt() {
                  int c = read();

                  while (isSpaceChar(c))
                        c = read();

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
                        res += c & 15;

                        c = read();
                  } while (!isSpaceChar(c));

                  return res * sgn;
            }

            public long nextLong() {
                  int c = read();

                  while (isSpaceChar(c))
                        c = read();

                  int sign = 1;

                  if (c == '-') {
                        sign = -1;

                        c = read();
                  }

                  long result = 0;

                  do {
                        if (c < '0' || c > '9')
                              throw new InputMismatchException();

                        result *= 10;
                        result += c & 15;

                        c = read();
                  } while (!isSpaceChar(c));

                  return result * sign;
            }

            public boolean isSpaceChar(int c) {
                  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

      }
}

