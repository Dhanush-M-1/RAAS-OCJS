
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(final String[] args) {
        final FastScanner scanner = new FastScanner(System.in);
        final int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            final Map<Integer, List<Pair>> lCamels = new HashMap<>();
            final Map<Integer, List<Pair>> rCamels = new HashMap<>();
            final int n = scanner.nextInt();
            long sum = 0;
            for (int j = 0; j < n; j++) {
                final int k = scanner.nextInt();
                final int l = scanner.nextInt();
                final int r = scanner.nextInt();
                sum += Math.min(l, r);
                if (l >= r) {
                    lCamels.computeIfAbsent(k, v -> new ArrayList<>()).add(new Pair(l, r));
                } else {
                    final int tmp = n - k;
                    rCamels.computeIfAbsent(tmp, v -> new ArrayList<>()).add(new Pair(l, r));
                }
            }

            final PriorityQueue<Pair> lQueue = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.l - pair.r));
            final PriorityQueue<Pair> rQueue = new PriorityQueue<>(Comparator.comparingLong(pair -> pair.r - pair.l));
            for (int j = 1; j <= n; j++) {
                if (lCamels.containsKey(j)) {
                    lQueue.addAll(lCamels.get(j));
                    while (lQueue.size() > j) {
                        lQueue.poll();
                    }
                }

                if (rCamels.containsKey(j)) {
                    rQueue.addAll(rCamels.get(j));
                    while (rQueue.size() > j) {
                        rQueue.poll();
                    }
                }
            }

            sum += lQueue.stream().mapToLong(pair -> pair.l - pair.r).sum()
                + rQueue.stream().mapToLong(pair -> pair.r - pair.l).sum();
            System.out.println(sum);
        }
    }

    private static class Pair {
        final long l;
        final long r;

        Pair(final long l, final long r) {
            this.l = l;
            this.r = r;
        }
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
