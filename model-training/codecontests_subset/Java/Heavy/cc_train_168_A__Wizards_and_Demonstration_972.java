import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskA implements Runnable {
    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    public static void main(String[] args) {
        new Thread(new TaskA()).start();
    }

    private String next() throws Exception {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }

        return tokenizer.nextToken();
    }

    private int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);

            solve();

            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void solve() throws Exception {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();

        int desired = n * y / 100;
        if (n * y % 100 != 0) {
            desired++;
        }

        writer.println(Math.max(0, desired - x));
    }
}
