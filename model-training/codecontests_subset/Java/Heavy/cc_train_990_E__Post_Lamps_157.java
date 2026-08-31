import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Set;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyBufferedReader in = new MyBufferedReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, MyBufferedReader in, PrintWriter out) {
            int[] d = in.getALineOfInts(3);
            int n = d[0];
            int m = d[1];
            int k = d[2];
            int[] blocked = in.getALineOfInts(m);
            int[] costs = in.getALineOfInts(k);

            if (m > 0 && blocked[0] == 0) {
                out.println(-1);
                return;
            }

            Set<Integer> blockedSet = Arrays.stream(blocked).mapToObj(i -> i).collect(Collectors
                                                                                          .toCollection(HashSet::new));
            int[] floors = new int[n + 1];
            int prevFree = 0;
            int maxGap = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!blockedSet.contains(i)) {
                    maxGap = Math.max(maxGap, i - prevFree);
                    prevFree = i;
                }

                floors[i] = prevFree;
            }

            if (k < maxGap) {
                out.println(-1);
                return;
            }

            long minCost = Long.MAX_VALUE;
            for (long i = maxGap; i <= k; i++) {
                long numNeeded = 0;
                long currPos = 0;
                do {
                    numNeeded++;
                    currPos = (currPos + i) >= n ? n : floors[(int) (currPos + i)];
                } while (currPos < n);

                long cost = numNeeded * ((long) costs[(int) (i - 1)]);
                minCost = Math.min(minCost, cost);
            }

            out.println(minCost);
        }

    }

    static class MyBufferedReader {
        BufferedReader in;

        public MyBufferedReader(InputStream s) {
            this.in = new BufferedReader(new InputStreamReader(s));
        }

        public MyBufferedReader(BufferedReader in) {
            this.in = in;
        }

        public int[] getALineOfInts(int numExpected) {
            if (numExpected == 0) {
                try {
                    in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new int[0];
            }

            int[] res = new int[numExpected];
            StringTokenizer st = null;
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < numExpected; i++)
                res[i] = Integer.parseInt(st.nextToken());
            return res;
        }

    }
}

