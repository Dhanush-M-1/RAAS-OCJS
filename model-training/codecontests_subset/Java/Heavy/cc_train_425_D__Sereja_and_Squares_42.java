import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by hama_du on 2014/09/20.
 */
public class ProblemD {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[][] pt = new int[n][2];
        int[] xdeg = new int[100010];
        int[] ydeg = new int[100010];
        for (int i = 0 ; i < n ; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            pt[i][0] = x;
            pt[i][1] = y;
            xdeg[x]++;
            ydeg[y]++;
        }

        int[][] xv = new int[100010][];
        int[][] yv = new int[100010][];
        for (int i = 0 ; i < xv.length ; i++) {
            xv[i] = new int[xdeg[i]];
            yv[i] = new int[ydeg[i]];
        }
        for (int i = 0; i < n; i++) {
            int x = pt[i][0];
            int y = pt[i][1];
            xv[x][--xdeg[x]] = y;
            yv[y][--ydeg[y]] = x;
        }
        for (int i = 0 ; i < n ; i++) {
            Arrays.sort(xv[i]);
            Arrays.sort(yv[i]);
        }


        int ans = 0;
        for (int y = 0 ; y < yv.length ; y++) {
            if (yv[y].length >= 2) {
                for (int yi = 0 ; yi < yv[y].length ; yi++) {
                    int x = yv[y][yi];
                    if (xv[x].length >= 2) {
                        int yleft = yv[y].length - yi - 1;
                        int xi = Arrays.binarySearch(xv[x], y);
                        int xleft = xv[x].length - xi - 1;
                        if (xleft < yleft) {
                            for (int xii = xi+1 ; xii < xv[x].length ; xii++) {
                                int A = xv[x][xii] - y;
                                int ox = x + A;
                                int oy = y + A;
                                if (ox < xv.length && oy < yv.length &&
                                        Arrays.binarySearch(xv[ox], oy) >= 0 &&
                                        Arrays.binarySearch(yv[y], ox) >= 0) {
                                    ans++;
                                }
                            }
                        } else {
                            for (int yii = yi+1 ; yii < yv[y].length ; yii++) {
                                int A = yv[y][yii] - x;
                                int ox = x + A;
                                int oy = y + A;
                                if (ox < xv.length && oy < yv.length &&
                                        Arrays.binarySearch(xv[ox], oy) >= 0 &&
                                        Arrays.binarySearch(xv[x], oy) >= 0) {
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println(ans);
        out.flush();
    }

    public static void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
              this.stream = stream;
        }

        public int next() {
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
              int c = next();
              while (isSpaceChar(c))
                    c = next();
              int sgn = 1;
              if (c == '-') {
                    sgn = -1;
                    c = next();
              }
              int res = 0;
              do {
                    if (c < '0' || c > '9')
                          throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = next();
              } while (!isSpaceChar(c));
              return res * sgn;
        }

        public boolean isSpaceChar(int c) {
              if (filter != null)
                    return filter.isSpaceChar(c);
              return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
              public boolean isSpaceChar(int ch);
        }
    }
}
