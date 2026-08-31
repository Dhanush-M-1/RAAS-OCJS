import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Woodcutters {

    public static void main(String[] args) throws IOException {
        InputScanner is = new InputScanner();
        int n = is.nextInt();
        int[] x = new int[n];
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = is.nextInt();
            h[i] = is.nextInt();
        }

        int ans = Math.min(2, n);
        int lastRightIndex = -1;
        for (int i = 1; i < n - 1; i++) {
            int leftSpace = x[i] - x[i - 1];
            int rightSpace = x[i + 1] - x[i];

            if (leftSpace > h[i]) {
                if (lastRightIndex == i - 1 && h[i - 1] + h[i] >= leftSpace) {
                    if (rightSpace > h[i]) {
                        ans++;
                        lastRightIndex = i;
                    }
                } else ans++;
            } else {
                if (rightSpace > h[i]) {
                    ans++;
                    lastRightIndex = i;
                }
            }
        }
        System.out.println(ans);
    }

    static class InputScanner {

        BufferedReader br;
        StringTokenizer st;

        public InputScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            String next = next();
            return Integer.parseInt(next);
        }

        public long nextLong() throws IOException {
            String next = next();
            return Long.parseLong(next);
        }
    }
}
