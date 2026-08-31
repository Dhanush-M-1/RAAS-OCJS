
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C593C {

    public static void main(String[] args) throws Exception {
        new C593C().run();
        out.close();
    }
    
    void run() throws Exception {
        int n = nextInt();
        int[][] p = new int[2][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                p[j][i] = nextInt() / 2;
            }
            nextInt();
        }
        for (int t = 0; t < 2; ++t) {
            String res = "";
            for (int i = 0; i < n; ++i) {
                if (i < n - 1) {
                    res += "(";
                }
                String abs = "(1-abs((t-" + i + ")))";
                res += "(" + p[t][i] + "*(" + abs + "+abs(" + abs + ")))";
                if (i < n - 1) {
                    res += "+";
                } else {
                    for (int j = 0; j < n - 1; ++j) {
                        res += ")";
                    }
                }
            }
            out.println(res);
        }
    }
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~ template ~~~~~~~~~~~~~~~~~~~~~~~~~~~
    int[] nextIntArray(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = nextInt();
        }
        return res;
    }

    int[][] nextIntArray(int nx, int ny) throws IOException {
        int[][] res = new int[nx][ny];
        for (int i = 0; i < nx; ++i) {
            for (int j = 0; j < ny; ++j) {
                res[i][j] = nextInt();
            }
        }
        return res;
    }

    long[] nextLongArray(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; ++i) {
            res[i] = nextLong();
        }
        return res;
    }

    long[][] nextLongArray(int nx, int ny) throws IOException {
        long[][] res = new long[nx][ny];
        for (int i = 0; i < nx; ++i) {
            for (int j = 0; j < ny; ++j) {
                res[i][j] = nextLong();
            }
        }
        return res;
    }
    
    int[][] newIntArray(int nx, int ny, int val) {
        int[][] res = new int[nx][ny];
        for (int i = 0; i < nx; ++i) {
            Arrays.fill(res[i], val);
        }
        return res;
    }

    int[][][] newIntArray(int nx, int ny, int nz, int val) {
        int[][][] res = new int[nx][ny][nz];
        for (int i = 0; i < nx; ++i) {
            for (int j = 0; j < ny; ++j) {
                Arrays.fill(res[i][j], val);
            }
        }
        return res;
    }

    long[][] newLongArray(int nx, int ny, long val) {
        long[][] res = new long[nx][ny];
        for (int i = 0; i < nx; ++i) {
            Arrays.fill(res[i], val);
        }
        return res;
    }

    long[][][] newLongArray(int nx, int ny, int nz, long val) {
        long[][][] res = new long[nx][ny][nz];
        for (int i = 0; i < nx; ++i) {
            for (int j = 0; j < ny; ++j) {
                Arrays.fill(res[i][j], val);
            }
        }
        return res;
    }

    String nextToken() throws IOException {
        while (strTok == null || !strTok.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            strTok = new StringTokenizer(line);
        }
        return strTok.nextToken();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    
    static StringTokenizer strTok;
    final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    final static PrintWriter out = new PrintWriter(System.out);
}
