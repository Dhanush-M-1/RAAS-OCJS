/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author jovfer
 */
public class TaskC {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        TaskC solver = new TaskC();
        solver.open();
        // long time = System.currentTimeMillis();
        solver.solve();
        // if (!"true".equals(System.getProperty("ONLINE_JUDGE"))) {
        // System.out.println("Spent time: "
        // + (System.currentTimeMillis() - time));
        // }
        solver.close();
    }

    public void open() throws IOException {
        //TODO
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        // in = new BufferedReader(new FileReader("gcd.in"));
        // out = new PrintWriter(new FileWriter("gcd.out"));
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    boolean doStep(Position step) {
        if (truePos.contains(step)) {
            Integer last = solve.get(step);
            if (last == null || last > step.step) {
                solve.put(step.clone(), step.step);
                queue.add(step.clone());
                return true;
            }
        }
        return false;
    }

    class Segment implements Comparable<Segment> {

        public int left, right, ind;

        public Segment() throws IOException {
            ind = nextInt();
            left = nextInt();
            right = nextInt();
        }

        public Segment(boolean f) {
            ind = sz + 1;
            left = sz + 1;
            right = sz + 1;
        }

        @Override
        public String toString() {
            return left + " " + right + " " + ind;
        }

        @Override
        public int compareTo(Segment o) {
            int dind = ind - o.ind;
            if (dind == 0) {
                int dl = left - o.left;
                if (dl == 0) {
                    return -right + o.right;
                } else {
                    return dl;
                }
            } else {
                return dind;
            }
        }
    }

    class Position implements Comparable<Position> {

        int x, y, step;
        /*
         private Position(int x, int y) {
         this.x = x;
         this.y = y;
         }*/

        @Override
        public String toString() {
            return x + " " + y + " step=" + step;
        }

        private Position(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        protected Position clone() {
            return new Position(x, y, step);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() == Position.class) {
                return ((Position) obj).x == x && ((Position) obj).y == y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 53 * hash + this.x;
            hash = 53 * hash + this.y;
            return hash;
        }

        @Override
        public int compareTo(Position o) {
            int dx = x - o.x;
            if (dx == 0) {
                return y - o.y;
            } else {
                return dx;
            }
        }
    }
    static final int sz = (int) 1e9;
    Set<Position> truePos = new TreeSet<Position>();
    Map<Position, Integer> solve = new TreeMap<Position, Integer>();
    Queue<Position> queue = new LinkedList<Position>();

    public void solve() throws NumberFormatException, IOException {
        int x0 = nextInt(), y0 = nextInt(), x1 = nextInt(), y1 = nextInt();
        int n = nextInt();
        Segment[] sgmInp = new Segment[n + 1];
        for (int i = 0; i < n; i++) {
            sgmInp[i] = new Segment();
        }
        sgmInp[n] = new Segment(true);
        Arrays.sort(sgmInp);


        int ind = sgmInp[0].ind;
        int left = sgmInp[0].left, right = sgmInp[0].right;
        for (int i = 0; i < sgmInp.length; i++) {
            Segment sgm = sgmInp[i];
            if (sgm.ind == ind && sgm.left <= right + 1) {
                right = Math.max(right, sgm.right);
            } else {
                for (int j = left; j <= right; j++) {
                    truePos.add(new Position(ind, j, sz));
                }
                ind = sgm.ind;
                left = sgm.left;
                right = sgm.right;
            }
        }

        queue.add(new Position(x0, y0, 0));
        Position finish = new Position(x1, y1, sz);
        while (!queue.isEmpty()) {
            Position curPos = queue.poll();
            {
                Position step = curPos.clone();
                step.step++;
                if (step.x > 1) {
                    step.x--;
                    doStep(step);

                    if (step.y > 1) {
                        step.y--;
                        doStep(step);
                        step.y++;
                    }

                    if (step.y < sz) {
                        step.y++;
                        doStep(step);
                        step.y--;
                    }

                    step.x++;
                }

                if (step.x < sz) {
                    step.x++;
                    doStep(step);
                    if (step.y > 1) {
                        step.y--;
                        doStep(step);
                        step.y++;
                    }

                    if (step.y < sz) {
                        step.y++;
                        doStep(step);
                        step.y--;
                    }

                    step.x--;
                }

                if (step.y > 1) {
                    step.y--;
                    doStep(step);
                    step.y++;
                }

                if (step.y < sz) {
                    step.y++;
                    doStep(step);
                    step.y--;
                }


            }
        }
        if (solve.containsKey(finish)) {
            out.println(solve.get(finish));
        } else {
            out.println(-1);
        }

    }

    public void close() {
        out.flush();
        out.close();
    }
}
