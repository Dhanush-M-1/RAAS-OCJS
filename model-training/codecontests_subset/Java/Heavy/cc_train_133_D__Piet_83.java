import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    static class State {
        int num;
        int dir;
        int dir2;
        int i;
        int j;

        public State(int Num, int Dir, int Dir2, int I, int J) {
            num = Num;
            dir = Dir;
            dir2 = Dir2;
            i = I;
            j = J;
        }
    }

    static int[] di = { -1, 0, 1, 0 };
    static int[] dj = { 0, 1, 0, -1 };

    static int n;
    static int m;
    static int[][] a;
    static int[][] b;
    static State[][][] memo;
    static TreeMap<Integer, Integer> col;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String[] s = new String[n];

        for (int i = 0; i < n; i++)
            s[i] = in.nextLine();
        m = s[0].length();

        a = new int[n][m];
        b = new int[n][m];
        memo = new State[n * m][4][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = s[i].charAt(j) - '0';
        for (int i = 0; i < n; i++)
            Arrays.fill(b[i], -2);

        int cur_bl = 0;
        col = new TreeMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] != -2)
                    continue;
                if (a[i][j] == 0)
                    b[i][j] = -1;
                else {
                    dfs(i, j, a[i][j], cur_bl);
                    col.put(cur_bl, a[i][j]);
                    cur_bl++;
                }
            }
        }

        State curr = new State(b[0][0], 1, 1, 0, 0);

        for (int i = 0; i < k; i++) {
            if (memo[curr.num][curr.dir][curr.dir2] != null) {
                curr = memo[curr.num][curr.dir][curr.dir2];
            } else {
                State new_st = new State(curr.num, curr.dir, curr.dir2, curr.i,
                        curr.j);
                int lasti = curr.i;
                int lastj = curr.j;
                while (true) {
                    int newi = lasti + di[curr.dir];
                    int newj = lastj + dj[curr.dir];

                    if (!isOk(newi, newj) || b[newi][newj] != curr.num)
                        break;
                    lasti = newi;
                    lastj = newj;
                }

                int newdir = 0;
                if (curr.dir2 == 1) {
                    newdir = curr.dir - 1;
                    if (newdir == -1)
                        newdir = 3;
                } else {
                    newdir = curr.dir + 1;
                    if (newdir == 4)
                        newdir = 0;
                }

                while (true) {
                    int newi = lasti + di[newdir];
                    int newj = lastj + dj[newdir];

                    if (!isOk(newi, newj) || b[newi][newj] != curr.num)
                        break;
                    lasti = newi;
                    lastj = newj;
                }

                int newi = lasti + di[curr.dir];
                int newj = lastj + dj[curr.dir];
                if (!isOk(newi, newj) || b[newi][newj] == -1) {
                    if (curr.dir2 == 1) {
                        new_st.dir2 = 0;
                    } else {
                        new_st.dir2 = 1;
                        new_st.dir++;
                        new_st.dir %= 4;
                    }
                } else {
                    new_st.num = b[newi][newj];
                    new_st.i = newi;
                    new_st.j = newj;
                }

                memo[curr.num][curr.dir][curr.dir2] = new_st;
                curr = new_st;
            }
        }

        out.println(col.get(curr.num));
        out.close();
    }

    private static void dfs(int i, int j, int init_c, int bl_num) {
        b[i][j] = bl_num;

        for (int it = 0; it < di.length; it++) {
            int newi = i + di[it];
            int newj = j + dj[it];

            if (isOk(newi, newj) && a[newi][newj] == init_c
                    && b[newi][newj] != bl_num) {
                dfs(newi, newj, init_c, bl_num);
            }
        }
    }

    private static boolean isOk(int newi, int newj) {
        return newi >= 0 && newi < n && newj >= 0 && newj < m;
    }
}
