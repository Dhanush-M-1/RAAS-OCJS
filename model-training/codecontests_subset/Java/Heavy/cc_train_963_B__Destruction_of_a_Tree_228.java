import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author WLZ
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public int n;
        public ArrayList<Integer>[] AdjList;
        public ArrayList<Integer> ans;
        public int[] degree;

        void dfs(int u) {
            for (int v : AdjList[u]) {
                dfs(v);
            }
            ans.add(u);
            return;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            n = in.nextInt();
            AdjList = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) AdjList[i] = new ArrayList<>();
            int root = 0;
            degree = new int[n + 1];
            int[] p = new int[n + 1];
            for (int i = 0; i <= n; i++) degree[i] = 0;
            for (int i = 1; i <= n; i++) {
                int pi = in.nextInt();
                p[i] = pi;
                degree[pi]++;
                if (pi != 0) {
                    degree[i]++;
                } else {
                    root = i;
                }
                AdjList[pi].add(i);
            }


            ans = new ArrayList<>();
            dfs(root);
            ArrayList<Integer> e = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            for (int i : ans) {
                if (degree[i] % 2 == 1) {
                    if (i == root) {
                        out.println("NO");
                        return;
                    }
                    e.add(i);
                } else {
                    res.add(i);
                    degree[p[i]]--;
                }
            }
            Collections.reverse(e);
            for (int i : e) {
                res.add(i);
            }
            out.println("YES");
            for (int u : res) {
                out.println(u);
            }
        }

    }
}

