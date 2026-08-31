/**
 * Created by IntelliJ IDEA.
 * User: jte
 * Date: 12/3/11
 * Time: 10:27 AM
 * To change this template use File | Settings | File Templates.
 */

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultXMLDocumentHandler;

import java.io.*;
import java.util.*;

public class TaskD extends Thread {
    public TaskD(int what) {
        try {
            if (what == 0) {
                this.input = new BufferedReader(new InputStreamReader(System.in));
                this.output = new PrintWriter(System.out);
            } else {
                this.input = new BufferedReader(new FileReader(INPUT_FILE));
                this.output = new PrintWriter(OUTPUT_FILE);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(666);
        }
    }


    static boolean good(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }
        return grid[i][j] != '0';
    }

    private void solve() throws Throwable {
        int m = nextInt(), n = nextInt();
        grid = new char[m][];
        for (int i = 0; i < m; ++i) {
            grid[i] = nextToken().toCharArray();
        }
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int can[][][] = new int[m][][];
        for (int i = 0; i < m; ++i) {
            can[i] = new int[grid[i].length][4];
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int x = i, y = j;

                for (int DIR = 0; DIR < 4; ++DIR) {
                    int result = 0;
                    x = i;
                    y = j;
                    while (good(x + dx[DIR], y + dy[DIR]) && grid[x + dx[DIR]][y + dy[DIR]] == grid[i][j]) {
                        x += dx[DIR];
                        y += dy[DIR];
                        ++result;
                    }
                    can[i][j][DIR] = result;
                }

            }
        }

        int DP = 2;
        int CP = 1;
        char last = grid[0][0];
        int x = 0, y = 0;
        for (int i = 0; i < n; ++i) {
            int nowX = x, nowY = y;
            x += dx[DP] * can[nowX][nowY][DP];
            y += dy[DP] * can[nowX][nowY][DP];
            nowX = x; nowY = y;
            x += dx[CP] * can[nowX][nowY][CP];
            y += dy[CP] * can[nowX][nowY][CP];
            if (good(x + dx[DP], y + dy[DP])) {
                x += dx[DP];
                y += dy[DP];
                last = grid[x][y];
            } else {
                if ((CP + 1) % 4 == DP) {
                    CP = (DP + 1) % 4;
                } else {
                    CP = DP;
                    DP = (DP + 1) % 4;
                }
            }
        }

        output.println(last);

    }

    public void run() {
        try {
            solve();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(666);
        } finally {
            output.flush();
            output.close();
        }
    }


    public static void main(String... args) {
        new TaskD(0).start();
    }

    private String nextToken() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine());
        }
        return tokens.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static char[][] grid;

    private String INPUT_FILE = null;
    private String OUTPUT_FILE = null;
    private BufferedReader input;
    private PrintWriter output;
    private StringTokenizer tokens = null;
}
