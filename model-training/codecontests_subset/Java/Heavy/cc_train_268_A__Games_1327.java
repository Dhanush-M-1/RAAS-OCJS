import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by yassin on 28/02/2017.
 */
public class CF268 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        new CF268().solve(in, out);
        out.close();
    }

    public void solve(InputReader in, PrintWriter out) throws IOException {
        int n, result = 0, hostColor;
        n = in.nextInt();
        int[][] colors = new int[n][2];
        for (int i = 0; i < n; i++) {
            colors[i] = new int[]{in.nextInt(), in.nextInt()};
        }

        for (int i = 0; i < n; i++) {
            hostColor = colors[i][0];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (colors[j][1] == hostColor)
                    result++;
            }
        }
        out.println(result);
    }

    static class InputReader {
        public BufferedReader br;
        public StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
