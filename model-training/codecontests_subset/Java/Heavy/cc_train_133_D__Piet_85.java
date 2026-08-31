import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Artem Gilmudinov
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int[][] d = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int m;
        int n;
        int len;

        public void solve(int testNumber, Reader in, PrintWriter out) {
            m = in.ni();
            n = in.ni();
            String[] s = new String[m];
            for (int i = 0; i < m; i++) {
                s[i] = in.rl();
            }
            len = s[0].length();
            ArrayList<TaskD.Rectangle> rects = new ArrayList<>();
            boolean[][] used = new boolean[m][len];
            int[][] cell2rect = new int[m][len];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < len; j++) {
                    if (!used[i][j]) {
                        if (s[i].charAt(j) != '0') {
                            char color = s[i].charAt(j);
                            ArrayDeque<PairInt> q = new ArrayDeque<>();
                            q.addFirst(new PairInt(i, j));
                            TaskD.Rectangle rect = new TaskD.Rectangle();
                            rects.add(rect);
                            while (q.size() != 0) {
                                PairInt p = q.pollFirst();
                                used[p.x][p.y] = true;
                                rect.bottom = Math.max(p.x, rect.bottom);
                                rect.up = Math.min(p.x, rect.up);
                                rect.left = Math.min(p.y, rect.left);
                                rect.right = Math.max(p.y, rect.right);
                                cell2rect[p.x][p.y] = rects.size() - 1;
                                for (int z = 0; z < 4; z++) {
                                    int x, y;
                                    x = p.x + d[z][0];
                                    y = p.y + d[z][1];
                                    if (check(x, y) && !used[x][y] && color == s[x].charAt(y)) {
                                        q.addLast(new PairInt(x, y));
                                        used[x][y] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            PairInt bp = new PairInt(0, 0);
            int dp = 3; //0-up, 1-down, 2-left, 3-right
            int cp = 0; //0-left, 1-right
            int x, y;
            x = y = 0;
            for (int i = 0; i < n; i++) {
                if (s[bp.x].charAt(bp.y) == '0') {
                    out.println("FAIL");
                }
                TaskD.Rectangle rect = rects.get(cell2rect[bp.x][bp.y]);
                switch (dp) {
                    case 0:
                        if (cp == 0) {
                            x = rect.up;
                            y = rect.left;
                        } else {
                            x = rect.up;
                            y = rect.right;
                        }
                        break;
                    case 1:
                        if (cp == 0) {
                            x = rect.bottom;
                            y = rect.right;
                        } else {
                            x = rect.bottom;
                            y = rect.left;
                        }
                        break;
                    case 2:
                        if (cp == 0) {
                            x = rect.bottom;
                            y = rect.left;
                        } else {
                            x = rect.up;
                            y = rect.left;
                        }
                        break;
                    case 3:
                        if (cp == 0) {
                            x = rect.up;
                            y = rect.right;
                        } else {
                            x = rect.bottom;
                            y = rect.right;
                        }
                        break;
                }
                switch (dp) {
                    case 0:
                        if (check(x - 1, y) && s[x - 1].charAt(y) != '0') {
                            bp.x = x - 1;
                            bp.y = y;
                        } else {
                            if (cp == 0) {
                                cp = 1;
                            } else {
                                dp = 3;
                                cp = 0;
                            }
                            bp.x = x;
                            bp.y = y;
                        }
                        break;
                    case 1:
                        if (check(x + 1, y) && s[x + 1].charAt(y) != '0') {
                            bp.x = x + 1;
                            bp.y = y;
                        } else {
                            if (cp == 0) {
                                cp = 1;
                            } else {
                                dp = 2;
                                cp = 0;
                            }
                            bp.x = x;
                            bp.y = y;
                        }
                        break;
                    case 2:
                        if (check(x, y - 1) && s[x].charAt(y - 1) != '0') {
                            bp.y = y - 1;
                            bp.x = x;
                        } else {
                            if (cp == 0) {
                                cp = 1;
                            } else {
                                dp = 0;
                                cp = 0;
                            }
                            bp.x = x;
                            bp.y = y;
                        }
                        break;
                    case 3:
                        if (check(x, y + 1) && s[x].charAt(y + 1) != '0') {
                            bp.y = y + 1;
                            bp.x = x;
                        } else {
                            if (cp == 0) {
                                cp = 1;
                            } else {
                                dp = 1;
                                cp = 0;
                            }
                            bp.x = x;
                            bp.y = y;
                        }
                        break;
                }

            }
            out.println(s[bp.x].charAt(bp.y));

        }

        public boolean check(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < len;
        }

        class Rectangle {
            int left;
            int right;
            int up;
            int bottom;

            public Rectangle() {
                left = Integer.MAX_VALUE;
                right = Integer.MIN_VALUE;
                up = Integer.MAX_VALUE;
                bottom = Integer.MIN_VALUE;
            }

            public Rectangle(int left, int right, int up, int bottom) {
                this.left = left;
                this.right = right;
                this.up = up;
                this.bottom = bottom;
            }

            public String toString() {
                return left + " " + right + " " + up + " " + bottom;
            }

        }

    }

    static class Reader {
        private BufferedReader in;
        private StringTokenizer st = new StringTokenizer("");
        private String delim = " ";

        public Reader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(rl());
            }
            return st.nextToken(delim);
        }

        public String rl() {
            try {
                return in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int ni() {
            return Integer.parseInt(next());
        }

    }

    static class PairInt {
        public int x;
        public int y;

        public PairInt(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }

    }
}

