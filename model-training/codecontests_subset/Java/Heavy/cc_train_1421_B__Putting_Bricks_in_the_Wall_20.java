import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class B1421 {
    private StreamTokenizer in;
    private PrintWriter out;
    Scanner sc;
    public int nextInt() throws IOException {
        return sc.nextInt();
    }

    public String nextString() throws IOException {
        return sc.next();
    }

    public B1421() {
        sc = new Scanner(System.in);
        out = new PrintWriter(System.out);
    }

    public static void main(String[] args) throws IOException {
        new B1421().solve();
    }

    public void solve() throws IOException {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            dowork();
        }
    }

    private void dowork() throws IOException {
        int n = nextInt();
        int[][] table = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String s = nextString();

            if (s != null) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == 'S' || s.charAt(j) == 'F') continue;
                    table[i][j + 1] = s.charAt(j) - '0';
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    table[i][j] = nextInt();
                }
            }



        }

        LinkedList<int[]> res = new LinkedList<>();
        if (table[n - 1][n] == table[n][n - 1]) {
            if (table[1][2] == table[n][n - 1]) {
                res.add(new int[]{1, 2});
            }
            if (table[2][1] == table[n][n - 1]) {
                res.add(new int[]{2, 1});
            }

        } else {
            int ones = 0;
            int zeros = 0;
            if (table[n - 2][n] == 0) zeros++;
            else ones++;
            if (table[n - 1][n - 1] == 0) zeros++;
            else ones++;
            if (table[n][n - 2] == 0) zeros++;
            else ones++;

            calc(res, ones, zeros, table);
        }

        System.out.println(res.size());
        if (res.size() > 0) {
            for (int[] rr : res) {
                out.println(rr[0] + " " + rr[1]);
            }
        }
        out.flush();


    }

    private void calc(LinkedList<int[]> res, int ones, int zeros, int[][] table) {
        if (ones == 3) {
            invert(res, 1, table);
        }
        if (zeros == 3) {
            invert(res, 0, table);
        }

        if (ones == 2) {
            workw(1, table, res);
        }

        if (zeros == 2) {
            workw(0, table, res);
        }
    }

    private void workw(int i, int[][] table, LinkedList<int[]> res) {
        int n = table.length - 1;
        if (table[n - 2][n] != i) res.add(new int[]{n - 2, n});
        if (table[n - 1][n - 1] != i) res.add(new int[]{n - 1, n - 1});
        if (table[n][n - 2] != i) res.add(new int[]{n, n - 2});


        if (table[n - 1][n] == i) res.add(new int[]{n - 1, n});
        if (table[n][n - 1] == i) res.add(new int[]{n, n - 1});
    }

    private void invert(LinkedList<int[]> res, int i, int[][] table) {
        int n = table.length - 1;
        if (table[n - 1][n] == i) res.add(new int[]{n - 1, n});
        if (table[n][n - 1] == i) res.add(new int[]{n, n - 1});
    }

    private int[] inv(int x, int y, int[][] table) {
        if (table[x][y] != table[x - 1][y] && table[x][y] != table[x][y - 1]) {
            return null;
        }
        if (table[x][y] == table[x - 1][y] && table[x][y] == table[x][y - 1]) {
            return new int[]{x, y};
        }

        if (table[x - 1][y] != table[x][y]) return new int[]{x - 1, y};
        return new int[]{x, y - 1};
    }

}
