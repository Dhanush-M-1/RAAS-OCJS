
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class BetaRound74_Div1_C implements Runnable {

    //final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");
    
    void init() throws IOException {
        //if (ONLINE_JUDGE) {
        if (!(new File("input.txt").exists())) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }
    
    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
    
    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }
    
    long readLong() throws IOException {
        return Long.parseLong(readString());
    }
    
    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
    
    @Override
    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Thread(new BetaRound74_Div1_C()).run();
    }
    
    class Cell {
        int x, y;
        Cell up, down, left, right;
        
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int n, m;
    char[][] a;
    Cell[][] c;
    
    void fill() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != '.') {
                    c[i][j] = new Cell(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Cell L = null;
            for (int j = 0; j < m; j++) {
                if (a[i][j] != '.') {
                    if (L != null) {
                        c[i][j].left = L;
                        L.right = c[i][j];
                    }
                    L = c[i][j];
                }
            }
        }
        for (int j = 0; j < m; j++) {
            Cell U = null;
            for (int i = 0; i < n; i++) {
                if (a[i][j] != '.') {
                    if (U != null) {
                        c[i][j].up = U;
                        U.down = c[i][j];
                    } 
                    U = c[i][j];
                }
            }
        }
    }
    
    void delete(Cell cell) {
        if (cell.up != null) cell.up.down = cell.down;
        if (cell.down != null) cell.down.up = cell.up;
        if (cell.left != null) cell.left.right = cell.right;
        if (cell.right != null) cell.right.left = cell.left;
    }
    
    void solve() throws IOException {
        n = readInt();
        m = readInt();
        a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = readString().toCharArray();
        }
        c = new Cell[n][m];
        
        int best = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fill();
                int cur = go(i, j);
                if (cur > best) {
                    best = cur;
                    count = 1;
                }
                else if (cur == best) {
                    count++;
                }
            }
        }
        out.print(best + " " + count);
    }
    
    int go(int x, int y) {
        //System.err.printf("test: x=%d y=%d\n", x, y);
        if (a[x][y] == '.') return 0;
        int ans = 1;
        while (true) {
            Cell cell = c[x][y];
            //System.err.printf("x=%d y=%d\n", x, y);
            switch (a[x][y]) {
                case 'U':
                    if (cell.up == null) {
                        return ans;
                    } else {
                        x = cell.up.x;
                        y = cell.up.y;
                        delete(cell);
                        break;
                    }
                case 'D':
                    if (cell.down == null) {
                        return ans;
                    } else {
                        x = cell.down.x;
                        y = cell.down.y;
                        delete(cell);
                        break;
                    }
                case 'L':
                    if (cell.left == null) {
                        return ans;
                    } else {
                        x = cell.left.x;
                        y = cell.left.y;
                        delete(cell);
                        break;
                    }
                case 'R':
                    if (cell.right == null) {
                        return ans;
                    } else {
                        x = cell.right.x;
                        y = cell.right.y;
                        delete(cell);
                        break;
                    }
            }
            ans++;
        }
    }

}
