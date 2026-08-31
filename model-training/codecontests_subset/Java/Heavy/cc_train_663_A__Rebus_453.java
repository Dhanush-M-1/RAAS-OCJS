import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        solve(1, in, out);

        out.close();
    }

    private static void solve(int n, InputReader in, PrintWriter out) {
        while (n > 0) {
            solve(in, out);
            n--;
        }
    }

    private static void solve(InputReader in, PrintWriter out) {
        int p = 1, n, j = 0;
        int a[] = new int[105];
        Arrays.fill(a, 0);
        char c;
        a[j++] = 1;
        String t = in.next();
        while(!t.equals("=")){
            if(t.equals("-")){
                p--;
                a[j++] = -1;
            }
            if(t.equals("+")){
                p++;
                a[j++] = 1;
            }
            t = in.next();
        }
        n = in.nextInt();
        for(int i=0;i<j;i++)
        {
            if(a[i]>0){
                while (p<n && a[i]<n){
                    a[i]++;
                    p++;
                }
            }
            else {
                while (p>n&&a[i]<0 && a[i]>-n){
                    a[i]--;
                    p--;
                }
            }
        }
        if (p != n) { 
            System.out.println("Impossible");
            return;
        }
        System.out.println("Possible");
        for(int i=0;i<j;i++){
            System.out.print((i != 0 ? (a[i]<0 ? "- " : "+ ") : ""));
            System.out.print(Math.abs(a[i])+" ");
        }
        System.out.println("= " + n);
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}