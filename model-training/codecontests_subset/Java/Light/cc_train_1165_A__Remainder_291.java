import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(System.in);
        int n = reader.nextInt();
        int x = reader.nextInt();
        int y = reader.nextInt();
        StringBuilder s = new StringBuilder(reader.next());
        s.reverse();

        int count = 0;
        for (int i = 0; i < y; i++) {
            if (s.charAt(i) != '0') count++;
        }
        if (s.charAt(y) != '1') count++;

        for (int i = y + 1; i < x; i++) {
            if (s.charAt(i) != '0') count++;
        }

        System.out.println(count);
    }
}

class Reader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    Reader(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}