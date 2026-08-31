import java.util.Arrays;
import java.util.Scanner;

public class Main implements Runnable {
    public int next[][][];
    public String line[];
    public int last[][][];
    int maxDepth,cnt;
    int n,m;
    public void read() {
        
    }
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt(); //fafda
        line = new String[n];
        next = new int[n][m][4];
        last = new int[n][m][4];
        int pre[] = new int[m];
        int tmp;
        Arrays.fill(pre, -1);
        for (int i = 0; i < n; i ++) {
            tmp = -1;
            line[i] = scanner.next();
            for (int j = 0;j < m; j ++) {
                if (line[i].charAt(j) != '.') {
                    next[i][j][0] = pre[j];
                    next[i][j][2] = tmp;
                    tmp = j;
                    pre[j] = i;
                }
            }
        }
        Arrays.fill(pre, n);
        for (int i = n-1; i >= 0; i --) {
            tmp = m;
            for (int j = m - 1; j >= 0; j --) {
                if (line[i].charAt(j) != '.' ) {
                    next[i][j][1] = pre[j];
                    next[i][j][3] = tmp;
                    tmp = j;
                    pre[j] = i;
                }
            }
        }
        maxDepth = 0;
        cnt = 1;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j <m; j ++)
                for (int k = 0; k < 4; k ++)
                    last[i][j][k] = next[i][j][k];
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m;j ++) {
                if (line[i].charAt(j) != '.') {
                    for (int ii = 0; ii < n; ii ++) {
                        for (int jj = 0; jj < m; jj ++) {
                            for (int k = 0; k < 4; k ++)
                            next[ii][jj][k] = last[ii][jj][k];
                        }
                    }
                    dfs(i, j, 1);
                }
            }
        }
        System.out.println(maxDepth + " " + cnt);
    }
    
    public void dfs(int x,int y,int deep) {
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (deep > maxDepth) {
            maxDepth = deep ;
            cnt = 1;
        } else if (deep == maxDepth) {
            cnt ++;
        }
        if (next[x][y][2] >= 0 && next[x][y][2] < m) {
            next[x][next[x][y][2]][3] = next[x][y][3];
        }
        if (next[x][y][3] >= 0 && next[x][y][3] < m) {
            next[x][next[x][y][3]][2] = next[x][y][2];
        }
        if ( next[x][y][0] >= 0 && next[x][y][0] < n) {
            next[next[x][y][0]][y][1] = next[x][y][1];
        }
        if (next[x][y][1] >= 0 && next[x][y][1] < n) {
            next[next[x][y][1]][y][0] = next[x][y][0];
        }
        
        if (line[x].charAt(y) == 'U' ) {
            dfs(next[x][y][0], y, deep + 1);
        } else if (line[x].charAt(y) == 'D') {
            dfs(next[x][y][1], y, deep + 1);
        } else if(line[x].charAt(y) == 'L') {
            dfs(x, next[x][y][2], deep + 1);
        } else {
            dfs(x, next[x][y][3], deep + 1);
        }
    }

    public static void main(String[] args) {
        
        Main e = new Main();
        e.run();
    }

}
