import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author quangpham
 */
public class D {

    private static final int[] drow = new int[]{0, +1, 0, -1};
    private static final int[] dcol = new int[]{+1, 0, -1, 0};

    private class Block {

        public int row, col, DP, CP;

        public Block(int row, int col, int DP, int CP) {
            this.row = row;
            this.col = col;
            this.DP = DP;
            this.CP = CP;
        }
    }

    private boolean inside(int row, int col, int nrow, int ncol) {
        return 0 <= row && row < nrow && 0 <= col && col < ncol;
    }

    private int whichBlock(int nrow, int ncol, char[][] a, int nstep) {
        int[][][][] howmany = new int[nrow][ncol][4][2];

        for (int row = 0; row < nrow; ++row) {
            for (int col = 0; col < ncol; ++col) {
                for (int d = 0; d < 4; ++d) {
                    for (int c = 0; c < 2; ++c) {
                        howmany[row][col][d][c] = -1;
                    }
                }
            }
        }

        Block current = null;
        for (int row = 0; row < nrow; ++row) {
            for (int col = 0; col < ncol; ++col) {
                if (current == null && a[row][col] > 0) {
                    howmany[row][col][0][0] = 0;
                    current = new Block(row, col, 0, 0);
                }
            }
        }

        ArrayList<Integer> which = new ArrayList<Integer>();

        while (current != null) {
            int row = current.row;
            int col = current.col;
            int d = current.DP;
            int c = current.CP;

            int step = howmany[row][col][d][c];
            if (step == nstep) {
                return a[row][col] - '0';
            }
            which.add(a[row][col] - '0');



            while (true) {
                int nextrow = row + drow[d];
                int nextcol = col + dcol[d];

                if (inside(nextrow, nextcol, nrow, ncol) && a[nextrow][nextcol] == a[row][col]) {
                    row = nextrow;
                    col = nextcol;
                } else {
                    break;
                }
            }

            int x = (c == 0) ? d - 1 : d + 1;
            x = (x + 4) % 4;

            while (true) {
                int nextrow = row + drow[x];
                int nextcol = col + dcol[x];

                if (inside(nextrow, nextcol, nrow, ncol) && a[nextrow][nextcol] == a[row][col]) {
                    row = nextrow;
                    col = nextcol;
                } else {
                    break;
                }
            }

            int nextrow = row + drow[d];
            int nextcol = col + dcol[d];

            if (inside(nextrow, nextcol, nrow, ncol) && a[nextrow][nextcol] - '0' > 0) {
                row = nextrow;
                col = nextcol;
            } else {
                if (c == 0) {
                    c = 1 - c;
                } else {
                    c = 1 - c;
                    d = (d + 1) % 4;
                }
            }

            current = new Block(row, col, d, c);
            if (howmany[row][col][d][c] == -1) {
                howmany[row][col][d][c] = step + 1;
            } else {
                break;
            }
        }

        int total = which.size();
        int at = howmany[current.row][current.col][current.DP][current.CP];

        if (nstep < at) {
            return which.get(nstep);
        }

        int cycle = total - at;
        nstep -= at;
        return which.get(at + (nstep % cycle));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        char[][] program = new char[m][];
        for (int i = 0; i < m; ++i) {
            program[i] = scanner.next().toCharArray();
        }

        System.out.println(whichBlock(m, program[0].length, program, n));

        scanner.close();
    }

    public static void main(String[] args) {
        new D().run();
    }
}
