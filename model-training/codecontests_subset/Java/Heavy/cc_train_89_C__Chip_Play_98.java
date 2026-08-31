import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E {
    static int[][] A;
    static int[][][] Next;
    static int n;
    static int m;
    static int temp = 0;

    public static void dfs(int x, int y) {
        if (x == -1 || y == -1)
            return;
        markVisited(x, y);
        temp++;
        if (A[x][y] < 2)
            dfs(Next[A[x][y]][x][y], y);
        else
            dfs(x, Next[A[x][y]][x][y]);
        markUnVisited(x, y);
    }

    public static void markVisited(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (Next[i][x][y] == -1)
                continue;
            if (i < 2)
                Next[1 - i][Next[i][x][y]][y] = Next[1 - i][x][y];
            else
                Next[5 - i][x][Next[i][x][y]] = Next[5 - i][x][y];
        }
    }

    public static void markUnVisited(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (Next[i][x][y] == -1)
                continue;
            if (i < 2)
                Next[1 - i][Next[i][x][y]][y] = x;
            else
                Next[5 - i][x][Next[i][x][y]] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] S = in.readLine().split(" ");
        n = Integer.parseInt(S[0]);
        m = Integer.parseInt(S[1]);
        A = new int[n][m];
        Next = new int[4][n][m];
        int[] lastRow = new int[m];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(Next[i][j], -1);
        Arrays.fill(lastRow, -1);
        for (int i = 0; i < n; i++) {
            String s = in.readLine();
            int lastColumn = -1;
            for (int j = 0; j < m; j++) {
                switch (s.charAt(j)) {
                case 'U':
                    A[i][j] = 0;
                    break;
                case 'D':
                    A[i][j] = 1;
                    break;
                case 'R':
                    A[i][j] = 2;
                    break;
                case 'L':
                    A[i][j] = 3;
                    break;
                default:
                    A[i][j] = -1;
                }
                if (A[i][j] == -1)
                    continue;
                Next[0][i][j] = lastRow[j];
                if (lastRow[j] != -1)
                    Next[1][lastRow[j]][j] = i;
                Next[3][i][j] = lastColumn;
                if (lastColumn != -1)
                    Next[2][i][lastColumn] = j;
                lastColumn = j;
                lastRow[j] = i;
            }
        }
        int max = 0;
        int sum = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (A[i][j] == -1)
                    continue;
                temp = 0;
                dfs(i, j);
                if (temp > max) {
                    max = temp;
                    sum = 1;
                } else if (temp == max)
                    sum++;
            }
        System.out.println(max + " " + sum);
    }
}
