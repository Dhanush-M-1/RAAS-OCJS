
import java.util.*;
import java.io.*;

public class Codeforces {

    static int arr[];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int r1 = Reader.nextInt(), r2 = Reader.nextInt();
        int c1 = Reader.nextInt(), c2 = Reader.nextInt();
        int d1 = Reader.nextInt(), d2 = Reader.nextInt();
        
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                if(j == i)
                    continue;
                for(int k = 1; k < 10; k++){
                    if(k == j || k == i)
                        continue;
                    for(int s = 1; s < 10; s++){
                        if(s == k || s == j || s == i)
                            continue;
                        
                        if(s+i == d1 && s+j == c2 && s+k == r2 && i+k == c1 && i+j == r1){
                            System.out.println(i + " " + j + "\n" + k + " " + s);
                            return;
                        }
                    }
                }
            }
        }
        
        System.out.println(-1);
    }
}

class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static byte nextByte() throws IOException {

        return Byte.parseByte(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
