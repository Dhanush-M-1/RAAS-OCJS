import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class A {

    private void solve() throws IOException {
        int r1 = nextInt();
        int r2 = nextInt();
        int c1 = nextInt();
        int c2 = nextInt();
        int d1 = nextInt();
        int d2 = nextInt();
        
        for (int i = 1; i <= 9; i++)
            for (int j = 1; j <= 9; j++)
                for (int k = 1; k <= 9; k++)
                    for (int z = 1; z <= 9; z++)
                    {
                        if (i == j || i == k || i == z || j == k || j == z || k == z) continue;
                        if (i + k == c1 && j + z == c2 && i + j == r1 && k + z == r2 && i + z == d1 && j + k == d2) {
                            pl(i + " " + j);
                            pl(k + " " + z);
                            return;
                        }
                    }
        pl(-1);
    }

    public static void main(String[] args) {
        new A().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private void p(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) writer.print(' ');
            writer.flush();
            writer.print(objects[i]);
            writer.flush();
        }
    }

    private void pl(Object... objects) {
        p(objects);
        writer.flush();
        writer.println();
        writer.flush();
    }
}
