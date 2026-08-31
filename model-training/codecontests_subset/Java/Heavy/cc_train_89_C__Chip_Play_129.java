import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Author -
 * User: kansal
 * Date: 6/16/11
 * Time: 8:26 PM
 */
public class C {
    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));

        int height = nextInt(), width = nextInt();
        char[][] B = new char[height][width];
        for(int i = 0; i < height; ++i) {
            B[i] = nextLine().toCharArray();
        }


        int[][][][] next = new int[height][width][4][2];
        clone = new int[height][width][4][2];
        f['U'] = 0; f['R'] = 1; f['D'] = 2; f['L'] = 3;

        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if (B[i][j] == '.') continue;
                for(int k = 0; k < 4; ++k) {
                    next[i][j][k][0] = next[i][j][k][1] = -1;

                    int x = i + D[k][0], y = j + D[k][1];
                    while (good(x, y, height, width) && B[x][y] == '.') {
                        x += D[k][0]; y += D[k][1];
                    }
                    if (good(x, y, height, width)) {
                        next[i][j][k][0] = x;
                        next[i][j][k][1] = y;
                    }
                }
            }
        }
//        System.out.println("here");

        int mx = -1, num = 0;
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if (B[i][j] == '.') continue;
                int score = find(i, j, B, getClone(next));
                if (score > mx) {
                    mx = score;
                    num = 1;
                }
                else if (score == mx) {
                    ++num;
                }
            }
        }

        System.out.println(mx + " " + num);

    }

    static int[][][][] clone;
    private static int[][][][] getClone(int[][][][] next) {
        int R = next.length, C = next[0].length;
        for(int i = 0; i < R; ++i) {
            for(int j = 0; j < C; ++j) {
                for(int k = 0; k < 4; ++k) {
                    for(int l = 0; l < 2; ++l) {
                        clone[i][j][k][l] = next[i][j][k][l];
                    }
                }
            }
        }
        return clone;
    }

    static int[][] D = new int[][] {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    static int[] f = new int[256];


    private static int find(int x, int y, char[][] B, int[][][][] next) {
        int res = 0;

        while (x != -1 && y != -1) {
            ++res;

            for(int i = 0; i < 4; ++i) {
                int a = next[x][y][i][0], b = next[x][y][i][1];
                int c = next[x][y][(i+2)%4][0], d = next[x][y][(i+2)%4][1];
                if (c == -1 || d == -1) continue;

                next[c][d][i][0] = a;
                next[c][d][i][1] = b;
            }

            int nx = next[x][y][f[B[x][y]]][0], ny = next[x][y][f[B[x][y]]][1];
            x = nx;
            y = ny;
        }

        return res;
    }

    private static boolean good(int x, int y, int R, int C) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    public static BufferedReader reader;

    public static StringTokenizer tokenizer = null;

    static String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    static public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static public long nextLong() {
        return Long.parseLong(nextToken());
    }

    static public String next() {
        return nextToken();
    }

    static public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
