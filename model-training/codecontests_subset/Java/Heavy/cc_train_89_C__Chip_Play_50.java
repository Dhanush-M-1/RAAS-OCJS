import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

public class C {
    public void run() throws IOException {
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        int n = nextInt();
        int m = nextInt();

        int[][] dir = new int[n][m];

        for (int i = 0; i < n; ++i) {
            char[] row = nextToken().toCharArray();
            for (int j = 0; j < m; ++j) {
                if (row[j] == 'L') {
                    dir[i][j] = 1;
                }
                else if (row[j] == 'R') {
                    dir[i][j] = 0;
                }
                else if (row[j] == 'U') {
                    dir[i][j] = 3;
                }
                else if (row[j] == 'D') {
                    dir[i][j] = 2;
                }
                else {
                    dir[i][j] = -1;
                }
            }
        }

        int[][][] nextr = new int[n][m][4];
        int[][][] nextc = new int[n][m][4];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int d = 0; d < 4; ++d) {
                    nextr[i][j][d] = -1;
                    nextc[i][j][d] = -1;
                    int r = i + dr[d];
                    int c = j + dc[d];
                    while (r >= 0 && r < n && c >= 0 && c < m) {
                        if (dir[r][c] != -1) {
                            nextr[i][j][d] = r;
                            nextc[i][j][d] = c;
                            break;
                        }
                        r += dr[d];
                        c += dc[d];
                    }
                }
            }
        }

        int[][][] nr = new int[n][m][4];
        int[][][] nc = new int[n][m][4];

        int ans = 0;
        int ansCount = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (dir[i][j] != -1) {
                    for (int k = 0; k < n; ++k) {
                        for (int l = 0; l < m; ++l) {
                            for (int d = 0; d < 4; ++d) {
                                nr[k][l][d] = nextr[k][l][d];
                                nc[k][l][d] = nextc[k][l][d];
                            }
                        }
                    }

                    int r = i;
                    int c = j;

                    int count = 0;

                    while (r >= 0 && r < n && c >= 0 && c < m) {
                        ++count;
                        for (int d = 0; d < 4; ++d) {
                            if (nr[r][c][d] != -1 && nc[r][c][d] != -1) {
                                nr[nr[r][c][d]][nc[r][c][d]][d^1] = nr[r][c][d^1];
                                nc[nr[r][c][d]][nc[r][c][d]][d^1] = nc[r][c][d^1];
                            }
                        }

                        int d = dir[r][c];
                        if (d == -1) {
                            break;
                        }
                        int r2 = nr[r][c][d];
                        int c2 = nc[r][c][d];
                        r = r2;
                        c = c2;
                    }

                    if (count > ans) {
                        ans = count;
                        ansCount = 1;
                    }
                    else if (count == ans) {
                        ++ansCount;
                    }
                }
            }
        }

        out.println(ans + " " + ansCount);
    }

    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static final PrintStream out = new PrintStream(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);

        new C().run();

        out.close();
    }

    public static StringTokenizer tokenizer;

    public static String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
