import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.function.Consumer;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScan in = new MyScan(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskT3 solver = new TaskT3();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskT3 {
        public void solve(int testNumber, MyScan in, PrintWriter out) {
            int n = in.nextInt();


            Map<Integer, Integer>[] pairs = new Map[n];
            for (int t = 0; t < n; t++) {
                pairs[t] = new HashMap<>();
            }
            int[][] inp = new int[2][n - 1];
            int xx = 0;
            for (int l = 0; l < n; l++) {
                int s = in.nextInt();
                if (s != 0) {
                    s--;
                    inp[0][xx] = s;
                    inp[1][xx] = l;
                    xx++;
                }
            }
            Tree t = new Tree(TreeReader.pn(inp, n));

            int[] sum = new int[n];
            int[] invalid = new int[n];
            t.setOnRemove(l -> {
                int ps = sum[l[0]];
                if (l[2] != -1) {
                    pairs[l[0]].put(l[2], ps);
                    pairs[l[2]].put(l[0], ps ^ 1);
                    if (ps == 0) {
                        invalid[l[0]]++;
                    }
                    if (ps == 1) {
                        invalid[l[2]]++;
                    }
                    sum[l[2]] ^= ps;
                    sum[l[2]] ^= 1;
                }
            });
            t.dfs(0);

            if (n % 2 == 0) {
                out.println("NO");
                return;
            }


            ArrayList<Integer> pm = new ArrayList<>();
            for (int l = 0; l < n; l++) {
                if (invalid[l] == 0) {
                    pm.add(l);
                }
            }

            ArrayList<Integer> res = new ArrayList<>();
            boolean[] del = new boolean[n];
            while (pm.size() > 0) {
                int k = pm.remove(pm.size() - 1);
                res.add(k);
                del[k] = true;
                for (int nn : t.data[k]) {
                    if (del[nn]) continue;
                    Integer lt = pairs[nn].remove(k);
                    if (lt != null && lt == 0) {
                        invalid[nn]--;
                    }
                    if (invalid[nn] == 0) {
                        pm.add(nn);
                    }
                }
            }
            if (res.size() == n) {

                out.println("YES");
                for (int l : res) {
                    out.println((l + 1) + " ");
                }
            } else {
                out.println("NO");
            }


        }

    }

    static class MyScan {
        private final InputStream in;
        private byte[] inbuf = new byte[1024];
        public int lenbuf = 0;
        public int ptrbuf = 0;

        public MyScan(InputStream in) {
            this.in = in;
        }

        private int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = in.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

    }

    static class TreeReader {
        public static int[][] pn(int[][] x, int n) {
            int[] ct = new int[n];
            int[][] res = new int[n][];
            for (int v : x[0]) {
                ct[v]++;
            }
            for (int v : x[1]) {
                ct[v]++;
            }
            for (int l = 0; l < n; l++) {
                res[l] = new int[ct[l]];
            }
            for (int i = 0; i < x[0].length; i++) {
                res[x[0][i]][--ct[x[0][i]]] = x[1][i];
                res[x[1][i]][--ct[x[1][i]]] = x[0][i];
            }
            return res;
        }

    }

    static class Tree {
        public int[][] data;
        Consumer<int[]> onAdd;
        Consumer<int[]> onRemove;

        public Tree(int[][] data) {
            this.data = data;
        }

        public void setOnRemove(Consumer<int[]> onRemove) {
            this.onRemove = onRemove;
        }

        private int[] dfs(int start, Consumer<int[]> onAdd, Consumer<int[]> onRemove) {
            Tree.P[] n = new Tree.P[data.length * 2];
            int toVisit = 0;
            n[toVisit++] = new Tree.P(start, true, -1);
            boolean[] vis = new boolean[data.length];
            vis[start] = true;
            int[] level = new int[data.length];
            while (toVisit > 0) {
                Tree.P ppr = n[--toVisit];
                if (!ppr.b) {
                    if (onRemove != null)
                        onRemove.accept(new int[]{ppr.ind, level[ppr.ind], ppr.parent});
                    continue;
                }
                ppr.b = false;
                int i = ppr.ind;
                n[toVisit++] = ppr;
                if (onAdd != null)
                    onAdd.accept(new int[]{ppr.ind, level[ppr.ind], ppr.parent});
                for (int kk : data[i]) {
                    if (!vis[kk]) {
                        vis[kk] = true;
                        level[kk] = level[i] + 1;
                        n[toVisit++] = new Tree.P(kk, true, i);
                    }
                }
            }
            return level;
        }

        public int[] dfs(int start) {
            return dfs(start, onAdd, onRemove);
        }

        public static class P {
            private boolean b;
            private final int ind;
            private final int parent;

            public P(int i, boolean b, int par) {
                this.ind = i;
                this.b = b;
                this.parent = par;
            }

        }

    }
}

