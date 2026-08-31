import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InitialBet {

    public static void main(String[] args) {
        try {
            int sum = 0;
            InputScanner scanner = new InputScanner();
            for (int i = 0; i < 5; i++) sum += scanner.nextInt();
            if (sum%5==0 && sum>0){
                System.out.println(sum/5);
                return;
            }
            System.out.println("-1");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            next.length();
            return Integer.parseInt(next);
        }
    }
}