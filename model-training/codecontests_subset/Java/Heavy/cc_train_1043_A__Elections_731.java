import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = System.in;
        // InputStream inputStream = new FileInputStream(new File("input.txt"));
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        TaskA solver = new TaskA();
        solver.solve(in, out);
        out.close();
    }

    static class TaskA {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int[] votes = new int[n];
            for (int i = 0; i < n; i++) {
                int vote = in.nextInt();
                votes[i] = vote;
                sum += vote;
                if (max < vote) max = vote;
            }

            // getting maximum vote
            int needVotes = 0;
            for (int i = 0; i < n; i++) {
                needVotes += max - votes[i];
            }

            if (needVotes > sum) {
                System.out.println(max  );
                return;
            }

            int delta = sum + 1 - needVotes;
            int moreVotes = (int) Math.ceil(delta * 1.0 / n) + max;
            System.out.println(moreVotes);
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

