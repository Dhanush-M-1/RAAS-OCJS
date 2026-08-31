import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int DAY = 5;
    public static final int TIME = 2;
    public static final int PART_OF_TIMES = DAY * TIME + 1;//[0, 10]で11個

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][][] f = new int[N][TIME][DAY];
        int[][] p = new int[N][PART_OF_TIMES];
        for (int i = 0; i < f.length; i++) {
            f[i] = new int[TIME][DAY];
            for (int j = 0; j < f[i].length; j++) {
                f[i][j] = new int[DAY];
                for (int k = 0; k < f[i][j].length; k++) {
                    f[i][j][k] = in.nextInt();
                }
            }
        }
        for (int i = 0; i < p.length; i++) {
            p[i] = new int[PART_OF_TIMES];
            for (int j = 0; j < p[i].length; j++) {
                p[i][j] = in.nextInt();
            }
        }
        int ans = solve(N, f, p);
        System.out.println(ans);
        in.close();
    }

    //営業予定openに対しお店sが共通して開店している時間帯の数を返す
    static int getC(int[][] open, int[][] s) {
        int ret = 0;
        for (int i = 0; i < open.length; i++) {
            for (int j = 0; j < open[i].length; j++) {
                if (open[i][j] * s[i][j] == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }

    static int getTotalOpen(int[][] open) {
        int ret = 0;
        for (int i = 0; i < open.length; i++) {
            for (int j = 0; j < open[i].length; j++) {
                ret += open[i][j];
            }
        }
        return ret;
    }

    static int getProfit(int[][] open, final int N, final int[][][] f, final int[][] p) {
        int ret = 0;
        for (int i = 0; i < N; i++) {
            int c = getC(open, f[i]);//お店iとの重なりを調べる
            ret += p[i][c];
        }
        return ret;
    }

    static int[][] copy2Darray(int[][] from) {
        int[][] to = new int[from.length][];
        for (int i = 0; i < from.length; i++) {
            to[i] = Arrays.copyOf(from[i], from[i].length);
        }
        return to;
    }

    static int getMaxProfit(int[][] open, int t,
                            final int N, final int[][][] f, final int[][] p) {
        if (t == 10) {
            return getTotalOpen(open) > 0 ? getProfit(open, N, f, p) : Integer.MIN_VALUE;
        }
        int ret = Integer.MIN_VALUE;
        int ni = t / DAY, nj = t % DAY;
        if (ni < open.length && nj < open[ni].length) {
            int[][] nextOpen = copy2Darray(open);
            int[][] nextClose = copy2Darray(open);
            nextOpen[ni][nj] = 1;
            ret = Math.max(
                    getMaxProfit(nextOpen, t + 1, N, f, p),
                    getMaxProfit(nextClose, t + 1, N, f, p));
        }
        return ret;
    }

    static int solve(final int N, final int[][][] f, final int[][] p) {
        int[][] open = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int ans = getMaxProfit(open, 0, N, f, p);
        return ans;
    }

}
