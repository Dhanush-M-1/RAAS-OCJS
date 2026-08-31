import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader reader = new FastReader();
    private static final PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static void closeStreams() {
        try {
            reader.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.close();
    }

    private static void solve() {
        int k = reader.nextInt();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] mono = new int[n];
        for (int i = 0; i < n; i++)
            mono[i] = reader.nextInt();
        int[] poly = new int[m];
        for (int i = 0; i < m; i++)
            poly[i] = reader.nextInt();
        LinkedList<Integer> steps = new LinkedList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (mono[i] == 0) {
                steps.add(0);
                i++;
                k++;
            } else if (poly[j] == 0) {
                steps.add(0);
                j++;
                k++;
            } else if (mono[i] <= k) {
                steps.add(mono[i]);
                i++;
            } else if (poly[j] <= k) {
                steps.add(poly[j]);
                j++;
            } else {
                writer.println(-1);
                return;
            }
        }
        while (i < n) {
            if (mono[i] == 0) {
                steps.add(0);
                i++;
                k++;
            } else if (mono[i] <= k) {
                steps.add(mono[i]);
                i++;
            } else {
                writer.println(-1);
                return;
            }
        }
        while (j < m) {
            if (poly[j] == 0) {
                steps.add(0);
                j++;
                k++;
            } else if (poly[j] <= k) {
                steps.add(poly[j]);
                j++;
            } else {
                writer.println(-1);
                return;
            }
        }
        for (int step : steps)
            writer.print(step + " ");
        writer.println();
    }

    public static void main(String[] args) {
        int tests = reader.nextInt();
        while (tests-- != 0)
            solve();
        closeStreams();
    }
}
