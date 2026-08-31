import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.Collection;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStream;

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
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        HashSet<Long> edges = new HashSet<>();
        SortedSet<Integer> candidates = new TreeSet<>();

        public void solve(int testNumber, Input in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();

            for (int i = 0; i < m; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                if (x < y) {
                    int temp = y;
                    y = x;
                    x = temp;
                }
                edges.add((long) x * 1000000 + y);
            }

            Queue<Integer> queue = new LinkedList<>();
            boolean[] used = new boolean[n];
            int[] count = new int[n];
            int current = -1;
            for (int i = 0; i < n; i++) {
                candidates.add(i);
            }
            List<Integer> toDelete = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    continue;
                }
                candidates.remove(i);
                current++;
                queue.add(i);
                used[i] = true;
                count[current]++;
                while (!queue.isEmpty()) {
                    Integer p = queue.poll();
                    toDelete.clear();
                    for (int to : candidates) {
                        if (used[to])
                            continue;
                        int x = p;
                        int y = to;
                        if (x < y) {
                            int temp = y;
                            y = x;
                            x = temp;
                        }
                        long id = (long) x * 1000000 + y;
                        if (edges.contains(id)) {
                            continue;
                        }
                        used[to] = true;
                        count[current]++;
                        queue.add(to);
                        toDelete.add(to);
                    }
                    for (int x : toDelete) {
                        candidates.remove(x);
                    }
                }
            }
            out.println(current + 1);
            Arrays.sort(count, 0, current + 1);
            for (int i = 0; i < current + 1; i++) {
                out.print(count[i] + " ");
            }
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

