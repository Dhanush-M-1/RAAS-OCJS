import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Queue;
import java.io.FileReader;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BPuttingBricksInTheWall solver = new BPuttingBricksInTheWall();
        solver.solve(1, in, out);
        out.close();
    }

    static class BPuttingBricksInTheWall {
        int ROW;
        int COL;
        int[] rowNum = {-1, 0, 0, 1};
        int[] colNum = {0, -1, 1, 0};

        boolean isValid(int row, int col) {
            // return true if row number and
            // column number is in range
            return (row >= 0) && (row < ROW) &&
                    (col >= 0) && (col < COL);
        }

        int BFS(int mat[][], Point src,
                Point dest) {
            // check source and destination cell
            // of the matrix have value 1
            if (mat[src.x][src.y] != 1 ||
                    mat[dest.x][dest.y] != 1)
                return -1;

            boolean[][] visited = new boolean[ROW][COL];

            // Mark the source cell as visited
            visited[src.x][src.y] = true;

            // Create a queue for BFS
            Queue<queueNode> q = new LinkedList<>();

            // Distance of source cell is 0
            queueNode s = new queueNode(src, 0);
            q.add(s); // Enqueue source cell

            // Do a BFS starting from source cell
            while (!q.isEmpty()) {
                queueNode curr = q.peek();
                Point pt = curr.pt;

                // If we have reached the destination cell,
                // we are done
                if (pt.x == dest.x && pt.y == dest.y)
                    return curr.dist;

                // Otherwise dequeue the front cell
                // in the queue and enqueue
                // its adjacent cells
                q.remove();

                for (int i = 0; i < 4; i++) {
                    int row = pt.x + rowNum[i];
                    int col = pt.y + colNum[i];

                    // if adjacent cell is valid, has path
                    // and not visited yet, enqueue it.
                    if (isValid(row, col) &&
                            mat[row][col] == 1 &&
                            !visited[row][col]) {
                        // mark cell as visited and enqueue it
                        visited[row][col] = true;
                        queueNode Adjcell = new queueNode(new Point(row, col),
                                curr.dist + 1);
                        q.add(Adjcell);
                    }
                }
            }

            // Return -1 if destination cannot be reached
            return -1;
        }

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int t = 1;
            t = sc.nextInt();
            loop:
            while (t-- > 0) {
                int n = sc.nextInt();
                ROW = n;
                COL = n;
                char[][] arr = new char[n][n];
                for (int i = 0; i < n; i++) arr[i] = sc.nextLine().toCharArray();
                int[][] mat1 = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat1[i][j] = (arr[i][j] == '0' || arr[i][j] == 'F' || arr[i][j] == 'S') ? 1 : 0;
                    }
                }
                int[][] mat2 = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        mat2[i][j] = (arr[i][j] == '1' || arr[i][j] == 'F' || arr[i][j] == 'S') ? 1 : 0;
                    }
                }
                ArrayList<Point> ans = new ArrayList<>();
                Point Start = new Point(0, 0);
                Point end = new Point(n - 1, n - 1);
//		   for(int[]h:mat1)pw.println(Arrays.toString(h));
//		   pw.println();
//		   for(int[]h:mat2)pw.println(Arrays.toString(h));
                if (BFS(mat1, Start, end) == -1 && BFS(mat2, Start, end) == -1) {
                    pw.println(0);
                    continue loop;
                } else {
                    Point[] a = new Point[4];
                    a[0] = new Point(0, 1);
                    a[1] = new Point(1, 0);
                    a[2] = new Point(n - 1, n - 2);
                    a[3] = new Point(n - 2, n - 1);
                    for (int i = 0; i < a.length; i++) {
                        int x = a[i].x;
                        int y = a[i].y;
                        mat1[x][y] = 1 - mat1[x][y];
                        mat2[x][y] = 1 - mat2[x][y];
                        if (BFS(mat1, Start, end) == -1 && BFS(mat2, Start, end) == -1) {
                            pw.println(1);
                            pw.println(x + 1 + " " + (y + 1));
                            continue loop;
                        }
                        mat1[x][y] = 1 - mat1[x][y];
                        mat2[x][y] = 1 - mat2[x][y];
                    }
                    for (int i = 0; i < a.length; i++) {
                        for (int j = i + 1; j < a.length; j++) {
                            int x = a[i].x;
                            int y = a[i].y;
                            int x1 = a[j].x;
                            int y1 = a[j].y;
                            mat1[x][y] = 1 - mat1[x][y];
                            mat2[x][y] = 1 - mat2[x][y];
                            mat1[x1][y1] = 1 - mat1[x1][y1];
                            mat2[x1][y1] = 1 - mat2[x1][y1];
                            if (BFS(mat1, Start, end) == -1 && BFS(mat2, Start, end) == -1) {
                                pw.println(2);
                                pw.println(x + 1 + " " + (y + 1));
                                pw.println(x1 + 1 + " " + (y1 + 1));
                                continue loop;
                            }
                            mat1[x][y] = 1 - mat1[x][y];
                            mat2[x][y] = 1 - mat2[x][y];
                            mat1[x1][y1] = 1 - mat1[x1][y1];
                            mat2[x1][y1] = 1 - mat2[x1][y1];
                        }
                    }

                }
            }
        }

        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

        }

        class queueNode {
            Point pt;
            int dist;

            public queueNode(Point pt, int dist) {
                this.pt = pt;
                this.dist = dist;
            }

        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}

