import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author rizhiy
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        Set<Integer>[] a;
        TreeSet<Integer> s;
        PrintWriter out;

        int dfs(int v) {
            int ret = 1;
            Iterator<Integer> it = s.iterator();
            while (it.hasNext()) {
                int x = it.next();
                if (!a[v].contains(x)) {
                    s.remove(x);
                    ret += dfs(x);
                    if (s.contains(x)) {
                        Integer y = s.floor(x);
                        it = s.tailSet(y).iterator();
                    } else {
                        it = s.iterator();
                    }
                }
            }
            return ret;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            int n = in.nextInt();
            int m = in.nextInt();
            a = new TreeSet[n];
            for (int i = 0; i < n; i++) {
                a[i] = new TreeSet<>();
            }
            for (int i = 0; i < m; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                x--;
                y--;
                a[x].add(y);
                a[y].add(x);
            }
            s = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                s.add(i);
            }
            ArrayList<Integer> answ = new ArrayList<>();
            while (!s.isEmpty()) {
                int f = s.pollFirst();
                answ.add(dfs(f));
            }
            answ.sort(new Comparator<Integer>() {

                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            out.println(answ.size());
            for (int i : answ) {
                out.print(i + " ");
            }
            out.println();
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

