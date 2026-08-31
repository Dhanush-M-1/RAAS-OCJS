import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class C implements Runnable {
    private Scanner in;
    private PrintWriter out;
    
    private int n, m;
    
    private char[][] map;
    
    private HashMap<Integer, Integer> getNumber, getX, getY;
    
    private int[][] next, nextTemp;
    
    private void delete(int n) {
        for (int i = 0; i < 4; ++i) {
            if (next[i][n] != -1) {
                next[(i + 2) % 4][next[i][n]] = next[(i + 2) % 4][n];
            }
        }
    }
    
    private void setNext() {
        for (int i = 0; i < n; ++i) {
            int temp = -1;
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == '.') {
                    continue;
                }
                int cc = getNumber.get(m * i + j);
                nextTemp[0][getNumber.get(m * i + j)] = temp;
                temp = cc;
            }
        }
        for (int i = 0; i < n; ++i) {
            int temp = -1;
            for (int j = m - 1; j >= 0; --j) {
                if (map[i][j] == '.') {
                    continue;
                }
                int cc = getNumber.get(m * i + j);
                nextTemp[2][getNumber.get(m * i + j)] = temp;
                temp = cc;
            }
        }
        for (int j = 0; j < m; ++j) {
            int temp = -1;
            for (int i = 0; i < n; ++i) {
                if (map[i][j] == '.') {
                    continue;
                }
                int cc = getNumber.get(m * i + j);
                nextTemp[1][getNumber.get(m * i + j)] = temp;
                temp = cc;
            }
        }
        for (int j = 0; j < m; ++j) {
            int temp = -1;
            for (int i = n - 1; i >= 0; --i) {
                if (map[i][j] == '.') {
                    continue;
                }
                int cc = getNumber.get(m * i + j);
                nextTemp[3][getNumber.get(m * i + j)] = temp;
                temp = cc;
            }
        }
    }
    
    private int dfs(int x, int y) {
        int ans = 1;
        while (true) {
            int dir = -1;
            switch (map[x][y]) {
            case 'L':
                dir = 0;
                break;
            case 'R':
                dir = 2;
                break;
            case 'U':
                dir = 1;
                break;
            default:
                dir = 3;
            }
            int nextNumber = next[dir][getNumber.get(m * x + y)];
            delete(getNumber.get(m * x + y));
            if (nextNumber == -1) {
                break;
            }
            x = getX.get(nextNumber);
            y = getY.get(nextNumber);
            ++ans;
        }
        return ans;
    }

    private void solve() {
        n = in.nextInt();
        m = in.nextInt();
        map = new char[n][m];
        for (int i = 0; i < n; ++i) {
            map[i] = in.next().toCharArray();
        }
        int curn = 0;
        getNumber = new HashMap<Integer, Integer>();
        getX = new HashMap<Integer, Integer>();
        getY = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] != '.') {
                    getNumber.put(m * i + j, curn);
                    getX.put(curn, i);
                    getY.put(curn, j);
                    ++curn;
                }
            }
        }
        next = new int[4][curn];
        nextTemp = new int[4][curn];
        setNext();
        int times = 0;
        int best = -1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (map[i][j] == '.') {
                    continue;
                }
                for (int k = 0; k < 4; ++k) {
                    System.arraycopy(nextTemp[k], 0, next[k], 0, curn);
                }
                int cur = dfs(i, j);
                if (cur > best) {
                    best = cur;
                    times = 1;
                } else if (best == cur) {
                    ++times;
                }
            }
        }
        out.println(best + " " + times);
    }

    @Override
    public void run() {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        new C().run();
    }
}
