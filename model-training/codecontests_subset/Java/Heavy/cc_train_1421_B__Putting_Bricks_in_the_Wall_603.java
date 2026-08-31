import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    private static final int N = 200;
    private static int n = 200;
    private static char[][] map = new char[N][N];
    private static char[][] nowMap = new char[N][N];
    private static boolean[][] vis = new boolean[N][N];
    private static int[] xDir = new int[]{0, 0, 1, -1};
    private static int[] yDir = new int[]{1, -1, 0, 0};

    private static void dfs(int x, int y, char ch) {
        if (vis[x][y]) return;
        if (nowMap[x][y] != 'S' && nowMap[x][y] != 'F' && nowMap[x][y] != ch) {
            return;
        }
        vis[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int nx = x + xDir[i];
            int ny = y + yDir[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                dfs(nx, ny, ch);
            }
        }
    }

    private static void showVis() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                out.print(vis[i][j] ? 1 : 0);
                out.print(' ');
            }
            out.println();
        }
    }

    private static void initVis() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                vis[i][j] = false;
            }
        }
    }

    private static boolean check(int i1, int i2, int j1, int j2) {
        if (i1 + i2 + j1 + j2 > 2) return false;
        for (int i = 0; i < n; ++i) {
            System.arraycopy(map[i], 0, nowMap[i], 0, n);
        }
        if (i1 > 0) {
//            out.println("1 2");
            nowMap[0][1] = rev(map[0][1]);
        }
        if (i2 > 0) {
//            out.println("2 1");
            nowMap[1][0] = rev(map[1][0]);
        }
        if (j1 > 0) {
//            out.println(n + " " + (n - 1));
            nowMap[n - 1][n - 2] = rev(map[n - 1][n - 2]);
        }
        if (j2 > 0) {
//            out.println((n - 1) + " " + n);
            nowMap[n - 2][n - 1] = rev(map[n - 2][n - 1]);
        }
        initVis();
        dfs(0, 0, '0');
        if (vis[n - 1][n - 1]) return false;
        initVis();
        dfs(0, 0, '1');
        return !vis[n - 1][n - 1];
    }

    private static char rev(char ch) {
        return (char) (((ch - '0') ^ 1) + '0');
    }

    private static void solve() {
        n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            String str = in.next();
            for (int j = 0; j < str.length(); ++j) {
                map[i][j] = str.charAt(j);
            }
        }
        boolean ok = false;
        for (int i = 0; i < 2; ++i) {
            for (int i2 = 0; i2 < 2; ++i2) {
                for (int j = 0; j < 2; ++j) {
                    for (int j2 = 0; j2 < 2; ++j2) {
                        if (!ok && check(i, i2, j, j2)) {
                            ok = true;
//                            showVis();
                            out.println(i + i2 + j + j2);
                            if (i > 0) {
                                out.println("1 2");
                            }
                            if (i2 > 0) {
                                out.println("2 1");
                            }
                            if (j > 0) {
                                out.println(n + " " + (n - 1));
                            }
                            if (j2 > 0) {
                                out.println((n - 1) + " " + n);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void solveT() {
        int T = in.nextInt();
        for (int t = 0; t < T; ++t) {
            solve();
        }
    }
    // -----------------------  Common Func ------------------------

    public static void main(String[] args) {
//        while (in.hasNext()) {
        solveT();
//        }
//        out.close();
    }

    static class MyScanner {
        private Scanner scanner;

        MyScanner() {
            this.scanner = new Scanner(System.in);
        }

        int nextInt() {
            return scanner.nextInt();
        }

        long nextLong() {
            return scanner.nextLong();
        }

        String next() {
            return scanner.next();
        }

        String nextLine() {
            return scanner.nextLine();
        }

        boolean hasNext() {
            return scanner.hasNext();
        }

        Integer[] nextIntegerArray(int len) {
            Integer[] result = new Integer[len];
            for (int i = 0; i < len; ++i) {
                result[i] = nextInt();
            }
            return result;
        }

        ArrayList<Integer> nextIntegerArrayList(int len) {
            return new ArrayList<Integer>(Arrays.asList(nextIntegerArray(len)));
        }

        String[] nextStringArray(int len) {
            String[] result = new String[len];
            for (int i = 0; i < len; ++i) {
                result[i] = next();
            }
            return result;
        }

        ArrayList<String> nextStringArrayList(int len) {
            return new ArrayList<String>(Arrays.asList(nextStringArray(len)));
        }
    }

    private static MyScanner in = new MyScanner();
    private static PrintStream out = System.out;

    private static <T> void commonPrintLine(List<T> list) {
        int i = 0, len = list.size();
        for (T item : list) {
            out.print(item);
            out.print((++i) < len ? ' ' : '\n');
        }
    }

    private static <T> void commonPrintLine(ArrayList<T> list) {
        int i = 0, len = list.size();
        for (T item : list) {
            out.print(item);
            out.print((++i) < len ? ' ' : '\n');
        }
    }

    public static class MyPair {
        int x;
        int y;

        MyPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
