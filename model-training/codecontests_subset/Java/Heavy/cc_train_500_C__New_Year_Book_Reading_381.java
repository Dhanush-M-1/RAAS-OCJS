import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
        InputReader r = new InputReader(System.in);
        int n = r.nextInt();
        int m = r.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < w.length; i++) {
            w[i] = r.nextInt();
        }
        int[] arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        int[] order = new int[n];
        Arrays.fill(order, -1);
        boolean[] vis = new boolean[n];
        int next = 0;
        for (int i = 0; i < m; i++) {
            if (vis[arr[i] - 1])
                continue;
            vis[arr[i] - 1] = true;
            order[next++] = arr[i];
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int index = -1;
            for (int j = 0; j < n; j++)
                if (order[j] == arr[i])
                    index = j;
            for (int j = 0; j < index; j++) {
                res += w[order[j] - 1];
            }
            for (int j = index; j > 0; j--)
                order[j] = order[j - 1];
            order[0] = arr[i];
        }
        System.out.println(res);
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
