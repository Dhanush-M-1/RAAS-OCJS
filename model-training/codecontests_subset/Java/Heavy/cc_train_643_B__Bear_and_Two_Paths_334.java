
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

public class D {

    public static void main(String[] args) {

        class InputReader {
            private BufferedReader reader;
            private StringTokenizer tokenizer;

            public InputReader(InputStream stream) {
                reader = new BufferedReader(new InputStreamReader(stream));
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

            public long nextLong() {
                return Long.parseLong(next());
            }
        }

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        if (k < n + 1 || n==4) out.print(-1);
        else {
            out.print(a + " " + c + " ");

            for (int i = 1; i <= n; i++) {
                if (i != a && i != b && i != c && i != d) out.print(i + " ");
            }
            out.print(d + " " + b + " ");
            out.println();
            out.print(c + " "); out.print(a + " ");
            for (int i = 1; i <= n; i++) {
                if (i != a && i != b && i != c && i != d ) out.print(i + " ");
            }
            out.print( b + " " + d);
        }
        out.close();
    }



}
