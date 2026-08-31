import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by Юлька on 25.01.15.
 */
public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += reader.nextInt();
        }

        int ans = 0;

        if (sum % 5 == 0 && sum != 0) {
            ans = sum / 5;
        } else {
            ans = -1;
        }

        System.out.println(ans);
    }


}


class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String nextLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
