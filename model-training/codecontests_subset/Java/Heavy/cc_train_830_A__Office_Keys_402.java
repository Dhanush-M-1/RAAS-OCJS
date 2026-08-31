import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        Reader.init(System.in);
        StringBuilder out = new StringBuilder();
        int ps = Reader.nextInt(), ks = Reader.nextInt(), i;
        long f = Reader.nextLong(), pp[] = new long[ps], kk[] = new long[ks];
        for(i = 0; i < ps; i++)
            pp[i] = Reader.nextLong();
        for(i = 0; i < ks; i++)
            kk[i] = Reader.nextLong();
        Arrays.sort(pp);
        Arrays.sort(kk);
        int i1 = 0;
        long min = Math.abs(pp[0] - kk[0]) + Math.abs(pp[ps - 1] - kk[ps - 1]), c;
        for(i = 1; i + ps - 1 < ks; i++) {
            c = Math.abs(pp[0] - kk[i]) + Math.abs(pp[ps - 1] - kk[i + ps - 1]);
            if(c < min) {
                min = c;
                i1 = i;
            }
        }
        long sum = 0, max;
        for(i = 0; i < ps; i++) {
            min = Math.min(pp[i], f);
            max = Math.max(pp[i], f);
            c = max - min;
            if(kk[i + i1] < min)
                c += 2 * (min - kk[i + i1]);
            else if(kk[i + i1] > max)
                c += 2 * (kk[i + i1] - max);
            sum = Math.max(sum, c);
        }
        out.append(sum).append('\n');
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