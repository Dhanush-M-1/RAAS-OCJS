import java.io.*;
import java.util.*;

public class Main {
    private static void solver(InputReader sc, PrintWriter out) {
            int n =  sc.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            for(int i=0; i<n; i++){
                a[i] = sc.nextLong();
                b[i] = sc.nextLong();
            }
            if(n==1) {
                out.println("1");
                return;
            }
            int count=2;
            for(int i=1; i<n; i++){
                long l = a[i]-b[i];
                long r = a[i]+b[i];
                if(i<n-1) {
                    if (l > a[i - 1] ) {
                        count++;
                    }
                    else if(r < a[i + 1]){
                        count++;
                        a[i] += b[i];
                    }
                }
            }
            out.println(count);
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solver(in, out);
        out.close();

    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
}
