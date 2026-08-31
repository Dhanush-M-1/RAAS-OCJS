import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream input_stream = System.in;
        InputReader input_reader = new InputReader(input_stream);
        ProblemSolver solver = new ProblemSolver();
        solver.solve(input_reader, System.out);
    }

    private static class ProblemSolver {

        public void solve(InputReader input, PrintStream output) {
            int length = input.nextInt();
            String S = input.next();
            Map<String, Integer> count = new HashMap<>();
            for (int i=0;i+1<length;i++) {
                if (count.get(S.substring(i,i+2))==null) {
                    count.put(S.substring(i, i+2), 1);
                } else {
                    count.put(S.substring(i, i+2), count.get(S.substring(i,i+2))+1);
                }
            }
            String result = "";
            int max_count = -1;
            for (Map.Entry entry : count.entrySet()) {
                if (((Integer)entry.getValue())>max_count) {
                    max_count = (Integer)entry.getValue();
                    result = (String)entry.getKey();
                }
            }
            output.print(result);
        }
    }

    private static class InputReader {
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