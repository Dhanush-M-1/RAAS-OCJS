import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Collections;
import java.io.InputStream;
import java.util.TreeSet;
import java.util.SortedSet;


/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Zayakin Andrey
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Input in = new Input(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        int n;

        public void solve(int testNumber, Input in, PrintWriter out) {
            n = in.nextInt();
            int m = in.nextInt();
            HashSet<Long> notEdges = new HashSet<>(m);
            long edges = (long) n * (n - 1) / 2 - m;
            for (int i = 0; i < m; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                if (x > y) {
                    int swap = x;
                    x = y;
                    y = swap;
                }
                long key = (long) x * n + y;
                notEdges.add(key);
            }
            boolean[] used = new boolean[n];
            ArrayList<Integer> count = new ArrayList<>();

            ArrayList<Integer> shuffle = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                shuffle.add(i);
            }
            Collections.shuffle(shuffle);
            SortedSet<Integer> notUsed = new TreeSet<>(shuffle);

            Queue<Integer> queue = new LinkedList<>();


            for (int h = 0; h < n; h++) {
                int i = shuffle.get(h);
                if (!used[i]) {
                    queue.add(i);
                    used[i] = true;
                    notUsed.remove(i);
                    int result = 0;
                    while (!queue.isEmpty()) {
                        int p = queue.poll();
                        result++;
                        ArrayList<Integer> toRemove = new ArrayList<>(0);
                        for (int to : notUsed) {
                            if (used[to]) {
                                continue;
                            }
                            int x = p;
                            int y = to;
                            if (x > y) {
                                int swap = x;
                                x = y;
                                y = swap;
                            }
                            long key = (long) x * n + y;
                            if (notEdges.contains(key)) {
                                continue;
                            }
                            toRemove.add(to);
                            queue.add(to);
                            used[to] = true;
                        }
                        for (int rem : toRemove) {
                            notUsed.remove(rem);
                        }
                    }
                    count.add(result);
                }
            }
            Collections.sort(count);
            out.println(count.size());
            for (int x : count)
                out.println(x + " ");
        }

    }

    static class Input {
        private StringTokenizer tokenizer = null;
        private BufferedReader reader;

        public Input(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(nextLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

    }
}