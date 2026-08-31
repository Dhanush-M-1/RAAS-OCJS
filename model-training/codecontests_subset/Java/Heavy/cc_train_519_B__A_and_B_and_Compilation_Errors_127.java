import java.io.*;
import java.util.*;

public class Codeforces {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, Exception {
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        Reader.init(System.in);
        int n = Reader.nextInt();
        int []a = new int[n];
        int []b = new int[n-1];
        int []c = new int[n-2];
        for (int i = 0; i <n ; i++) {
            a[i] = Reader.nextInt();
        }
        for (int i = 0; i <n-1 ; i++) {
            b[i] = Reader.nextInt();
        }
        for (int i = 0; i <n-2 ; i++) {
            c[i] = Reader.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        for (int i = 0; i <a.length-1; i++) {
            if (a[i] != b[i]) {
                System.out.println(a[i]);
                break;
            } else {
                if (i == a.length - 2) {
                    System.out.println(a[a.length - 1]);
                }
            }
        }
        for (int i = 0; i <b.length-1; i++) {
            if(b[i]!=c[i]){
                System.out.println(b[i]);
                break;
            }
            else{
                if(i==b.length-2){
                    System.out.println(b[b.length-1]);
                }
            }
        }

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