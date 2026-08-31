import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();

            TaskC.Tree[] tree = new TaskC.Tree[n];

            for (int i = 0; i < n; ++i) {
                int x = in.nextInt();
                int h = in.nextInt();
                tree[i] = new TaskC.Tree(x, h);
            }

            int res = 0;
            for (int i = 0; i < n; ++i) {
                int x = tree[i].x;
                int h = tree[i].h;

                if (i == 0 || i == n - 1) {
                    ++res;
                    continue;
                }

                if (cutTree(i, x, x - h, tree)) {
                    ++res;
                    continue;
                }

                if (cutTree(i, x, x + h, tree)) {
                    ++res;
                    continue;
                }
            }

            out.print(res);
        }

        private boolean cutTree(int p, int from, int to, TaskC.Tree[] distance) {

            if (from < to) {
                for (int i = p + 1; i < distance.length; ++i) {
                    if (distance[i].x <= to || (distance[i].left != 0 && distance[i].left <= to)) return false;
                    else {
                        distance[p].right = to;
                        break;
                    }
                }
                return true;

            } else {
                for (int i = p - 1; i >= 0; --i) {
                    if (distance[i].x >= to || (distance[i].right != 0 && distance[i].right >= to)) return false;
                    else {
                        distance[p].left = to;
                        break;
                    }
                }
                return true;
            }
        }

        static class Tree {
            public int x;
            public int h;
            public int left = 0;
            public int right = 0;

            public Tree(int x, int h) {
                this.x = x;
                this.h = h;
            }

        }

    }
}

