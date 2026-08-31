import java.io.*;
import java.util.StringTokenizer;


public class Main {
    static final int NULL = -1;
    static int n, m;
    static char[] grid[];
    static Node[][] links;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][];
        for (int i = 0; i < n; i++)
            grid[i] = sc.next().toCharArray();
        preprocessNext();
        int max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') continue;
                for (int x = 0; x < n; x++)
                    for (int y = 0; y < m; y++)
                        if (links[x][y] != null) links[x][y].reset();
                int c = move(links, i, j);
                if (c == max) cnt++;
                else if (c > max) {
                    cnt = 1;
                    max = c;
                }
            }
        }
        out.println(max + " " + cnt);
        out.flush();
        out.close();
    }

    static int move(Node[][] links, int starti, int startj) {
        int ans = 0;
        Node cur = links[starti][startj];
        while (cur != null) {
            ans++;
            cur.delete();
            cur = cur.setNext();
        }
        return ans;
    }


    static void preprocessNext() {
        int[][][] next = new int[4][n][m];
        for (int i = 0; i < n; i++) {
            int last = NULL;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == '.') continue;
                next[1][i][j] = last;
                last = j;
            }
            last = NULL;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') continue;
                next[0][i][j] = last;
                last = j;
            }
        }
        for (int j = 0; j < m; j++) {
            int last = NULL;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == '.') continue;
                next[2][i][j] = last;
                last = i;
            }
            last = NULL;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == '.')
                    continue;
                next[3][i][j] = last;
                last = i;
            }
        }
        links = constructLinks(next);
    }

    static Node[][] constructLinks(int[][][] next) {
        Node[][] ans = new Node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') continue;
                ans[i][j] = new Node(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.') continue;
                if (next[0][i][j] != NULL)
                    ans[i][j].oleft = ans[i][next[0][i][j]];
                if (next[1][i][j] != NULL)
                    ans[i][j].oright = ans[i][next[1][i][j]];
                if (next[2][i][j] != NULL)
                    ans[i][j].oup = ans[next[2][i][j]][j];
                if (next[3][i][j] != NULL)
                    ans[i][j].odown = ans[next[3][i][j]][j];
            }
        }

        return ans;
    }

    static class Node {
        Node oleft, oright, oup, odown;
        Node left, right, up, down;
        int i, j;
        char dir;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
            this.dir = grid[i][j];
        }

        void delete() {
            if (left != null) left.right = right;
            if (right != null) right.left = left;
            if (down != null) down.up = up;
            if (up != null) up.down = down;

        }

        Node setNext() {
            if (dir == 'R') return right;
            if (dir == 'L') return left;
            if (dir == 'U') return up;
            return down;
        }

        void reset() {
            left = oleft;
            right = oright;
            up = oup;
            down = odown;
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }


    }

}