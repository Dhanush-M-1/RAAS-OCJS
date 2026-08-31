import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Task348A {

    public static void main(String[] args) throws IOException {
        InputScanner is = new InputScanner();
        int n = is.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = is.nextInt();
        double sum = 0;
        int max  = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            sum += num[i];
            max = Math.max(max, num[i]);
        }
        double result = Math.ceil(sum/(double)(n-1));
        System.out.println(Math.max((int)result, max));
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
