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
    
    static long f, pp[], kk[];
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        Reader.init(System.in);
        StringBuilder out = new StringBuilder();
        int ps = Reader.nextInt(), ks = Reader.nextInt(), i;
        f = Reader.nextLong();
        pp = new long[ps];
        kk = new long[ks];
        for(i = 0; i < ps; i++)
            pp[i] = Reader.nextLong();
        for(i = 0; i < ks; i++)
            kk[i] = Reader.nextLong();
        Arrays.sort(pp);
        Arrays.sort(kk);
        int fk = 0;
        long min = dist(0, 0) + dist(ps - 1, ps - 1), c;
        for(i = 1; i + ps - 1 < ks; i++) {
            c = dist(0, i) + dist(ps - 1, i + ps - 1);
            if(c < min) {
                min = c;
                fk = i;
            }
        }
        long maxmin = 0;
        for(i = 0; i < ps; i++)
            maxmin = Math.max(maxmin, dist(i, i + fk));
        out.append(maxmin).append('\n');
        PrintWriter p = new PrintWriter(System.out);
        p.print(out);
        p.close();
    }
    
    static long dist(int p, int k) {
        long min = Math.min(pp[p], f), max = Math.max(pp[p], f);
        long dist = max - min;
        if(kk[k] < min)
            dist += 2 * (min - kk[k]);
        else if(kk[k] > max)
            dist += 2 * (kk[k] - max);
        return dist;
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