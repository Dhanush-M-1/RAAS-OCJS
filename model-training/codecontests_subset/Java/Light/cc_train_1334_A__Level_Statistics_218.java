import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            int lastPlay = 0;
            int lastClear = 0;
            boolean isFalse = false;
            for (int j = 0; j < n; j++) {
                StringTokenizer tokenizer = new StringTokenizer(f.readLine());
                int plays = Integer.parseInt(tokenizer.nextToken());
                int clears = Integer.parseInt(tokenizer.nextToken());
                if (plays - lastPlay < clears - lastClear || plays < lastPlay || clears < lastClear) {
                    isFalse = true;
                }
                lastPlay = plays;
                lastClear = clears;
            }

            if (isFalse) {
                out.println("NO");
                continue;
            }

            out.println("YES");
        }

        out.close();
    }
}
