import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        Reader.init(System.in);
        StringBuilder out = new StringBuilder();
        int n = Reader.nextInt(), min = 0, c;
        while(n-- > 0) {
            c = Reader.nextInt();
            if(c > 500000)
                min = Math.max(min, 1000000 - c);
            else min = Math.max(min, c - 1);
        }
        out.append(min).append('\n');
        PrintWriter pw = new PrintWriter(System.out);
        pw.print(out);
        pw.close();
    }
    
}

class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) throws UnsupportedEncodingException {
        reader = new BufferedReader(
                new InputStreamReader(input, "UTF-8"));
        tokenizer = new StringTokenizer("");
    }
    
    static void init(String url) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(url));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
