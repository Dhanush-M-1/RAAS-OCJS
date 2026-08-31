
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author pvasilyev
 * @since 20 Nov 2016
 */
public class C {

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter writer = new PrintWriter(System.out);

        solve(reader, writer);

        reader.close();
        writer.close();
    }

    private static void solve(final BufferedReader reader, final PrintWriter writer) throws IOException {
        String line = reader.readLine();
        String[] split = line.split(" ");
        final int n = Integer.valueOf(split[0]);
        final int k = Integer.valueOf(split[1]);
        final int s = Integer.valueOf(split[2]);
        final int timeLimit = Integer.valueOf(split[3]);
        int[][] cars = new int[n][2];
        for (int i = 0; i < cars.length; i++) {
            line = reader.readLine();
            split = line.split(" ");
            cars[i][0] = Integer.valueOf(split[0]);
            cars[i][1] = Integer.valueOf(split[1]);
        }
        line = reader.readLine();
        split = line.split(" ");
        Integer[] g = new Integer[k];
        for (int i = 0; i < g.length; i++) {
            g[i] = Integer.valueOf(split[i]);
        }
        Arrays.sort(g);
        Integer[] distances = new Integer[k+1];
        distances[0] = g[0];
        for (int i = 1; i < g.length; ++i) {
            distances[i] = g[i] - g[i-1];
        }
        distances[k] = s - g[k-1];
        Arrays.sort(distances);
        long[] prefixSum = new long[distances.length+1];
        for (int i = 1; i <= distances.length; ++i) {
            prefixSum[i] = prefixSum[i-1] + distances[i-1];
        }

        int minRent = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int volume = cars[i][1];
            if (volume < distances[k]) {
                // this guy won't be able to pass the longest distance: he will be short of gasoline
                continue;
            }
            final long time;
            if (volume > 2 * distances[k]) {
                // this guy can run whole path in fast mode:
                time = s;
            } else {
                // at some point we can't afford fast mode and we need to turn on slow mode:
                final int position = binarySearch(distances, volume, 0, distances.length);
                final long timeInFastMode = prefixSum[position];
                final long timeInSlowMode = ((prefixSum[prefixSum.length - 1] - prefixSum[position]) * 3
                        - (prefixSum.length -1 - position) * volume);
                time = timeInFastMode + timeInSlowMode;
            }
            boolean canRun = time <= timeLimit;
            if (canRun) {
                minRent = Math.min(minRent, cars[i][0]);
            }
        }

        if (minRent != Integer.MAX_VALUE) {
            writer.println(minRent);
        } else {
            writer.println(-1);
        }
    }

    /**
     * Should return the first position in <code>distances</code>, when we can't use fast mode for whole distance and we
     * should downgrade till slow mode to save some gasoline.
     * <p/>
     * I.e. the minimal index <code>i</code>, such as: 2 * <code>distances[i]</code> &gt; <code>volume</code>.
     */
    private static int binarySearch(final Integer[] distances, final int volume, final int start, final int end) {
        if (end - start < 1) {
            return start;
        } else if (2 * distances[start] > volume) {
            return start;
        } else {
            final int mid = (start + end) / 2;
            if (2 * distances[mid] <= volume) {
                return binarySearch(distances, volume, mid+1, end);
            } else {
                return binarySearch(distances, volume, start, mid);
            }
        }
    }

}
