import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author beginner1010
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        int[] height;
        int[] parent;

        int root(int x) {
            return parent[x] = (parent[x] == x ? x : root(parent[x]));
        }

        void join(int idx1, int idx2) {
            int idx1Parent = root(idx1);
            int idx2Parent = root(idx2);
            if (idx1Parent == idx2Parent)
                return;
            if (height[idx1Parent] > height[idx2Parent]) {
                parent[idx2Parent] = idx1Parent;
            } else {
                parent[idx1Parent] = idx2Parent;
                if (height[idx1Parent] == height[idx2Parent])
                    height[idx2Parent]++;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();

            int[] cols = new int[n];
            height = new int[m];
            parent = new int[m];
            ArrayList<Integer>[] samples = new ArrayList[m];
            for (int i = 0; i < parent.length; i++)
                parent[i] = i;
            for (int i = 0; i < samples.length; i++)
                samples[i] = new ArrayList<Integer>();
            Arrays.fill(height, 0);
            Arrays.fill(cols, -1);
            for (int i = 0; i < q; i++) {
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                samples[c].add(r);
                if (cols[r] == -1) {
                    cols[r] = c;
                    if (height[c] == 0)
                        height[c]++;
                } else {
                    join(c, cols[r]);
                }
            }

            HashSet<Integer> bagRepresentatives = new HashSet<>();
            HashMap<Integer, HashSet<Integer>> sampleBags = new HashMap<>();
            for (int i = 0; i < m; i++) {
                if (parent[i] == i && height[i] > 0) {
                    bagRepresentatives.add(i);
                    sampleBags.put(i, new HashSet<>());
                }
            }

            for (int c = 0; c < m; c++) {
                int rep = root(c);
                if (bagRepresentatives.contains(rep) == true) {
                    HashSet<Integer> bag = sampleBags.get(rep);
                    for (int r : samples[c]) {
                        bag.add(r);
                    }
                    sampleBags.put(rep, bag);
                }
            }

            int coveredSamples = 0;
            for (int rep : sampleBags.keySet()) {
                coveredSamples += sampleBags.get(rep).size();
            }

            int ans = n - coveredSamples;
            int components = 0;
            for (int c = 0; c < m; c++) {
                if (parent[c] == c)
                    components++;
            }
            ans += components - 1;
            out.println(ans);
            return;
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

