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
        char[] c = Reader.next().toCharArray();
        int n = Reader.nextInt();
        boolean f[] = new boolean[2];
        String str;
        while(n-- > 0) {
            str = Reader.next();
            if(str.charAt(0) == c[0] && str.charAt(1) == c[1]) {
                System.out.println("YES");
                return;
            }
            if(str.charAt(0) == c[1])
                f[1] = true;
            if(str.charAt(1) == c[0])
                f[0] = true;
            if(f[0] && f[1]) {
                System.out.println("YES");
                return;
            }
        }
        out.append("NO\n");
        PrintWriter p = new PrintWriter(System.out);
        p.print(out);
        p.close();
    }
    
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) throws UnsupportedEncodingException {
        reader = new BufferedReader(
                     new InputStreamReader(input, "UTF-8") );
        tokenizer = new StringTokenizer("");
    }
    
    static void init(String fileUrl) throws UnsupportedEncodingException, FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileUrl));
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    
    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}